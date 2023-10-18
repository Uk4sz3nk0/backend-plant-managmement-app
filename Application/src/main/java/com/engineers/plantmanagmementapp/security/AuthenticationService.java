package com.engineers.plantmanagmementapp.security;

import com.engineers.plantmanagmementapp.record.AuthenticationRequest;
import com.engineers.plantmanagmementapp.record.AuthenticationResponse;
import com.engineers.plantmanagmementapp.record.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {

    AuthenticationResponse registerUser(final RegisterRequest registerRequest);

    AuthenticationResponse registerUser(final AuthenticationRequest authenticationRequest);

    void refreshToken(final HttpServletRequest request, final HttpServletResponse response) throws IOException;
    
}
