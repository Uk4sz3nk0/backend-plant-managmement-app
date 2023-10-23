package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationRequestDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationResponseDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.RegisterRequestDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationHandler {

    AuthenticationResponseDto handleRegisterUser(final RegisterRequestDto request);

    AuthenticationResponseDto handleLoginUser(final AuthenticationRequestDto request);

    void handleRefreshToken(final HttpServletRequest request, final HttpServletResponse response) throws IOException;
}
