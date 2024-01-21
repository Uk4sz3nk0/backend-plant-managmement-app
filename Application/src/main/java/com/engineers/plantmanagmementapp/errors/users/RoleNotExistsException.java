package com.engineers.plantmanagmementapp.errors.users;

public class RoleNotExistsException extends RuntimeException {

    public RoleNotExistsException(final String errorMessage) {
        super(errorMessage);
    }
}
