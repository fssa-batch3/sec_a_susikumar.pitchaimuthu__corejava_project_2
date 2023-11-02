package com.fssa.freshnest.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

/**
 * This class contains JUnit test cases for validating the functionality of the
 * {@link StillValidator} class.
 *
 * @author SusikumarPitchaimuth
 */
class TestStillValidation {

	@Test
	 void testValidateStillUrlValid() {
		try {
			assertTrue(StillValidator.validateStillUrl("https://example.com/image.jpg"));
			assertTrue(StillValidator.validateStillUrl("data:image/png;base64,base64data"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}


	@Test
	void testValidateStillNameValid() {
		try {
			assertTrue(StillValidator.validateStillName("Valid Name"));
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testInvalidStillUrlFive() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillUrl("//www.example"));
		assertEquals(StillConstants.getInvalidStillUrlMessage(), result.getMessage());
	}

	@Test
	void testValidateStillNameInvalid() {
		assertThrows(InvalidUserException.class, () -> StillValidator.validateStillName(null));
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillName(""));
		InvalidUserException result2 = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillName("   "));
		assertEquals(result.getMessage(), StillConstants.getInvalidStillNameMessage());
		assertEquals(result2.getMessage(), StillConstants.getInvalidStillNameMessage());

	}

	@Test
	void testValidateStillDateValid() {
		try {
			assertTrue(StillValidator.validateStillDate(LocalDate.now()));
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testInvalidStillUrlFour() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillUrl("//www.example"));
		assertEquals(StillConstants.getInvalidStillUrlMessage(), result.getMessage());
	}

	@Test
	void testValidateStillDateInvalid() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillDate(LocalDate.of(1800, 1, 30)));
		InvalidUserException result2 = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillDate(LocalDate.of(1870, 12, 1)));
		InvalidUserException result3 = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillDate(null));

		assertEquals(result.getMessage(), StillConstants.getInvalidStillDateMessage());
		assertEquals(result2.getMessage(), StillConstants.getInvalidStillDateMessage());
		assertEquals(result3.getMessage(), StillConstants.getInvalidStillDateMessage());

	}

	@Test
	void testValidateStillTimeValid() {
		try {
			assertTrue(StillValidator.validateStillTime(LocalTime.of(12, 0)));
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testValidStillUrl() {
		try {
			assertTrue(StillValidator.validateStillUrl("https://www.example.com"));
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	void testInvalidStillUrl() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillUrl("//www.example"));
		assertEquals(StillConstants.getInvalidStillUrlMessage(), result.getMessage());
	}

	@Test
	void testValidStillDate() {
		LocalDate currentDate = LocalDate.now();

		try {
			assertTrue(StillValidator.validateStillDate(currentDate));
		} catch (InvalidUserException e) {

			fail();
		}
	}

	@Test
	void testInvalidStillUrlTwo() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillUrl("//www.example"));
		assertEquals(StillConstants.getInvalidStillUrlMessage(), result.getMessage());
	}

	@Test
	void testValidTime() {
		LocalTime currentTime = LocalTime.now();
		try {
			assertTrue(StillValidator.validateStillTime(currentTime));
		} catch (InvalidUserException e) {

			fail();
		}
	}

	@Test
	void testInvalidStillUrlThree() {
		InvalidUserException result = assertThrows(InvalidUserException.class,
				() -> StillValidator.validateStillUrl("//www.example"));
		assertEquals(StillConstants.getInvalidStillUrlMessage(), result.getMessage());
	}

}
