package com.fssa.freshnest.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.services.exceptions.ServiceException;

class TestServiceException {
	@Test
	void testServiceException() {
		try {
			throw new ServiceException("Service exception with message");
		} catch (ServiceException e) {
			assertEquals("Service exception with message", e.getMessage());
		}
	}

	@Test
	void testServiceExceptionWithThrowable() {
		Throwable cause = new RuntimeException("Root cause");
		try {
			throw new ServiceException(cause);
		} catch (ServiceException e) {
			assertEquals(cause, e.getCause());
		}
	}

}
