package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.InviteConstraints;
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
            System.out.println(e.getMessage());
            fail();
        }
    }

    // test the null invite type
    @Test
    void testNullInviteType() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteType(""));
        assertEquals(InviteConstraints.getInvalidInviteTypeMessage(), result.getMessage());
    }

    // test valid invite date
    @Test
    void testValidInviteDate() {
        try {
            assertTrue(InviteValidator.validateInviteDate("2030-08-23"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidMonthDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteDate("2032-23-09"));
        assertEquals(InviteConstraints.getInvalidInviteDateMessage(), result.getMessage());
    }

    @Test
    void testInvalidDateDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteDate("2032-03-43"));
        assertEquals(InviteConstraints.getInvalidInviteDateMessage(), result.getMessage());
    }

    @Test
    void testNullDateDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteDate(""));
        assertEquals(InviteConstraints.getInvalidInviteDateMessage(), result.getMessage());
    }


    // test the valid invite time

    @Test
    void testValidTimeDetails() {
        try {
            assertTrue(InviteValidator.validateInviteTime("09:45"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidNullTimeDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteTime(""));
        assertEquals(InviteConstraints.getInvalidInviteTimeMessage(), result.getMessage());
    }

    // test the valid explanation
    @Test
    void testValidInviteExplanation() {
        try {
            assertTrue(InviteValidator.validateInviteExplanation("Hello buddy, this is the party of heaven"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    // test null invite explanation details
    @Test
    void testNullExplanationDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteExplanation(""));
        assertEquals(InviteConstraints.getInvalidInviteExplanationMessage(), result.getMessage());
    }

    @Test
    void testValidInviteMessage() {
        try {
            assertTrue(InviteValidator.validateInviteMessage("I will come buddy"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testNullMessageDetails() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteMessage(""));
        assertEquals(InviteConstraints.getInvalidInviteChatMessage(), result.getMessage());
    }

}
