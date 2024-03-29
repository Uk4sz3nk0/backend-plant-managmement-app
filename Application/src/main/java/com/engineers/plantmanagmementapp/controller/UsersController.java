package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.UsersHandler;
import com.engineers.plantmanagmementapp.rest.users.specification.api.UsersApi;
import com.engineers.plantmanagmementapp.rest.users.specification.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UsersController
 * <p>
 * Created on: 2023-11-08
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    private final UsersHandler usersHandler;

    @Override
    public ResponseEntity<Long> setUserRole(final Long userId, final String role) {
        log.info("Endpoint \"setUserRole\" has called");
        return ResponseEntity.ok(usersHandler.handleSetUserRole(userId, role));
    }

    @Override
    public ResponseEntity<List<EmployeeDto>> searchByEmail(final String searchPhrase) {
        log.info("Endpoint \"searchByEmail\" has called");
        return ResponseEntity.ok(usersHandler.handleSearchByEmail(searchPhrase));
    }
}
