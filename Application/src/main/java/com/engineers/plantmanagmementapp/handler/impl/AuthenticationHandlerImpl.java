package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.AuthenticationHandler;
import com.engineers.plantmanagmementapp.mapper.AuthenticationMapper;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationRequestDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationResponseDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.RegisterRequestDto;
import com.engineers.plantmanagmementapp.security.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationHandlerImpl implements AuthenticationHandler {

    private final AuthenticationService authService;

    @Override
    public AuthenticationResponseDto handleRegisterUser(final RegisterRequestDto request) {
        var authResponse = authService.registerUser(AuthenticationMapper.INSTANCE.map(request));
        return AuthenticationMapper.INSTANCE.map(authResponse);
    }

    @Override
    public AuthenticationResponseDto handleLoginUser(final AuthenticationRequestDto request) {
        var authResponse = authService.authenticateUser(AuthenticationMapper.INSTANCE.map(request));
        return AuthenticationMapper.INSTANCE.map(authResponse);
    }

    @Override
    public void handleRefreshToken(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        authService.refreshToken(request, response);
    }
}
