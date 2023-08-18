package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUserLoginFeature {


    @Test
    void testLoginSuccess() {
        UserService userService = new UserService();
        User user1 = new User("susi@gmail.com", "raji@SM123");
        try {
            assertTrue(userService.logInUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testEmailPasswordNull() {
        UserService userService = new UserService();
        User user1 = null;
        try {
            assertFalse(userService.logInUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();

        }

    }

    @Test
    void testInvalidPassword() {
        UserService userService = new UserService();
        User user1 = new User("susi@gmail.com", "susi123SM");
        try {
            assertFalse(userService.logInUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    @Test
    void testInvalidEmail() {
        UserService userService = new UserService();
        User user1 = new User("susigmail.com", "susi123@SM");
        try {
            assertFalse(userService.logInUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
