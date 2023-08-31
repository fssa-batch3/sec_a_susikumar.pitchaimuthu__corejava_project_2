package com.fssa.freshnest.validation.exceptions;

/**
 * The `InvalidUserException` class is an exception that can be thrown when user data fails validation.
 * It provides additional information about validation errors that occur during user input processing.
 * 
 * @author SusikumarPitchaimuth
 */
public class InvalidUserException extends Exception {

    private static final long serialVersionUID = -1194860954774008955L;

    /**
     * Constructs a new `InvalidUserException` object with the given error message.
     *
     * @param msg The error message describing the validation failure
     */
    public InvalidUserException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new `InvalidUserException` object with a nested exception.
     *
     * @param e The nested exception that caused the `InvalidUserException`
     */
    public InvalidUserException(Throwable e) {
        super(e);
    }
}
