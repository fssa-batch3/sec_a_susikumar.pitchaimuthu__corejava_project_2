package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class TestUserService {

    // User register feature test
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
    void testInvalidPasswordRegister() {

        UserService userService = new UserService();
        User user1 = new User("Susi@gmail.com", "Kani Papa", "susi123SM", "Susikumar", "Pitchaimuthu", "https://example.com/image.jpg");
        try {
            assertFalse(userService.registerUser(user1));
        } catch (ServiceException e) {
            e.printStackTrace();

        }
    }

    // User login feature test

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
    void testInvalidPasswordLogin() {
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
    // User update feature test


     @Test
     void testUpdateSuccess() {

         User user1 = new User("Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
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

         User user1 = new User("Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
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

         User user1 = new User("", "Susikumar", "Pitchaimuthu", 8870737612L,
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

         User user1 = new User("kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
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

         User user1 = new User("kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L,
                 "2003-08-12", "", "Male");
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

         User user1 = new User("kanipapa", "", "Pitchaimuthu", 8870737612L,
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

         User user1 = new User("kanipapa", "Susikumar", "", 8870737612L,
                 "2003-08-12", "Indian", "Male");
         User email = new User("susi@gmail.com");
         try {
             assertFalse(userService.updateUser(user1, email));
         } catch (ServiceException e) {
             e.printStackTrace();

         }
     }


     // User delete feature test
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
