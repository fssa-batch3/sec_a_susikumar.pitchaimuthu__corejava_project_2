package com.fssa.freshnest.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidatePassword {

    @Test
     void testValidPassword() {

        assertTrue(UserValidator.validatePassword("Password@123"));

    }
 
    @Test
     void testInvalidPasswordWithoutSpecialCharacters() {
        assertFalse(UserValidator.validatePassword("Password123"));

    }

    @Test
     void testInvalidPasswordWithoutNumbers() {
        assertFalse(UserValidator.validatePassword("Password@"));

    }

    @Test
     void testInvalidPasswordWithoutCapitalLetters() {
        assertFalse(UserValidator.validatePassword("password123"));

    }

    @Test
     void testInvalidPasswordWithoutSmallLetters() {
        assertFalse(UserValidator.validatePassword("PASSWORD@123"));

    }

    @Test
     void testInvalidPasswordShorterLength() {
        assertFalse(UserValidator.validatePassword("Pas@123"));

    }

}
