package com.engineers.plantmanagmementapp.security.serviceImpl;

import com.engineers.plantmanagmementapp.record.AuthenticationRequest;
import com.engineers.plantmanagmementapp.record.AuthenticationResponse;
import com.engineers.plantmanagmementapp.record.RegisterRequest;
import com.engineers.plantmanagmementapp.security.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public AuthenticationResponse registerUser(final RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public AuthenticationResponse registerUser(final AuthenticationRequest authenticationRequest) {
        return null;
    }

    @Override
    public void refreshToken(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

    }
}
