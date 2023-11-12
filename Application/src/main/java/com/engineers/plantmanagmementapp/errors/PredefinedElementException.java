package com.engineers.plantmanagmementapp.errors;

/**
 * PredefinedElementException - Exception which is being thrown while predefined element is being edited or deleted
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

public class PredefinedElementException extends RuntimeException {

    public PredefinedElementException(final String errorMessage) {
        super(errorMessage);
    }
}
