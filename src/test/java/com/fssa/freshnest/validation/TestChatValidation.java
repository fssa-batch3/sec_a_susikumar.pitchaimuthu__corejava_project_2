package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.ChatConstraints;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestChatValidation {

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

    // test the invalid chat type
    @Test
    void testInvalidWrongChatType() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> ChatValidator.validateChatType("Conversation"));
        assertEquals(ChatConstraints.getInvalidChatTypeMessage(), result.getMessage());
    }


}
