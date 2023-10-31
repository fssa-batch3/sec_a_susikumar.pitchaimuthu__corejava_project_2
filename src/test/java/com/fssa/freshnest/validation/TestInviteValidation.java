package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit test cases for validating the functionality of the
 * {@link InviteValidator} class.
 *
 * @author SusikumarPitchaimuth
 */
class TestInviteValidation {

    /**
     * Test case for validating a valid invite type. It verifies that the
     * {@link InviteValidator#validateInviteType(String)} method correctly validates
     * a valid invite type. If the validation fails unexpectedly, the test will
     * fail.
     */
    // test the valid invite type
    @Test
    void testValidInviteType() {
        try {
            assertTrue(InviteValidator.validateInviteType("Birthday"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating a null invite type. It checks whether the
     * {@link InviteValidator#validateInviteType(String)} method properly handles a
     * null invite type and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined
     * invalid invite type message.
     */

    // test the null invite type
    @Test
    void testNullInviteType() {
        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> InviteValidator.validateInviteType(""));
        assertEquals(InviteConstants.getInvalidInviteTypeMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid invite date. It ensures that the
     * {@link InviteValidator} method properly validates a valid invite date. If the
     * validation fails unexpectedly, the test will fail.
     */
    // test valid invite date
    @Test
    void testValidInviteDate() {
        try {
            LocalDate date = LocalDate.of(2023, 12, 29);
            assertTrue(InviteValidator.validateInviteDate(date));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidMonthDetails() {
        LocalDate date = LocalDate.of(2023, 5, 29);

        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> InviteValidator.validateInviteDate(date));
        assertEquals(InviteConstants.getInvalidInviteDateMessage(), result.getMessage());

    }

    @Test
    void testInvalidPastDateDetails() {
        LocalDate date = LocalDate.of(2023, 6, 23);

        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> InviteValidator.validateInviteDate(date));
        assertEquals(InviteConstants.getInvalidInviteDateMessage(), result.getMessage());

    }

    @Test
    void testNullDateDetails() {
        LocalDate date = null;

        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> InviteValidator.validateInviteDate(date));
        assertEquals(InviteConstants.getInvalidInviteDateMessage(), result.getMessage());
    }

    /**
     * Helper method to test invalid invite date formats. date formats and throws
     * the expected {@link InvalidUserException}. Additionally, it verifies that the
     * exception message matches the predefined invalid invite date message.
     */
    @Test
    void testInvalidPastYearInviteDate() {
        LocalDate date = LocalDate.of(2002, 9, 23);
        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> InviteValidator.validateInviteDate(date));
        assertEquals(InviteConstants.getInvalidInviteDateMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid invite time. invite time along with a
     * corresponding date. If the validation fails unexpectedly, the test will fail.
     */
    // test the valid invite time
    @Test
    void testValidTimeDetails() {
        try {
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.of(23, 34);

            assertTrue(InviteValidator.validateInviteTime(time, date));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating invalid null time details in an invitation time.
     * time and date values and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined
     * invalid invite time message.
     */
    @Test
    void testInvalidNullTimeDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> InviteValidator.validateInviteTime(null, null));
        assertEquals(InviteConstants.getNullInviteDateMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid invite explanation. It ensures that the
     * {@link InviteValidator#validateInviteExplanation(String)} method properly
     * validates a valid invite explanation. If the validation fails unexpectedly,
     * the test will fail.
     */
    // test the valid explanation
    @Test
    void testValidInviteExplanation() {
        try {
            assertTrue(InviteValidator.validateInviteExplanation("Hello buddy, this is the party of heaven"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating null invite explanation details. It checks whether
     * the {@link InviteValidator#validateInviteExplanation(String)} method properly
     * handles null explanation values and throws the expected
     * {@link InvalidUserException}. Additionally, it verifies that the exception
     * message matches the predefined invalid invite explanation message.
     */
    // test null invite explanation details
    @Test
    void testNullExplanationDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> InviteValidator.validateInviteExplanation(""));
        assertEquals(InviteConstants.getInvalidInviteExplanationMessage(), result.getMessage());
    }

    @Test
    void testInvalidInviteTimeMessageCheck() {
        LocalTime time = LocalTime.of(0, 0);
        LocalDate date = LocalDate.of(2004, 10, 10);
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteTime(time, date));
        assertEquals(InviteConstants.getInvalidInviteTimeMessage(), result.getMessage());
    }

    @Test
    void testNullInviteTimeMessageCheck() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteTime(null, null));
        assertEquals(InviteConstants.getNullInviteDateMessage(), result.getMessage());
    }

}
