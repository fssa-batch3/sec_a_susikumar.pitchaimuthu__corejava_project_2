package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserDeleteFeature {


    // test delete all details success
    @Test
    void testUserDeleteSuccess() {
        User user1 = new User("susi@gmail.com", true);
        UserService userService = new UserService();
        try {
            assertTrue(userService.deleteUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }

    }

    // test delete user invalid email
    @Test
    void testDeleteNotExistsEmail() {
        User user1 = new User("naan@gmail.com", true);
        UserService userService = new UserService();
        try {
            assertFalse(userService.deleteUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
