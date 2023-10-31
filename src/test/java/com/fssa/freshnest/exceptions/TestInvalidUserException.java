package com.fssa.freshnest.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.validation.exceptions.InvalidUserException;

class TestInvalidUserException {

	@Test
	void testValidationException() {
		try {
			throw new InvalidUserException("Validation exception with message");
		} catch (InvalidUserException e) {
			assertEquals("Validation exception with message", e.getMessage());
		}
	}

	@Test
	void testValidationExceptionWithThrowable() {
		Throwable cause = new RuntimeException("Root cause");
		try {
			throw new InvalidUserException(cause);
		} catch (InvalidUserException e) {
			assertEquals(cause, e.getCause());
		}
	}
}
