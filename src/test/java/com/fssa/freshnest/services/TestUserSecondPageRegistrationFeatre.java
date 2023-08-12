package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUserSecondPageRegistrationFeature {

    public static void main(String[] args) {

        User user1 = new User("2003-08-29", "Male", "susi@gmail.com");
        UserService userService = new UserService();

        try {
            userService.secondPageRegisterUser(user1);

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    @Test
    void validateUserSecondRegistrationSuccess() {

        User user1 = new User("2003-08-29", "Male", "susi@gmail.com");
        UserService userService = new UserService();

        try {
            assertTrue(userService.secondPageRegisterUser(user1));

        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }

    }

    @Test
    void testUserSecondRegistrationNullDetails() {
        UserService userService = new UserService();

        try {
            assertFalse(userService.secondPageRegisterUser(null));

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
