package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.users.specification.model.EmployeeDto;

import java.util.List;

public interface UsersHandler {

    Long handleSetUserRole(final Long userId, final String role);

    List<EmployeeDto> handleSearchByEmail(final String searchPhrase);
}
