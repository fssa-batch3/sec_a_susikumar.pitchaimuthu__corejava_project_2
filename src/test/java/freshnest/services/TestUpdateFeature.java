package freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import freshnest.model.User;
import freshnest.services.exceptions.ServiceException;

public class TestUpdateFeature {

	public static void main(String[] args) {
		Date dob = Date.valueOf("2003-08-01");

		User user1 = new User("susikumar@gmail.com", "Kanipapa", "raji@SM123", "Susikumar", "Pitchaimuthu", 20,
				8870737612L, dob, "Indian", "www.url.com", "Male");

		UserService userService = new UserService();

		try {
			userService.UpdateUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateSuccess() {
		Date dob = Date.valueOf("2003-08-01");

		User user1 = new User("susikumar@gmail.com", "Kanipapa", "raji@SM123", "Susikumar", "Pitchaimuthu", 20,
				8870737612L, dob, "Indian", "www.url.com", "Male");

		UserService userService = new UserService();

		try {
			userService.UpdateUser(user1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInavalidUpdateSuccess() {
		UserService userService = new UserService();
		Date dob = Date.valueOf("2003-08-01");

		User user1 = new User("mani@gmail.com", "Kanipapa", "raji@SM123", "Susikumar", "Pitchaimuthu", 20, 8870737612L,
				dob, "Indian", "www.url.com", "Male23");
		try {
			assertFalse(userService.UpdateUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
}
