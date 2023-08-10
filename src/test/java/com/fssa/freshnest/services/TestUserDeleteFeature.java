package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserDeleteFeature {
    public static void main(String[] args) {
        User user1 = new User("susi@gmail.com", true);

        UserService userService = new UserService();

        try {
            userService.DeleteUser(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test delete all details success
    @Test
    public void testDeleteSuccess(){
        User user1 = new User("susi@gmail.com", true);
        UserService userService = new UserService();
        try {
            assertTrue(userService.DeleteUser(user1));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    // test delete user invalid email
    @Test
    public void testDeleteNotExistsEmail(){
        User user1 = new User("naan@gmail.com", true);
        UserService userService = new UserService();
        try {
            assertFalse(userService.DeleteUser(user1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
