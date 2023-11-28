package com.engineers.plantmanagmementapp.controllers;

import com.engineers.plantmanagmementapp.config.ApplicationConfig;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.security.JwtService;
import com.engineers.plantmanagmementapp.security.model.PlantManagerUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.io.FileUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

import static javax.crypto.Cipher.SECRET_KEY;
import static org.mockito.BDDMockito.given;

public abstract class AbstractControllerTests {

    protected static final Long USER_ID = 1L;
    protected static final Long BASE_ID = 1L;
    protected static final String USER_EMAIL = "user123@gmail.com";
    protected static final String BEARER_PREFIX = "Bearer ";

    private static final String CHARSET = "UTF-8";
    private static final String BASE_PATH = "classpath:controllers/";


    @Mock
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    protected void givenThereIsUser(final User user) {

        given(userRepository.findByEmail(USER_EMAIL)).willReturn(Optional.of(user));
        given(userRepository.findById(USER_ID)).willReturn(Optional.of(user));
    }

    protected String getJwtToken(final User authUser) {
        final PlantManagerUser plantManagerUser = new PlantManagerUser(authUser);
        return jwtService.generateToken(plantManagerUser);
    }

    protected User generateUser() {
        final User user = new User();
        user.setEmail(USER_EMAIL);
        user.setId(USER_ID);

        return user;
    }

    protected String getResourceAsString(final String path) throws IOException {
        return FileUtils.readFileToString(ResourceUtils.getFile(BASE_PATH + path), CHARSET);
    }


}
