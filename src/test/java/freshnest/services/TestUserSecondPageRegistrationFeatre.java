package freshnest.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import freshnest.model.User;
import freshnest.services.exceptions.ServiceException;

public class TestUserSecondPageRegistrationFeatre {

	public static void main(String[] args) {

		User user1 = new User("2003-08-29", "Male", "susi@gmail.com");
		UserService userService = new UserService();

		try {
			userService.secondPageRegisterUser(user1);

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}
	}

	@Test
	public void validateUserSecondRegistrationSuccess() {
		User user1 = new User("2003-08-29", "Male", "susikumar@gmail.com");
		UserService userService = new UserService();

		try {
			assertTrue(userService.secondPageRegisterUser(user1));

		} catch (ServiceException e) {
			e.printStackTrace();
			fail();

		}

	}

	@Test

	public void testUserSecondRegistrationNullDetails() {
		User user1 = null;
		UserService userService = new UserService();

		try {
			assertFalse(userService.secondPageRegisterUser(user1));

		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

}
