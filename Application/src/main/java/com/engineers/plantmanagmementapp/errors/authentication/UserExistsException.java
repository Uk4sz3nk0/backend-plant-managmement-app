package com.engineers.plantmanagmementapp.errors.authentication;

/**
 * UserExistsException - This exception is being thrown while registering new user,
 * user with given email address exists in database.
 * Created on: 2023-10-25
 *
 * @author Łukasz Wodniak
 */
public class UserExistsException extends RuntimeException {

    public UserExistsException(final String errorMessage) {
        super(errorMessage);
    }
}
