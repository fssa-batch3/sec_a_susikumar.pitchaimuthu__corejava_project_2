package com.fssa.freshnest.validation;

import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUserValidation {

    // Email validation test
    @Test
    void testValidEmailWithoutAtSymbol() {
        try {
            assertTrue(UserValidator.validateEmail("susikumargmail.com"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testInvalidEmailWithoutAtSymbol() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("susikumar123gmail.com"));
    }

    @Test
    void testInvalidEmailWithoutCom() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateEmail("susikumar@gmail"));
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
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Password123"));
    }

    @Test
    void testInvalidPasswordWithoutNumbers() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Password@"));
    }

    @Test
    void testInvalidPasswordWithoutCapitalLetters() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("password123"));
    }

    @Test
    void testInvalidPasswordWithoutSmallLetters() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("PASSWORD@123"));
    }

    @Test
    void testInvalidPasswordShorterLength() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validatePassword("Pas@123"));
    }


    // User name validation test
    @Test
    public void testValidUsername() {
        try {
            assertTrue(UserValidator.validateUserName("Soffan"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testUserNameNull() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUserName(null));
    }

    @Test
    void testUserNameLengthLessThanTwo() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateUserName("ra"));
    }

// First name validation test

    @Test
     void testValidUserFirstname() {
        try {

            assertTrue(UserValidator.validateFirstName("Susikumar"));
            System.out.println("username is valid");
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
     void testInvalidFirstnameStartingWithNumber() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("3Mama"));
    }

    @Test
     void testInvalidFirstnameStartingWithSpecialCharacter() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("4Machi"));
    }

    @Test
     void testInvalidFirstnameTooShort() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("ra"));
    }

    @Test
     void testInvalidUsernameTooLong() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateFirstName("AyyampettaiArivudainambiMahanIndhiranNaan"));
    }

    // Last name validation test

    @Test
     void testValidUserLastname() {
        try {

            assertTrue(UserValidator.validateFirstName("Pitchaimuthu"));
            System.out.println("username is valid");
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
     void testInvalidLastnameStartingWithNumber() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("3Mama"));
    }

    @Test
     void testInvalidLastnameStartingWithSpecialCharacter() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("4Machi"));
    }

    @Test
     void testInvalidLastnameTooShort() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("ra"));
    }

    @Test
     void testInvalidLastnameTooLong() {
        assertThrows(InvalidUserException.class, () -> UserValidator.validateLastName("AyyampettaiArivudainambiMahanIndhiranNaan"));
    }


    // Validate date of birth
    @Test
    void testValidDateOfBirth(){
        try {
            assertTrue(UserValidator.validateDob("2023-08-21"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testValidDateOfBirthInvalidMonth(){
        assertThrows(InvalidUserException.class, () -> UserValidator.validateDob("2023-28-12"));
    }

    @Test
    void testValidDateOfBirthInvalidDate(){
        assertThrows(InvalidUserException.class, () -> UserValidator.validateDob("2023-08-42"));
    }

    @Test
    void testNullDateOfBirth(){
        assertThrows(InvalidUserException.class, () -> UserValidator.validateDob(null));
    }

    // Validate nationality

    @Test
    void testValidNationality() {
        try {
            assertTrue(UserValidator.validateNationality("India"));
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    void testInvalidNationalityLengthLessThanTwo() {
            assertThrows(InvalidUserException.class , () -> UserValidator.validateNationality("I"));
    }
    @Test
    void testInvalidNullNationality() {
        assertThrows(InvalidUserException.class , () -> UserValidator.validateNationality(null));
    }

    // Validate profile image url

    @Test
    void testValidaProfileImageUrl(){
        try {
            assertTrue(UserValidator.validateProfileImageUrl("https://example.com/image.jpg"));
        }catch (InvalidUserException e){
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    void testInvalidProfileImageUrl(){
        assertThrows(InvalidUserException.class , () -> UserValidator.validateProfileImageUrl("//example.com/"));
    }

    @Test
    void testInvalidProfileImageUrlNull(){
        assertThrows(InvalidUserException.class , () -> UserValidator.validateProfileImageUrl(null));
    }

}
