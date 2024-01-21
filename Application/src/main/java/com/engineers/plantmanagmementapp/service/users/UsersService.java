package com.engineers.plantmanagmementapp.service.users;

import com.engineers.plantmanagmementapp.model.User;

import java.util.List;

public interface UsersService {

    Long setUserRole(final Long userId, final String role);

    List<User> searchByEmail(final String searchPhrase);
}
