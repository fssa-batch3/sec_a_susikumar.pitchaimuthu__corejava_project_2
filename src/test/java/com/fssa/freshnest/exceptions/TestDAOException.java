package com.fssa.freshnest.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.dao.exceptions.DAOException;

class TestDAOException {
	@Test
	 void testDAOException() {
		try {
			throw new DAOException("DAO exception with message");
		} catch (DAOException e) {
			assertEquals("DAO exception with message", e.getMessage());
		}
	}

	@Test
	 void testDAOExceptionWithThrowable() {
		Throwable cause = new RuntimeException("Root cause");
		try {
			throw new DAOException(cause);
		} catch (DAOException e) {
			assertEquals(cause, e.getCause());
		}
	}
}
