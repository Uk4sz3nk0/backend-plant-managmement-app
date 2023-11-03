package com.engineers.plantmanagmementapp.security.serviceImpl;

import com.engineers.plantmanagmementapp.enums.TokenType;
import com.engineers.plantmanagmementapp.model.Role;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.record.AuthenticationRequest;
import com.engineers.plantmanagmementapp.record.AuthenticationResponse;
import com.engineers.plantmanagmementapp.record.RegisterRequest;
import com.engineers.plantmanagmementapp.repository.RoleRepository;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.security.AuthenticationService;
import com.engineers.plantmanagmementapp.security.JwtService;
import com.engineers.plantmanagmementapp.security.model.PlantManagerUser;
import com.engineers.plantmanagmementapp.security.model.Token;
import com.engineers.plantmanagmementapp.security.repository.TokenRepository;
import com.engineers.plantmanagmementapp.service.plantation.PlantationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final String BEARER_PREFIX = "Bearer ";
    private static final Integer TOKEN_BEGIN_INDEX = 7;
    private static final String OWNER_ROLE = "ROLE_OWNER";

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PlantationService plantationService;
    private final RoleRepository roleRepo;

    @Override
    public AuthenticationResponse registerUser(final RegisterRequest request) {
        var user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(getRole(request.role()));
        var savedUser = userRepository.saveAndFlush(user);
        if (request.role().equals(OWNER_ROLE)) {
            plantationService.createPlantation(request.plantation(), savedUser);
        }
        var appUser = new PlantManagerUser(user);
        var jwtToken = jwtService.generateToken(appUser);
        var refreshToken = jwtService.generateRefreshToken(appUser);
        saveUserToken(savedUser, jwtToken);
        return new AuthenticationResponse(user, jwtToken, refreshToken);
    }

    @Override
    public AuthenticationResponse authenticateUser(final AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = userRepository.findByEmail(request.email())
                .orElseThrow();
        var appUser = new PlantManagerUser(user);
        var jwtToken = jwtService.generateToken(appUser);
        var refreshToken = jwtService.generateRefreshToken(appUser);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return new AuthenticationResponse(user, jwtToken, refreshToken);
    }

    @Override
    public void refreshToken(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
            return;
        }
        refreshToken = authHeader.substring(TOKEN_BEGIN_INDEX);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            var appUser = new PlantManagerUser(user);
            if (jwtService.isTokenValid(refreshToken, appUser)) {
                var accessToken = jwtService.generateToken(appUser);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                new ObjectMapper().writeValue(response.getOutputStream(),
                        new AuthenticationResponse(user, accessToken, refreshToken));
            }
        }
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private Role getRole(final String role) {
        return roleRepo.findByName(role).orElseThrow();
    }
}
