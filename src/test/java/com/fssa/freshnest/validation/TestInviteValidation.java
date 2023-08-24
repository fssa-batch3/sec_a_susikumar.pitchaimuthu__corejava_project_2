package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit test cases for validating the functionality of the {@link InviteValidator} class.
 *
 * @author SusikumarPitchaimuth
 */
class TestInviteValidation {

    /**
     * Test case for validating a valid invite type.
     * It verifies that the {@link InviteValidator#validateInviteType(String)} method correctly validates a valid invite type.
     * If the validation fails unexpectedly, the test will fail.
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
     * Test case for validating a null invite type.
     * It checks whether the {@link InviteValidator#validateInviteType(String)} method properly handles a null invite type
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid invite type message.
     */

    // test the null invite type
    @Test
    void testNullInviteType() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteType(""));
        assertEquals(InviteConstants.getInvalidInviteTypeMessage(), result.getMessage());
    }


    /**
     * Test case for validating a valid invite date.
     * It ensures that the {@link InviteValidator#validateInviteDate(String)} method properly validates a valid invite date.
     * If the validation fails unexpectedly, the test will fail.
     */
    // test valid invite date
    @Test
    void testValidInviteDate() {
        try {
            assertTrue(InviteValidator.validateInviteDate("2030-08-23"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating invalid month details in an invite date.
     * It uses the {@link #testInvalidInviteDate(String)} helper method to validate the handling of invalid date formats.
     */
    @Test
    void testInvalidMonthDetails() {
        testInvalidInviteDate("2032-23-09");
    }

    /**
     * Test case for validating invalid day details in an invite date.
     * It uses the {@link #testInvalidInviteDate(String)} helper method to validate the handling of invalid date formats.
     */
    @Test
    void testInvalidDateDetails() {
        testInvalidInviteDate("2032-03-43");
    }

    /**
     * Test case for validating null date details in an invite date.
     * It uses the {@link #testInvalidInviteDate(String)} helper method to validate the handling of null date formats.
     */
    @Test
    void testNullDateDetails() {
        testInvalidInviteDate("");
    }

    /**
     * Helper method to test invalid invite date formats.
     * It checks whether the {@link InviteValidator#validateInviteDate(String)} method properly handles various invalid
     * date formats and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid invite date message.
     */
    void testInvalidInviteDate(String input) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteDate(input));
        assertEquals(InviteConstants.getInvalidInviteDateMessage(), result.getMessage());
    }


    /**
     * Test case for validating a valid invite time.
     * It ensures that the {@link InviteValidator#validateInviteTime(String, String)} method properly validates a valid
     * invite time along with a corresponding date.
     * If the validation fails unexpectedly, the test will fail.
     */
    // test the valid invite time
    @Test
    void testValidTimeDetails() {
        try {
            assertTrue(InviteValidator.validateInviteTime("09:45", "2023-10-29"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating invalid null time details in an invite time.
     * It checks whether the {@link InviteValidator#validateInviteTime(String, String)} method properly handles null
     * time and date values and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid invite time message.
     */
    @Test
    void testInvalidNullTimeDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteTime("", ""));
        assertEquals(InviteConstants.getInvalidInviteTimeMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid invite explanation.
     * It ensures that the {@link InviteValidator#validateInviteExplanation(String)} method properly validates a valid
     * invite explanation.
     * If the validation fails unexpectedly, the test will fail.
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
     * Test case for validating null invite explanation details.
     * It checks whether the {@link InviteValidator#validateInviteExplanation(String)} method properly handles null
     * explanation values and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid invite explanation message.
     */
    // test null invite explanation details
    @Test
    void testNullExplanationDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteExplanation(""));
        assertEquals(InviteConstants.getInvalidInviteExplanationMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid invite message.
     * It ensures that the {@link InviteValidator#validateInviteMessage(String)} method properly validates a valid
     * invite message.
     * If the validation fails unexpectedly, the test will fail.
     */
    @Test
    void testValidInviteMessage() {
        try {
            assertTrue(InviteValidator.validateInviteMessage("I will come buddy"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating null invite message details.
     * It checks whether the {@link InviteValidator#validateInviteMessage(String)} method properly handles null
     * message values and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid invite chat message.
     */

    @Test
    void testNullMessageDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteMessage(""));
        assertEquals(InviteConstants.getInvalidInviteChatMessage(), result.getMessage());
    }

}
