package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.UsersHandler;
import com.engineers.plantmanagmementapp.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Primary
@Service
public class UsersHandlerImpl implements UsersHandler {

    private final UsersService usersService;

    @Override
    public Long handleSetUserRole(final Long userId, final String role) {
        return usersService.setUserRole(userId, role);
    }
}
