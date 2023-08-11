package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class TestUserProfileImageUpdate {


    @Test
    void testProfileUpdateSuccess() {
        User user1 = new User("https://example.com/image.jpg", 1);
        UserService userService = new UserService();
        try {
            assertTrue(userService.profileImageUpdate(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();

        }
    }

    // test the invalid image url update
    void testProfileInvalidImageUrl() {
        User user1 = new User("https://example", 1);
        UserService userService = new UserService();
        try {
            assertFalse(userService.profileImageUpdate(user1));

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }


    // test the null profile details
    void testProfileDetailsNull() {
        User user1 = null;
        UserService userService = new UserService();

        try {
            assertFalse(userService.profileImageUpdate(user1));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
