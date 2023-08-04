package freshnest.services;

import freshnest.model.User;

public class TestDeleteFeature {
	public static void main(String[] args) {
		User user1 = new User("mani@gmail.com", true);

		UserService userService = new UserService();

		try {
			userService.DeleteUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}


