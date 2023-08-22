package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestInviteValidation {

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

    // test the null invite type
    @Test
    void testNullInviteType() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteType(""));
        assertEquals(InviteConstants.getInvalidInviteTypeMessage(), result.getMessage());
    }

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

    @Test
    void testInvalidMonthDetails() {
        testInvalidInviteDate("2032-23-09");
    }

    @Test
    void testInvalidDateDetails() {
        testInvalidInviteDate("2032-03-43");
    }

    @Test
    void testNullDateDetails() {
        testInvalidInviteDate("");
    }

    void testInvalidInviteDate(String input) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteDate(input));
        assertEquals(InviteConstants.getInvalidInviteDateMessage(), result.getMessage());
    }


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

    @Test
    void testInvalidNullTimeDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteTime("", ""));
        assertEquals(InviteConstants.getInvalidInviteTimeMessage(), result.getMessage());
    }

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

    // test null invite explanation details
    @Test
    void testNullExplanationDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteExplanation(""));
        assertEquals(InviteConstants.getInvalidInviteExplanationMessage(), result.getMessage());
    }

    @Test
    void testValidInviteMessage() {
        try {
            assertTrue(InviteValidator.validateInviteMessage("I will come buddy"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testNullMessageDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteMessage(""));
        assertEquals(InviteConstants.getInvalidInviteChatMessage(), result.getMessage());
    }

}
