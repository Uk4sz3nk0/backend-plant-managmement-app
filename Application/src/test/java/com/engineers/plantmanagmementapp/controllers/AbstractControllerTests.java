package com.engineers.plantmanagmementapp.controllers;

import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.security.JwtService;
import com.engineers.plantmanagmementapp.security.model.PlantManagerUser;
import io.jsonwebtoken.impl.JwtTokenizer;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

public abstract class AbstractControllerTests {

    protected static final Long USER_ID = 1L;
    protected static final String USER_EMAIL = "user123@gmail.com";
    protected static final String BEARER = "Bearer ";

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private JwtService jwtService;

    protected void isGivenUser(final Long id) {
        final User user = new User();
        user.setId(id);
        user.setEmail(USER_EMAIL);

        given(userRepository.findByEmail(USER_EMAIL)).willReturn(Optional.of(user));
    }

    protected String getJwtToken() {
        final User authUser = new User();
        authUser.setEmail(USER_EMAIL);
        authUser.setId(USER_ID);
        final PlantManagerUser plantManagerUser = new PlantManagerUser(authUser);
        return jwtService.generateToken(plantManagerUser);
    }
}
