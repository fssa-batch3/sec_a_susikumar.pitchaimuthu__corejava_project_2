package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit test cases for validating the functionality of the {@link StillValidator} class.
 *
 * @author SusikumarPitchaimuth
 */
class TestStillValidation {

    /**
     * Test case for validating a valid still URL.
     * It verifies that the {@link StillValidator#validateStillUrl(String)} method correctly validates a valid still URL.
     * If the validation fails unexpectedly, the test will fail.
     */
    // Validate still url
    @Test
    void testValidStillUrl() {
        try {
            assertTrue(StillValidator.validateStillUrl("https://www.example.com"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating an invalid still URL.
     * It checks whether the {@link StillValidator#validateStillUrl(String)} method properly handles an invalid still URL
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid still URL message.
     */
    @Test
    void testInvalidStillUrl() {
        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> StillValidator.validateStillUrl("//www.example"));
        assertEquals(StillConstants.getInvalidStillUrlMessage(), result.getMessage());
    }


    /**
     * Test case for validating a valid still date.
     * It ensures that the {@link StillValidator#validateStillDate(LocalDate)} method properly validates a valid still date.
     * If the validation fails unexpectedly, the test will fail.
     */
    // validate still date
    @Test
    void testValidStillDate() {
        LocalDate currentDate = LocalDate.now();

        try {
            assertTrue(StillValidator.validateStillDate(currentDate));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }


    /**
     * Test case for validating a valid still time.
     * It ensures that the {@link StillValidator#validateStillTime(LocalTime)} method properly validates a valid still time.
     * If the validation fails unexpectedly, the test will fail.
     */
    // validate still time
    @Test
    void testValidTime() {
        LocalTime currentTime = LocalTime.now();
        try {
			assertTrue(StillValidator.validateStillTime(currentTime));
		} catch (InvalidUserException e) {
			e.printStackTrace();
			fail();
		}
    }


}
