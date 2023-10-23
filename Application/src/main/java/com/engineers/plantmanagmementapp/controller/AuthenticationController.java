package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.AuthenticationHandler;
import com.engineers.plantmanagmementapp.rest.authentication.specification.api.AuthenticationApi;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationRequestDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationResponseDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.RegisterRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationHandler authHandler;

    @Override
    public ResponseEntity<AuthenticationResponseDto> loginUser(final AuthenticationRequestDto request) {
        return ResponseEntity.ok(authHandler.handleLoginUser(request));
    }

    @Override
    public ResponseEntity<AuthenticationResponseDto> registerUser(final RegisterRequestDto request) {
        return ResponseEntity.ok(authHandler.handleRegisterUser(request));
    }

    @PostMapping("/auth/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authHandler.handleRefreshToken(request, response);
    }
}
