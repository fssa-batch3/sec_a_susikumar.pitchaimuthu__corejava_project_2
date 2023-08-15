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
            System.out.println(e.getMessage());
            fail();
        }
    }

    // test invalid null chat details
    @Test
    void testInvalidNullChat() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> ChatValidator.validateChat(null));
        assertEquals(ChatConstraints.getInvalidChatTextMessage(), result.getMessage());
    }

    // test valid chat type
    @Test
    void testValidChatType() {
        try {
            assertTrue(ChatValidator.validateChatType("direct"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    // test the invalid chat type
    @Test
    void testInvalidWrongChatType() {
     InvalidUserException result =    assertThrows(InvalidUserException.class, () -> ChatValidator.validateChatType("Conversation"));
        assertEquals(ChatConstraints.getInvalidChatTypeMessage(), result.getMessage());
    }

    // test the null chat type
    @Test
    void testInvalidNullChatType() {
       InvalidUserException result =  assertThrows(InvalidUserException.class, () -> ChatValidator.validateChatType(""));
        assertEquals(ChatConstraints.getInvalidChatTypeMessage(), result.getMessage());
    }

}
