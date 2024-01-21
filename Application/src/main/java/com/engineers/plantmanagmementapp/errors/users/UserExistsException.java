package com.engineers.plantmanagmementapp.errors.users;

public class UserExistsException extends RuntimeException {

    public UserExistsException(final String errorMessage) {
        super(errorMessage);
    }
}
