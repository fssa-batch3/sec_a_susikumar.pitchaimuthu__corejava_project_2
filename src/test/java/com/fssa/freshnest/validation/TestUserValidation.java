package com.fssa.freshnest.validation;

import com.fssa.freshnest.constraints.UserConstraints;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUserValidation {

    // Email validation test
    @Test
    void testValidEmail() {
        try {
            assertTrue(UserValidator.validateEmail("susikumar@gmail.com"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidEmailWithoutAtSymbol() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("susikumar123gmail.com"));
        assertEquals(UserConstraints.getInvalidUserEmailMessage(), result.getMessage());
    }

    @Test
    void testInvalidEmailWithoutDotCom() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("susikumar@gmail"));
        assertEquals(UserConstraints.getInvalidUserEmailMessage(), result.getMessage());
    }

    // Password validation test
    @Test
    void testValidPassword() {
        try {
            assertTrue(UserValidator.validatePassword("Password@123"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidPasswordWithoutSpecialCharacters() {
        testInvalidPassword("Password123");
    }

    @Test
    void testInvalidPasswordWithoutNumbers() {
        testInvalidPassword("Password@");
    }

    @Test
    void testInvalidPasswordWithoutCapitalLetters() {
        testInvalidPassword("password123");
    }

    @Test
    void testInvalidPasswordWithoutSmallLetters() {
        testInvalidPassword("PASSWORD@123");
    }

    @Test
    void testInvalidPasswordShorterLength() {
        testInvalidPassword("Pas@123");
    }

    void testInvalidPassword(String password) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword(password));
        assertEquals(UserConstraints.getInvalidUserPasswordMessage(), result.getMessage());
    }


    // User name validation test
    @Test
    void testValidUsername() {
        try {
            assertTrue(UserValidator.validateUserName("susikumar"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

   

    @Test
    void testUserNameLengthLessThanTwo() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateUserName("ra"));
        assertEquals(UserConstraints.getInvalidUserUserNameMessage(), result.getMessage());
    }

// First name validation test

    @Test
    void testValidUserFirstname() {
        try {
            assertTrue(UserValidator.validateFirstName("Susikumar"));
            System.out.println("username is valid");
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidFirstnameStartingWithNumber() {
        testInvalidFirstName("3Mama");
    }

    @Test
    void testInvalidFirstnameStartingWithSpecialCharacter() {
        testInvalidFirstName("4Machi");
    }

    @Test
    void testInvalidFirstnameTooShort() {
        testInvalidFirstName("ra");
    }

    @Test
    void testInvalidFirstnameTooLong() {
        testInvalidFirstName("AyyampettaiArivudainambiMahanIndhiranNaan");
    }

    void testInvalidFirstName(String firstName) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName(firstName));
        assertEquals(UserConstraints.getInvalidUserFirstNameMessage(), result.getMessage());
    }


    // Last name validation test

    @Test
    void testValidUserLastname() {
        try {
            assertTrue(UserValidator.validateFirstName("Pitchaimuthu"));
            System.out.println("username is valid");
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidLastnameStartingWithNumber() {
        testInvalidLastName("3Mama");
    }

    @Test
    void testInvalidLastnameStartingWithSpecialCharacter() {
        testInvalidLastName("4Machi");
    }

    @Test
    void testInvalidLastnameTooShort() {
        testInvalidLastName("ra");
    }

    @Test
    void testInvalidLastnameTooLong() {
        testInvalidLastName("AyyampettaiArivudainambiMahanIndhiranNaan");
    }

    void testInvalidLastName(String lastName) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName(lastName));
        assertEquals(UserConstraints.getInvalidUserLastNameMessage(), result.getMessage());
    }


    // Validate date of birth
    @Test
    void testValidDateOfBirth() {
        try {
            assertTrue(UserValidator.validateDob("2003-08-21"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }


    // Validate nationality

    @Test
    void testValidNationality() {
        try {
            assertTrue(UserValidator.validateNationality("India"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidNationalityLengthLessThanTwo() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateNationality("I"));
        assertEquals(UserConstraints.getInvalidUserNationalityMessage(), result.getMessage());
    }


    // Validate profile image url

    @Test
    void testValidaProfileImageUrl() {
        try {
            assertTrue(UserValidator.validateProfileImageUrl("https://example.com/image.jpg"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testInvalidProfileImageUrl() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateProfileImageUrl("//example.com/"));
        assertEquals(UserConstraints.getInvalidUserProfileImageUrlMessage(), result.getMessage());
    }


}
