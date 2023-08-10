package com.fssa.freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class TestUserDeleteFeature {
	public static void main(String[] args) {
		User user1 = new User("susi@gmail.com", true);

		UserService userService = new UserService();

		try {
			userService.deleteUser(user1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

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
