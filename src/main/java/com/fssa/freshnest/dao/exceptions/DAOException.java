package com.fssa.freshnest.dao.exceptions;

/**
 * The `DAOException` class is an exception that can be thrown by data access object (DAO) operations.
 * It provides additional information about errors or issues that occur during database interactions.
 * 
 * @author SusikumarPitchaimuth
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = -7798283981195321951L;

    /**
     * Constructs a new `DAOException` object with the given error message.
     *
     * @param msg The error message describing the reason for the exception
     */
    public DAOException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new `DAOException` object with a nested exception.
     *
     * @param e The nested exception that caused the `DAOException`
     */
    public DAOException(Throwable e) {
        super(e);
    }

}
