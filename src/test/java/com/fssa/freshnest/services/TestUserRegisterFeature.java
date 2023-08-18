package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUserRegisterFeature {


    @Test
    void testRegistrationSuccess() {
        UserService userService = new UserService();
        User user1 = new User("pooja@gmail.com", "Kani Papa", "susi123@SM", "Susikumar", "Pitchaimuthu", "https://example.com/image.jpg");
        try {

            assertTrue(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();

        }
    }

    @Test
    void testInvalidPassword() {

        UserService userService = new UserService();
        User user1 = new User("Susi@gmail.com", "Kani Papa", "susi123SM", "Susikumar", "Pitchaimuthu", "https://example.com/image.jpg");
        try {
            assertFalse(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    @Test
    void testUserNull() {

        UserService userService = new UserService();
        User user1 = null;
        try {
            assertFalse(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();

        }

    }

}