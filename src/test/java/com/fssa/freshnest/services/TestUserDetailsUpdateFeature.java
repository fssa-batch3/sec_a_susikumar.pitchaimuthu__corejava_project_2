package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestUserDetailsUpdateFeature {


    @Test
    void testUpdateSuccess() {

        User user1 = new User( "Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
                "2003-08-01", "Indian", "Male");
        User email = new User("susi@gmail.com");

        UserService userService = new UserService();

        try {
            assertTrue(userService.updateUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    // test invalid email address update
    @Test
    void testEmailNotExistInDatabaseUpdate() {
        UserService userService = new UserService();

        User user1 = new User( "Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
                "2003-08-01", "Indian", "Male");
        User email = new User("naan@gmail.com");
        try {
            assertFalse(userService.updateUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    // test invalid user name update
    @Test
    void testUpdateInvalidUserName() {
        UserService userService = new UserService();

        User user1 = new User( "", "Susikumar", "Pitchaimuthu", 8870737612L,
                "2003-08-01", "Indian", "Male");
        User email = new User("susi@gmail.com");
        try {
            assertFalse(userService.updateUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    // test invalid user gender details
    @Test
    void testUpdateInvalidGenderDetails() {
        UserService userService = new UserService();

        User user1 = new User( "kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
                "2003-08-01", "Indian", "Male234");
        User email = new User("susi@gmail.com");
        try {
            assertFalse(userService.updateUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    // test invalid nationality details
    @Test
    void testInvalidNationalityDetails() {
        UserService userService = new UserService();

        User user1 = new User( "kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
                "2003-08-12", "Indian", "Male");
        User email = new User("susi@gmail.com");
        try {
            assertFalse(userService.updateUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    // test invalid first name details
    @Test
    void testInvalidUserFirstNameDetails() {
        UserService userService = new UserService();

        User user1 = new User( "kanipapa", "", "Pitchaimuthu", 8870737612L,
                "2003-08-12", "Indian", "Male");
        User email = new User("susi@gmail.com");
        try {
            assertFalse(userService.updateUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    // test invalid last name details
    @Test
    void testInvalidUserLastNameDetails() {
        UserService userService = new UserService();

        User user1 = new User( "kanipapa", "Susikumar", "", 8870737612L,
                "2003-08-12", "Indian", "Male");
        User email = new User("susi@gmail.com");
        try {
            assertFalse(userService.updateUser(user1, email));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

}
