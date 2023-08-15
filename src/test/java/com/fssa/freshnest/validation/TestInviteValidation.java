package com.fssa.freshnest.validation;

import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class TestInviteValidation {

    // test the valid invite type
    @Test
    void testValidInviteType(){
        try {
            assertTrue(InviteValidator.validateInviteType("Birthday"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }

    // test the null invite type
    @Test
    void testNullInviteType(){
        assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteType(""));
    }

    // test valid invite date
    @Test
    void testValidInviteDate(){
        try {
            assertTrue(InviteValidator.validateInviteDate("2030-08-23"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testInvalidMonthDetails(){
        assertThrows(InvalidUserException.class , () -> InviteValidator.validateInviteDate("2032-23-09"));
    }

    @Test
    void testInvalidDateDetails(){
        assertThrows(InvalidUserException.class , () -> InviteValidator.validateInviteDate("2032-03-43"));
    }

    @Test
    void testNullDateDetails(){
        assertThrows(InvalidUserException.class , () -> InviteValidator.validateInviteDate(""));
    }


    // test the valid invite time

    @Test
    void testValidTimeDetails(){
        try {
            assertTrue(InviteValidator.validateInviteTime("09:45"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testInvalidNullTimeDetails(){
        assertThrows(InvalidUserException.class , () -> InviteValidator.validateInviteTime(""));
    }

    // test the valid explanation
    @Test
    void testValidInviteExplanation(){
        try {
            assertTrue(InviteValidator.validateInviteExplanation("Hello buddy, this is the party of heaven"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }

    // test null invite explanation details
    @Test
    void testNullExplanationDetails(){
        assertThrows(InvalidUserException.class, () -> InviteValidator.validateInviteExplanation(""));
    }

    @Test
    void testValidInviteMessage(){
        try {
            assertTrue(InviteValidator.validateInviteMessage("I will come buddy"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testNullMessageDetails(){
        assertThrows(InvalidUserException.class , () -> InviteValidator.validateInviteMessage(""));
    }

}
