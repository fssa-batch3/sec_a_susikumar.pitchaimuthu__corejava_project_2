package com.fssa.freshnest.services;

import com.fssa.freshnest.model.User;

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

}
