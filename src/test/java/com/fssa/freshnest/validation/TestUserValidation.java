package com.fssa.freshnest.validation;

import com.fssa.freshnest.constants.UserConstants;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains JUnit test cases for validating the functionality of the {@link UserValidator} class.
 *
 * @author SusikumarPitchaimuth
 */
class TestUserValidation {

    /**
     * Test case for validating a valid email.
     * It verifies that the {@link UserValidator#validateEmail(String)} method correctly validates a valid email.
     * If the validation fails unexpectedly, the test will fail.
     */
    @Test
    void testValidEmail() {
        try {
            assertTrue(UserValidator.validateEmail("susikumar@gmail.com"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating an invalid email without the '@' symbol.
     * It checks whether the {@link UserValidator#validateEmail(String)} method properly handles an invalid email
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid email message.
     */
    @Test
    void testInvalidEmailWithoutAtSymbol() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("susikumar123gmail.com"));
        assertEquals(UserConstants.getInvalidUserEmailMessage(), result.getMessage());
    }

    /**
     * Test case for validating an invalid email without the '.com'.
     * It checks whether the {@link UserValidator#validateEmail(String)} method properly handles an invalid email
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid email message.
     */

    @Test
    void testInvalidEmailWithoutDotCom() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("susikumar@gmail"));
        assertEquals(UserConstants.getInvalidUserEmailMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid password.
     * It verifies that the {@link UserValidator#validatePassword(String)} method correctly validates a valid password.
     * If the validation fails unexpectedly, the test will fail.
     */
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

    /**
     * Test case for validating an invalid password without special characters.
     * It checks whether the {@link UserValidator#validatePassword(String)} method properly handles a password without special characters
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid password message.
     */
    @Test
    void testInvalidPasswordWithoutSpecialCharacters() {
        testInvalidPassword("Password123");
    }

    /**
     * Test case for validating an invalid password without numbers.
     * It checks whether the {@link UserValidator#validatePassword(String)} method properly handles a password without numbers
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid password message.
     */
    @Test
    void testInvalidPasswordWithoutNumbers() {
        testInvalidPassword("Password@");
    }

    /**
     * Test case for validating an invalid password without capital letters.
     * It checks whether the {@link UserValidator#validatePassword(String)} method properly handles a password without capital letters
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid password message.
     */
    @Test
    void testInvalidPasswordWithoutCapitalLetters() {
        testInvalidPassword("password123");
    }

    /**
     * Test case for validating an invalid password without small letters.
     * It checks whether the {@link UserValidator#validatePassword(String)} method properly handles a password without small letters
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid password message.
     */
    @Test
    void testInvalidPasswordWithoutSmallLetters() {
        testInvalidPassword("PASSWORD@123");
    }

    /**
     * Test case for validating an invalid password with shorter length.
     * It checks whether the {@link UserValidator#validatePassword(String)} method properly handles a password with shorter length
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid password message.
     */
    @Test
    void testInvalidPasswordShorterLength() {
        testInvalidPassword("Pas@123");
    }

    /**
     * Helper method to test invalid passwords.
     * It checks whether the {@link UserValidator#validatePassword(String)} method properly handles various invalid password cases
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid password message.
     */
    void testInvalidPassword(String password) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword(password));
        assertEquals(UserConstants.getInvalidUserPasswordMessage(), result.getMessage());
    }


    /**
     * Test case for validating a valid username.
     * It verifies that the {@link UserValidator#validateUserName(String)} method correctly validates a valid username.
     * If the validation fails unexpectedly, the test will fail.
     */
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

    /**
     * Test case for validating a user name with length less than two characters.
     * It checks whether the {@link UserValidator#validateUserName(String)} method properly handles a user name
     * with a length less than two characters and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid user name message.
     */

    @Test
    void testUserNameLengthLessThanTwo() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateUserName("ra"));
        assertEquals(UserConstants.getInvalidUserUserNameMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid first name.
     * It verifies that the {@link UserValidator#validateFirstName(String)} method correctly validates a valid first name.
     * If the validation fails unexpectedly, the test will fail.
     */

// First name validation test
    @Test
    void testValidUserFirstname() {
        try {
            assertTrue(UserValidator.validateFirstName("Susikumar"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test case for validating an invalid first name starting with a number.
     * It checks whether the {@link UserValidator#validateFirstName(String)} method properly handles a first name starting with a number
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid first name message.
     */
    @Test
    void testInvalidFirstnameStartingWithNumber() {
        testInvalidFirstName("3Mama");
    }


    /**
     * Test case for validating an invalid first name starting with a special character.
     * It checks whether the {@link UserValidator#validateFirstName(String)} method properly handles a first name starting with a special character
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid first name message.
     */
    @Test
    void testInvalidFirstnameStartingWithSpecialCharacter() {
        testInvalidFirstName("4Machi");
    }

    /**
     * Test case for validating an invalid first name with a length too short.
     * It checks whether the {@link UserValidator#validateFirstName(String)} method properly handles a first name with a length too short
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid first name message.
     */
    @Test
    void testInvalidFirstnameTooShort() {
        testInvalidFirstName("ra");
    }

    /**
     * Test case for validating an invalid first name with a length too long.
     * It checks whether the {@link UserValidator#validateFirstName(String)} method properly handles a first name with a length too long
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid first name message.
     */
    @Test
    void testInvalidFirstnameTooLong() {
        testInvalidFirstName("AyyampettaiArivudainambiMahanIndhiranNaan");
    }

    /**
     * Helper method to test invalid first names.
     * It checks whether the {@link UserValidator#validateFirstName(String)} method properly handles various invalid first name cases
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid first name message.
     */
    void testInvalidFirstName(String firstName) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName(firstName));
        assertEquals(UserConstants.getInvalidUserFirstNameMessage(), result.getMessage());
    }


    // Last name validation test

    /**
     * Test case for validating a valid last name.
     * It verifies that the {@link UserValidator#validateLastName(String)} method correctly validates a valid last name.
     * If the validation fails unexpectedly, the test will fail.
     */
    @Test
    void testValidUserLastname() {
        try {
            assertTrue(UserValidator.validateFirstName("Pitchaimuthu"));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }


    /**
     * Test case for validating an invalid last name starting with a number.
     * It checks whether the {@link UserValidator#validateLastName(String)} method properly handles a last name starting with a number
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid last name message.
     */
    @Test
    void testInvalidLastnameStartingWithNumber() {
        testInvalidLastName("3Mama");
    }


    /**
     * Test case for validating an invalid last name starting with a special character.
     * It checks whether the {@link UserValidator#validateLastName(String)} method properly handles a last name starting with a special character
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid last name message.
     */
    @Test
    void testInvalidLastnameStartingWithSpecialCharacter() {
        testInvalidLastName("4Machi");
    }

    /**
     * Test case for validating an invalid last name with a length too short.
     * It checks whether the {@link UserValidator#validateLastName(String)} method properly handles a last name with a length too short
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid last name message.
     */
    @Test
    void testInvalidLastnameTooShort() {
        testInvalidLastName("ra");
    }


    /**
     * Test case for validating an invalid last name with a length too long.
     * It checks whether the {@link UserValidator#validateLastName(String)} method properly handles a last name with a length too long
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid last name message.
     */
    @Test
    void testInvalidLastnameTooLong() {
        testInvalidLastName("AyyampettaiArivudainambiMahanIndhiranNaan");
    }

    /**
     * Helper method to test invalid last names.
     * It checks whether the {@link UserValidator#validateLastName(String)} method properly handles various invalid last name cases
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid last name message.
     */
    void testInvalidLastName(String lastName) {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName(lastName));
        assertEquals(UserConstants.getInvalidUserLastNameMessage(), result.getMessage());
    }


    /**
     * Test case for validating a valid date of birth.
     * It verifies that the {@link UserValidator#validateDob(LocalDate)} method correctly validates a valid date of birth.
     * If the validation fails unexpectedly, the test will fail.
     */
    // Validate date of birth
    @Test
    void testValidDateOfBirth() {
        try {
            LocalDate dob = LocalDate.of(2003, 3, 23);
            assertTrue(UserValidator.validateDob(dob));
        } catch (InvalidUserException e) {
            e.printStackTrace();
            fail();
        }
    }


    /**
     * Test case for validating a valid nationality.
     * It verifies that the {@link UserValidator#validateNationality(String)} method correctly validates a valid nationality.
     * If the validation fails unexpectedly, the test will fail.
     */
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

    /**
     * Test case for validating an invalid nationality with a length less than two.
     * It checks whether the {@link UserValidator#validateNationality(String)} method properly handles an invalid nationality
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid nationality message.
     */
    @Test
    void testInvalidNationalityLengthLessThanTwo() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateNationality("I"));
        assertEquals(UserConstants.getInvalidUserNationalityMessage(), result.getMessage());
    }

    /**
     * Test case for validating a valid profile image URL.
     * It verifies that the {@link UserValidator#validateProfileImageUrl(String)} method correctly validates a valid profile image URL.
     * If the validation fails unexpectedly, the test will fail.
     */

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


    /**
     * Test case for validating an invalid profile image URL.
     * It checks whether the {@link UserValidator#validateProfileImageUrl(String)} method properly handles an invalid profile image URL
     * and throws the expected {@link InvalidUserException}.
     * Additionally, it verifies that the exception message matches the predefined invalid profile image URL message.
     */
    @Test
    void testInvalidProfileImageUrl() {
        InvalidUserException result = assertThrows(InvalidUserException.class, () -> UserValidator.validateProfileImageUrl("//example.com/"));
        assertEquals(UserConstants.getInvalidUserProfileImageUrlMessage(), result.getMessage());
    }


}
