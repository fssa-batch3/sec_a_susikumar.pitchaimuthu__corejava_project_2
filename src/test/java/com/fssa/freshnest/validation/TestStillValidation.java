package com.fssa.freshnest.validation;

import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

 class TestStillValidation {

    // Validate still url

    @Test
    void testValidStillUrl(){
        try {
            assertTrue(StillValidator.validateStillUrl("https://www.example.com"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testInvalidStillUrl(){
        assertThrows(InvalidUserException.class , () -> StillValidator.validateStillUrl("//www.example"));
    }
    @Test
    void testStillUrlNullDetails(){
        assertThrows(InvalidUserException.class , () -> StillValidator.validateStillUrl(null));
    }


    // validate still name
    @Test
    void testValidStillName(){
        try {
            assertTrue(StillValidator.validateStillName("Supreme"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testInvalidNullStillName(){
        assertThrows(InvalidUserException.class, () -> StillValidator.validateStillName(null));
    }

    // validate still date

    @Test
    void testValidStillDate(){
        try {
            assertTrue(StillValidator.validateStillDate(LocalDate.parse("2023-05-23")));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testInvalidDateWithWrongMonth(){
            assertThrows(InvalidUserException.class, () -> StillValidator.validateStillDate(LocalDate.parse("2023-45-23")));
    }

    @Test
    void testInvalidNullDate(){
        assertThrows(InvalidUserException.class, () -> StillValidator.validateStillDate(LocalDate.parse(null)));
    }

    // validate still time

    @Test
    void testValidTime(){
        try {
            assertTrue(StillValidator.validateStillTime(LocalTime.parse("09.45")));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testNullTime(){
        try {
            assertTrue(StillValidator.validateStillTime(LocalTime.parse(null)));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
        }
    }



}
