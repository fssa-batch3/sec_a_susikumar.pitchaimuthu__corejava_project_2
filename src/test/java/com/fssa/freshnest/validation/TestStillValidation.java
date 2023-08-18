package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.StillConstraints;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TestStillValidation {

    // Validate still url

    @Test
    void testValidStillUrl() {
        try {
            assertTrue(StillValidator.validateStillUrl("https://www.example.com"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidStillUrl() {
        InvalidUserException result = assertThrows(InvalidUserException.class,
                () -> StillValidator.validateStillUrl("//www.example"));
        assertEquals(StillConstraints.getInvalidStillUrlMessage(), result.getMessage());
    }


    // validate still name
    @Test
    void testValidStillName() {
        assertTrue(StillValidator.validateStillName("Supreme"));
    }


    // validate still date

    @Test
    void testValidStillDate() {
        LocalDate currentDate = LocalDate.now();

        try {
            assertTrue(StillValidator.validateStillDate(currentDate));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }


    // validate still time

    @Test
    void testValidTime() {
        LocalTime currentTime = LocalTime.now();
        try {
            assertTrue(StillValidator.validateStillTime(currentTime));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }


}
