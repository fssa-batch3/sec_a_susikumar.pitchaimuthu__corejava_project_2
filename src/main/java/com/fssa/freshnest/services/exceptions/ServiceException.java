package com.fssa.freshnest.services.exceptions;

/**
 * The `ServiceException` class is an exception that can be thrown by service layer operations.
 * It provides additional information about errors or issues that occur during business logic execution.
 * 
 * @author SusikumarPitchaimuth
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = -8508529215117096666L;

    /**
     * Constructs a new `ServiceException` object with the given error message.
     *
     * @param msg The error message describing the reason for the exception
     */
    public ServiceException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new `ServiceException` object with a nested exception.
     *
     * @param e The nested exception that caused the `ServiceException`
     */
    public ServiceException(Throwable e) {
        super(e);
    }

}
