package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit test cases for validating the functionality of the {@link ChatValidator} class.
 *
 * @author SusikumarPitchaimuth
 */
class TestChatValidation {


    /**
     * Test case for validating a valid chat message.
     * It ensures that the {@link ChatValidator#validateChat(String)} method properly validates a valid chat message.
     * If the validation fails unexpectedly, the test will fail.
     */
    // test   valid chat
    @Test
    void testValidChat() {
        try {
            assertTrue(ChatValidator.validateChat("Hello chellam"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating a valid chat type.
     * It verifies that the {@link ChatValidator#validateChatType(String)} method correctly validates a valid chat type.
     * If the validation fails unexpectedly, the test will fail.
     */

    // test valid chat type
    @Test
    void testValidChatType() {
        try {
            assertTrue(ChatValidator.validateChatType("direct"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating an invalid chat type.
     * It checks whether the {@link ChatValidator#validateChatType(String)} method properly handles an invalid chat type
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid chat type message.
     */
    // test the invalid chat type
    @Test
    void testInvalidWrongChatType() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> ChatValidator.validateChatType("Conversation"));
        assertEquals(ChatConstants.getInvalidChatTypeMessage(), result.getMessage());
    }


}
