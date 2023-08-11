package com.fssa.freshnest.validation;

import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestValidatePassword {

	@Test
	void testValidPassword() {

		try {
			assertTrue(UserValidator.validatePassword("Password@123"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testInvalidPasswordWithoutSpecialCharacters() {
		assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Password123"));

	}

	@Test
	void testInvalidPasswordWithoutNumbers() {
		assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Password@"));

	}

	@Test
	void testInvalidPasswordWithoutCapitalLetters() {
		assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("password123"));

	}

	@Test
	void testInvalidPasswordWithoutSmallLetters() {
		assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("PASSWORD@123"));

	}

	@Test
	void testInvalidPasswordShorterLength() {
		assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Pas@123"));

	}

}
