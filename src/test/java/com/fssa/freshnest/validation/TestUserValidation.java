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
            System.out.println(e.getMessage());
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
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Password123"));
        assertEquals(UserConstraints.getInvalidUserPasswordMessage(), result.getMessage());
    }

    @Test
    void testInvalidPasswordWithoutNumbers() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Password@"));
        assertEquals(UserConstraints.getInvalidUserPasswordMessage(), result.getMessage());
    }

    @Test
    void testInvalidPasswordWithoutCapitalLetters() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("password123"));
        assertEquals(UserConstraints.getInvalidUserPasswordMessage(), result.getMessage());
    }

    @Test
    void testInvalidPasswordWithoutSmallLetters() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("PASSWORD@123"));
        assertEquals(UserConstraints.getInvalidUserPasswordMessage(), result.getMessage());
    }

    @Test
    void testInvalidPasswordShorterLength() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Pas@123"));
        assertEquals(UserConstraints.getInvalidUserPasswordMessage(), result.getMessage());
    }


    // User name validation test
    @Test
    void testValidUsername() {
        try {
            assertTrue(UserValidator.validateUserName("susikumar"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testUserNameNull() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateUserName(null));
        assertEquals(UserConstraints.getInvalidUserUserNameMessage(), result.getMessage());

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
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidFirstnameStartingWithNumber() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("3Mama"));
        assertEquals(UserConstraints.getInvalidUserFirstNameMessage(), result.getMessage());
    }

    @Test
    void testInvalidFirstnameStartingWithSpecialCharacter() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("4Machi"));
        assertEquals(UserConstraints.getInvalidUserFirstNameMessage(), result.getMessage());
    }

    @Test
    void testInvalidFirstnameTooShort() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("ra"));
        assertEquals(UserConstraints.getInvalidUserFirstNameMessage(), result.getMessage());
    }

    @Test
    void testInvalidUsernameTooLong() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("AyyampettaiArivudainambiMahanIndhiranNaan"));
        assertEquals(UserConstraints.getInvalidUserFirstNameMessage(), result.getMessage());
    }

    // Last name validation test

    @Test
    void testValidUserLastname() {
        try {
            assertTrue(UserValidator.validateFirstName("Pitchaimuthu"));
            System.out.println("username is valid");
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidLastnameStartingWithNumber() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("3Mama"));
        assertEquals(UserConstraints.getInvalidUserLastNameMessage(), result.getMessage());
    }

    @Test
    void testInvalidLastnameStartingWithSpecialCharacter() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("4Machi"));
        assertEquals(UserConstraints.getInvalidUserLastNameMessage(), result.getMessage());
    }

    @Test
    void testInvalidLastnameTooShort() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("ra"));
        assertEquals(UserConstraints.getInvalidUserLastNameMessage(), result.getMessage());
    }

    @Test
    void testInvalidLastnameTooLong() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("AyyampettaiArivudainambiMahanIndhiranNaan"));
        assertEquals(UserConstraints.getInvalidUserLastNameMessage(), result.getMessage());
    }


    // Validate date of birth
    @Test
    void testValidDateOfBirth() {
        try {
            assertTrue(UserValidator.validateDob("2003-08-21"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }


    @Test
    void testNullDateOfBirth() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateDob(null));
        assertEquals(UserConstraints.getInvalidUserDobMessage(), result.getMessage());
    }

    // Validate nationality

    @Test
    void testValidNationality() {
        try {
            assertTrue(UserValidator.validateNationality("India"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidNationalityLengthLessThanTwo() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateNationality("I"));
        assertEquals(UserConstraints.getInvalidUserNationalityMessage(), result.getMessage());
    }

    @Test
    void testInvalidNullNationality() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateNationality(""));
        assertEquals(UserConstraints.getInvalidUserNationalityMessage(), result.getMessage());
    }

    // Validate profile image url

    @Test
    void testValidaProfileImageUrl() {
        try {
            assertTrue(UserValidator.validateProfileImageUrl("https://example.com/image.jpg"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidProfileImageUrl() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateProfileImageUrl("//example.com/"));
        assertEquals(UserConstraints.getInvalidUserProfileImageUrlMessage(), result.getMessage());
    }

    @Test
    void testInvalidProfileImageUrlNull() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateProfileImageUrl(null));
        assertEquals(UserConstraints.getInvalidNullUserProfileImageUrlMessage(), result.getMessage());

    }

}
