package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.UserConstants;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test cases for the UserService class, which handles
 * various user-related operations.
 *
 * @author SusikumarPitchaimuth
 */
class TestUserService {

	// User register feature test

	// User registration with valid details
	@Test
	void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("akalya@gmail.com", "Kani Papa", "susi123@SM", "Susikumar", "Pitchaimuthu", "imageurl");
		try {

			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}

	// User register with invalid password
	@Test
	void testUserRegisterWithInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("Susi@gmail.com", "Kani Papa", "susi123SM", "Susikumar", "Pitchaimuthu", "imageurl");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.registerUser(user1));
		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserPasswordMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// User second page registration

	// Second page registration with valid details
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

	// User login feature test

	// User login with valid details
	@Test
	void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("susi@gmail.com", "susi123@SMsm");
		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	// User login with invalid password
	@Test
	void testInvalidPasswordLogin() {
		UserService userService = new UserService();
		User user1 = new User("susi@gmail.com", "susi123SM");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.logInUser(user1));
		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserPasswordMessage();
		assertEquals(expectedMessage, result.getMessage());

	}

	// User login with invalid email
	@Test
	void testLogInUserWithInvalidEmail() {
		UserService userService = new UserService();
		User user1 = new User("susigmail.com", "susi123@SM");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.logInUser(user1));
		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserEmailMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// User update feature test

	// User update details with valid details
	@Test
	void testUserDetailsUpdateSuccessWithValidDetails() {

		User user1 = new User("Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, "2003-08-01", "Indian", "Male");
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
	void testUpdateUserDetailsWithNotExistEmailInDatabase() {
		UserService userService = new UserService();

		User user1 = new User("Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, "2003-08-01", "Indian", "Male");
		User email = new User("naan@gmail.com");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));
		String expectedMessage = UserConstants.getCommonDaoErrorMessage() + UserConstants.getEmailIdNotExistsMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// test invalid user name update
	@Test
	void testUpdateUserDetailsWithInvalidUserName() {
		UserService userService = new UserService();

		User user1 = new User("er", "Susikumar", "Pitchaimuthu", 8870737612L, "2003-08-01", "Indian", "Male");
		User email = new User("susi@gmail.com");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));
		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserUserNameMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// test invalid user gender details
	@Test
	void testUpdateUserDetailsWithInvalidGenderDetails() {
		UserService userService = new UserService();

		User user1 = new User("kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, "2003-08-01", "Indian", "Male234");
		User email = new User("susi@gmail.com");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));
		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserGenderMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// test invalid nationality details
	@Test
	void testUpdateUserDetailsWithInvalidNationalityDetails() {
		UserService userService = new UserService();

		User user1 = new User("kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, "2003-08-12", "e", "Male");
		User email = new User("susi@gmail.com");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));
		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserNationalityMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// test invalid first name details
	@Test
	void testUpdateUserDetailsWithInvalidFirstNameDetails() {
		UserService userService = new UserService();

		User user1 = new User("kanipapa", "r", "Pitchaimuthu", 8870737612L, "2003-08-12", "Indian", "Male");
		User email = new User("susi@gmail.com");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));
		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserFirstNameMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// test invalid last name details
	@Test
	void testUpdateUserDetailsWithInvalidLastNameDetails() {
		UserService userService = new UserService();

		User user1 = new User("kanipapa", "Susikumar", "m", 8870737612L, "2003-08-12", "Indian", "Male");
		User email = new User("susi@gmail.com");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));

		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserLastNameMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// User delete feature test

	// test delete the user with valid details
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
	void testDeleteUserAccountWithNotExistEmail() {
		User user1 = new User("naan@gmail.com", true);
		UserService userService = new UserService();

		ServiceException result = assertThrows(ServiceException.class, () -> userService.deleteUser(user1));

		String expectedMessage = UserConstants.getCommonDaoErrorMessage() + UserConstants.getInvalidUserDeleteMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	// Test update the user profile image details

	@Test
	void testUserProfileImageUpdateSuccess() {
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

	@Test
	void testProfileInvalidImageUrl() {
		User user1 = new User("httpexample", 1);
		UserService userService = new UserService();
		ServiceException result = assertThrows(ServiceException.class, () -> userService.profileImageUpdate(user1));

		String expectedMessage = UserConstants.getCommonServiceErrorMessage()
				+ UserConstants.getInvalidUserProfileImageUrlMessage();
		assertEquals(expectedMessage, result.getMessage());
	}

	@Test
	void testReadUserProfileDetails() {
		User user1 = new User("susi@gmail.com");
		UserService userService = new UserService();
		try {
			List<User> result = userService.readUserDetails(user1);
			assertNotNull(result);
			assertFalse(result.isEmpty());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}

	// List user feature

	@Test
	void testListUsersFeatureSuccessWithValidDetails() {
		User user1 = new User("susi@gmail.com");
		UserService userService = new UserService();

		try {

			List<User> result = userService.listUser(user1);
			for (User u : result) {
				System.out.println(u);
			}

			assertNotNull(result);
			assertFalse(result.isEmpty());

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}
}
