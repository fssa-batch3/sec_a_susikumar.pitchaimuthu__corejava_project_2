package com.fssa.freshnest.validation;

import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestChatValidation {

    // test   valid chat
    @Test
    void testValidChat() {
        try {
            assertTrue(ChatValidator.validateChat("Hello chellam"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }
    }

    // test invalid null chat details
    @Test
    void testInvalidNullChat() {
        assertThrows(InvalidUserException.class, () -> ChatValidator.validateChat(null));
    }

    // test valid chat type
    @Test
    void testValidChatType() {
        try {
            assertTrue(ChatValidator.validateChatType("direct"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }
    }

    // test the invalid chat type
    @Test
    void testInvalidWrongChatType() {
        assertThrows(InvalidUserException.class, () -> ChatValidator.validateChatType("Conversation"));
    }

    // test the null chat type
    @Test
    void testInvalidNullChatType() {
        assertThrows(InvalidUserException.class, () -> ChatValidator.validateChatType(""));
    }

}
