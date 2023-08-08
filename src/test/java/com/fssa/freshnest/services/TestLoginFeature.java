package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.UserService;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestLoginFeature {

	public static void main(String[] args) {
		User user1 = new User("susi@gmail.com", "susi123@SM");
		UserService userService = new UserService();

		try {
			userService.logInUser(user1);

		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testLoginSuccess() {
		UserService userService = new UserService();
		User user1 = new User("susi@gmail.com", "susi123@SM");
		try {
			assertTrue(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testEmailPasswordNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testInvalidPassword() {
		UserService userService = new UserService();
		User user1 = new User("susi@gmail.com", "susi123SM");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidEmail() {
		UserService userService = new UserService();
		User user1 = new User("susigmail.com", "susi123@SM");
		try {
			assertFalse(userService.logInUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
