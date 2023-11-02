package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.UserConstants;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
//    @Test
//    void testRegistrationSuccess() {
//        UserService userService = new UserService();
//        User user1 = new User("kani02375289578927892798254@gmail.com", "Kani Papa naan", "susi123@SM", "Susikumar", "Pitchaimuthu",
//                "imageurl");
//        try {
//
//            assertTrue(userService.registerUser(user1));
//        } catch (ServiceException e) {
//            fail();
//
//        }
//    }

	// User register with invalid password
	@Test
	void testUserRegisterWithInvalidPassword() {

		UserService userService = new UserService();
		User user1 = new User("susi@gmail.com", "Kani Papa", "susi123SM", "Susikumar", "Pitchaimuthu", "imageurl");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.registerUser(user1));

		assertEquals(UserConstants.getInvalidUserPasswordMessage(), result.getMessage());
	}

	// User second page registration

	// Second page registration with valid details
	@Test
	void testUserSecondRegistrationSuccess() {

		LocalDate dob = LocalDate.of(2003, 2, 24);

		User user1 = new User(dob, "Male", "susi@gmail.com");
		UserService userService = new UserService();

		try {
			assertTrue(userService.secondPageRegisterUser(user1));
		} catch (ServiceException e) {
			fail();
		}

	}

	@Test
	void testUserSecondPageRegistrationWithLessThanEighteenAge() {
		LocalDate dob = LocalDate.of(2010, 2, 24);

		User user1 = new User(dob, "Male", "susi@gmail.com");
		UserService userService = new UserService();

		ServiceException result = assertThrows(ServiceException.class, () -> userService.secondPageRegisterUser(user1));
		assertEquals(UserConstants.getInvalidUserDobMessage(), result.getMessage());

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
			fail();
		}
	}

	// User login with invalid password
	@Test
	void testInvalidPasswordLogin() {
		UserService userService = new UserService();
		User user1 = new User("susi@gmail.com", "mani123@SMsm");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.logInUser(user1));

		assertEquals(UserConstants.getLoginPasswordInvalid(), result.getMessage());

	}

	// User login with invalid email
	@Test
	void testLogInUserWithInvalidEmail() {
		UserService userService = new UserService();
		User user1 = new User("wertergmail.com", "susi123@SM");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.logInUser(user1));

		assertEquals(UserConstants.getInvalidUserEmailMessage(), result.getMessage());
	}

	// User update feature test

	// User update details with valid details
	@Test
	void testUserDetailsUpdateSuccessWithValidDetails() {
		LocalDate dob = LocalDate.of(2003, 3, 12);

		User user1 = new User("Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, dob, "Indian", "Male");
		User email = new User("susi@gmail.com");

		UserService userService = new UserService();

		try {
			assertTrue(userService.updateUser(user1, email));
		} catch (ServiceException e) {
			fail();
		}
	}

	// test invalid email address update
	@Test
	void testUpdateUserDetailsWithNotExistEmailInDatabase() {
		UserService userService = new UserService();
		LocalDate dob = LocalDate.of(2003, 1, 12);

		User user1 = new User("Kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, dob, "Indian", "Male");
		User email = new User("naan@gmail.com");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));

		assertEquals(UserConstants.getEmailIdNotExistsMessage(), result.getMessage());
	}

	// test invalid user name update
	@Test
	void testUpdateUserDetailsWithInvalidUserName() {
		UserService userService = new UserService();
		LocalDate dob = LocalDate.of(2002, 3, 02);

		User user1 = new User("er", "Susikumar", "Pitchaimuthu", 8870737612L, dob, "Indian", "Male");
		User email = new User("susi@gmail.com");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));

		assertEquals(UserConstants.getInvalidUserUserNameMessage(), result.getMessage());
	}

	// test invalid user gender details
	@Test
	void testUpdateUserDetailsWithInvalidGenderDetails() {
		UserService userService = new UserService();
		LocalDate dob = LocalDate.of(2002, 02, 12);

		User user1 = new User("kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, dob, "Indian", "Male234");
		User email = new User("susi@gmail.com");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));

		assertEquals(UserConstants.getInvalidUserGenderMessage(), result.getMessage());
	}

	// test invalid nationality details
	@Test
	void testUpdateUserDetailsWithInvalidNationalityDetails() {
		UserService userService = new UserService();
		LocalDate dob = LocalDate.of(2002, 04, 20);

		User user1 = new User("kanipapa", "Susikumar", "Pitchaimuthu", 8870737612L, dob, "e", "Male");
		User email = new User("susi@gmail.com");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));

		assertEquals(UserConstants.getInvalidUserNationalityMessage(), result.getMessage());
	}

	// test invalid first name details
	@Test
	void testUpdateUserDetailsWithInvalidFirstNameDetails() {
		UserService userService = new UserService();
		LocalDate dob = LocalDate.of(2000, 02, 10);

		User user1 = new User("kanipapa", "r", "Pitchaimuthu", 8870737612L, dob, "Indian", "Male");
		User email = new User("susi@gmail.com");
		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));

		assertEquals(UserConstants.getInvalidUserFirstNameMessage(), result.getMessage());
	}

	// test invalid last name details
	@Test
	void testUpdateUserDetailsWithInvalidLastNameDetails() {
		UserService userService = new UserService();
		LocalDate dob = LocalDate.of(1999, 2, 23);

		User user1 = new User("kanipapa", "Susikumar", "m", 8870737612L, dob, "Indian", "Male");
		User email = new User("susi@gmail.com");

		ServiceException result = assertThrows(ServiceException.class, () -> userService.updateUser(user1, email));

		assertEquals(UserConstants.getInvalidUserLastNameMessage(), result.getMessage());
	}

	// User delete feature test

	// test delete the user with valid details
	@Test
	void testUserDeleteSuccess() {
		User user1 = new User("naveen@gmail.com", true);
		UserService userService = new UserService();
		try {
			assertTrue(userService.deleteUser(user1));
		} catch (ServiceException e) {
			fail();
		}
	}

	// test delete user invalid email
	@Test
	void testDeleteUserAccountWithNotExistEmail() {
		User user1 = new User("naan@gmail.com", true);
		UserService userService = new UserService();

		ServiceException result = assertThrows(ServiceException.class, () -> userService.deleteUser(user1));

		assertEquals(UserConstants.getInvalidUserDeleteMessage(), result.getMessage());
	}

	// Test update the user profile image details

	@Test
	void testUserProfileImageUpdateSuccess() {
		User user1 = new User("https://example.com/image.jpg", 1);
		UserService userService = new UserService();
		try {
			assertTrue(userService.profileImageUpdate(user1));
		} catch (ServiceException e) {
			fail();

		}
	}

	// test the invalid image url update

	@Test
	void testProfileInvalidImageUrl() {
		User user1 = new User("httpexample", 1);
		UserService userService = new UserService();
		ServiceException result = assertThrows(ServiceException.class, () -> userService.profileImageUpdate(user1));

		assertEquals(UserConstants.getInvalidUserProfileImageUrlMessage(), result.getMessage());
	}

	@Test
	void testReadUserProfileDetails() {
		User user1 = new User("susi@gmail.com");
		UserService userService = new UserService();
		try {
			User result = userService.readUserDetails(user1);
			assertNotNull(result);

		} catch (ServiceException e) {
			fail();

		}
	}

	@Test
	void testReadUserProfileDetailsWithInvalidEmailId() {
		User user1 = new User("skdfuwerkwer@gmail.com");
		UserService userService = new UserService();
		ServiceException result = assertThrows(ServiceException.class, () -> userService.readUserDetails(user1));
		assertEquals(UserConstants.getUserDetailsNotFound(), result.getMessage());
	}

	// List user feature

	@Test
	void testListUsersFeatureSuccessWithValidDetails() {
		User user1 = new User("ajai@gmail.com");
		UserService userService = new UserService();

		try {
			List<User> result = userService.listUser(user1);

			assertNotNull(result);

		} catch (ServiceException e) {
			fail();

		}
	}

	@Test
	void testListUsersFeatureWithInValidEmail() {
		User user1 = new User("ssdfsfdgmail.com");
		UserService userService = new UserService();

		ServiceException result = assertThrows(ServiceException.class, () -> userService.listUser(user1));
		assertEquals(UserConstants.getInvalidUserEmailMessage(), result.getMessage());
	}

	// test user search feature
	@Test
	void testUserSearchFeatureByUsingUsername() {
		User user = new User();
		user.setUsername("kanipapa");
		UserService userService = new UserService();

		try {
			List<User> result = userService.searchUserList(user);
			assertNotNull(result);

		} catch (ServiceException e) {
			fail();

		}

	}

	@Test
	void testUserSearchUserWithInvalidUsername() {
		User user = new User();
		user.setUsername("sdfsf");
		UserService userService = new UserService();

		ServiceException result = assertThrows(ServiceException.class, () -> userService.searchUserList(user));
		assertEquals(UserConstants.getUserDetailsNotFound(), result.getMessage());
	}

	@Test
	void testUserFriendsReadFeatureSuccess() {
		User user = new User();
		user.setUserId(1);
		UserService userService = new UserService();

		try {
			User userDetails = userService.readUserFrinedsDetails(user);
			assertNotNull(userDetails);
		} catch (ServiceException e) {
			fail();
		}
	}

	@Test
	void testUserFriendsDetailsWithInvalidUserDetails() {
		User user = new User();
		user.setUserId(0);
		UserService userService = new UserService();

		ServiceException result = assertThrows(ServiceException.class, () -> userService.readUserFrinedsDetails(user));
		assertEquals(UserConstants.getUserDetailsNotFound(), result.getMessage());

	}

	@Test
	void testGetAllUserCount() {
		UserService userService = new UserService();

		try {
			userService.getTotalUserCount();
		} catch (ServiceException e) {
			fail();
		}

	}

	@Test
	void testGetUserAllFriends() {
		int userId = 1;
		UserService userService = new UserService();
		try {
			List<User> userFriends = userService.getAllUserFriends(userId);
			assertNotNull(userFriends);
		} catch (ServiceException e) {
			fail();
		}
	}

	@Test
	void testGetUserFriendSuggestion() {
		int userId = 1;
		UserService userService = new UserService();
		try {
			List<User> userFriends = userService.getUserFriendsSuggestions(userId);
			assertNotNull(userFriends);
		} catch (ServiceException e) {
			fail();
		}
	}

	@Test
	public void testUsernameDoesNotExist() {
		UserService userService = new UserService();
		boolean result;
		try {
			result = userService.checkWhetherTheUsernameIsExistOrNot("Naan_ready_vara");
			assertFalse(result);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUsernameExists() {
		UserService userService = new UserService();
		String username = "Aarthi";
		ServiceException result = assertThrows(ServiceException.class,
				() -> userService.checkWhetherTheUsernameIsExistOrNot(username));
		assertEquals(result.getMessage(),
				"Username '" + username + "' is already taken. Please choose a different username.");
	}

	@Test
	public void testUsernameExistsWithDifferentCasing() {
		UserService userService = new UserService();
		String username = "aaRThi";
		ServiceException result = assertThrows(ServiceException.class,
				() -> userService.checkWhetherTheUsernameIsExistOrNot(username));
		assertEquals(result.getMessage(),
				"Username '" + username + "' is already taken. Please choose a different username.");
	}

	@Test
	public void testInvalidUsername() {
		UserService userService = new UserService();

		String username = "se";
		ServiceException result = assertThrows(ServiceException.class,
				() -> userService.checkWhetherTheUsernameIsExistOrNot(username));
		assertEquals(result.getMessage(), UserConstants.getInvalidUserUserNameMessage());
	}

}
