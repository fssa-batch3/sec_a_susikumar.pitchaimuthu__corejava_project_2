package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserSecondPageRegistrationFeatre {

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
        User user1 = null;
        UserService userService = new UserService();

        try {
            assertFalse(userService.secondPageRegisterUser(user1));

        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
