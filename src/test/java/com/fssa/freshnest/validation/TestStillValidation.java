package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.StillConstraints;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TestStillValidation {

	// Validate still url

	@Test
	void testValidStillUrl() {
		try {
			assertTrue(StillValidator.validateStillUrl("https://www.example.com"));
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidStillUrl() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillUrl("//www.example"));
		assertEquals(StillConstraints.getInvalidStillUrlMessage(), result.getMessage());
	}

	@Test
	void testStillUrlNullDetails() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillUrl(null));
		assertEquals(StillConstraints.getInvalidStillUrlMessage(), result.getMessage());
	}

	// validate still name
	@Test
	void testValidStillName() {
		try {
			assertTrue(StillValidator.validateStillName("Supreme"));
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidNullStillName() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillName(""));
		assertEquals(StillConstraints.getInvalidStillNameMessage(), result.getMessage());
	}

	// validate still date

	@Test
	void testValidStillDate() {
        LocalDate currentDate = LocalDate.now();

		try {
			assertTrue(StillValidator.validateStillDate(currentDate));
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testInvalidNullDate() {

		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillDate(null));
		assertEquals(StillConstraints.getInvalidStillDateMessage(), result.getMessage());
	}

	// validate still time

	@Test
	void testValidTime() {
        LocalTime currentTime = LocalTime.now();
		try {
			assertTrue(StillValidator.validateStillTime(currentTime));
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}

	@Test
	void testNullTime() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillTime(null));
		assertEquals(StillConstraints.getInvalidStillTimeMessage(), result.getMessage());
	}

}
