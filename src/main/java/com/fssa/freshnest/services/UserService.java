package com.fssa.freshnest.services;

import java.util.List;

import com.fssa.freshnest.constants.UserConstants;
import com.fssa.freshnest.dao.UserDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.utils.PasswordUtils;
import com.fssa.freshnest.validation.UserValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

/**
 * This class provides services related to user management, such as register,
 * login, list, update, and delete.
 *
 * @author SusikumarPitchaimuth
 */
public class UserService {

	/**
	 * Register a new user.
	 *
	 * @param user The user object to be registered.
	 * @return A success message if registration is successful, or an error message
	 *         if not.
	 * @throws ServiceException If there is a problem with the service.
	 */

	// User first page registration service
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			userDAO.checkUserDataExistOrNot(user.getEmail());
			String newPassword = PasswordUtils.hashPassword(user.getPassword());
			user.setPassword(newPassword);
			return userDAO.createUser(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Register a new user.
	 *
	 * @param user details should be added to the exact users details.
	 * @return A success message if registration is successful, or an error message
	 *         if not.
	 * @throws ServiceException If there is a problem with the service.
	 */

	// User second page registration service
	public boolean secondPageRegisterUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUserSecondRegistration(user);
			return userDAO.secondPageUserUpdate(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Log in a user.
	 *
	 * @param user The user object containing login information.
	 * @return The user object if login is successful.
	 * @throws ServiceException If there's a problem with the service.
	 */

	// User log in service
	public boolean logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(user);
			User userObject = userDAO.readUserDetailsByEmail(user.getEmail());

			if (userObject == null) {
				throw new ServiceException(UserConstants.getUserDetailsNotFound());
			}

			if (!PasswordUtils.checkPassword(user.getPassword(), userObject.getPassword())) {
				throw new ServiceException(UserConstants.getLoginPasswordInvalid());
			}

			return true;

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Update a user's information.
	 *
	 * @param user The user object containing the updated information.
	 * @return The updated user object.
	 * @throws ServiceException If there is an issue with the service.
	 */

	// user update details service
	public boolean updateUser(User user, User email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUpdateUser(user, email);
			return userDAO.updateUser(user, email);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Delete a user.
	 *
	 * @param user The email of the user to be deleted.
	 * @return True if the user is deleted successfully, false otherwise.
	 * @throws ServiceException If there's a problem with the service.
	 */

	// User delete user service
	public boolean deleteUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateDeleteUser(user);
			return userDAO.deleteUser(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Update a user's profile image.
	 *
	 * @param user The user object containing the updated profile image.
	 * @return The updated user object.
	 * @throws ServiceException If there is an issue with the service.
	 */

	// User profile image update service
	public boolean profileImageUpdate(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateProfileImageUpdate(user);
			return userDAO.updateProfileImage(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * List the all user data.
	 *
	 * @param user The user object containg the profile user email.
	 * @return If the email is valid The user details of where the email not equal
	 *         to the user profile email. Otherwise
	 * @throws ServiceException If there is no data in the database or email is not
	 *                          valid.
	 */
	public List<User> listUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();
		try {

			UserValidator.validateListUserDetails(user);
			return userDAO.listUser(user);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Read the user profile details.
	 *
	 * @param user The user object containg the user email.
	 * @return If the email is there return the user object with user's information.
	 *         Otherwise
	 * @throws ServiceException If the email is not exists in the databse.
	 */
	public User readUserDetails(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUserDetailReadFeature(user);

			User details = userDAO.readUserDetailsByEmail(user.getEmail());

			if (details == null) {
				throw new ServiceException(UserConstants.getUserDetailsNotFound());
			}
			return details;
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Read the user friends or user choosen user's information.
	 *
	 * @param user The user object contains the user id.
	 * @return If the user id is present in the databse return the choosen user
	 *         object, Otherwise
	 * @throws ServiceException If the user id not exists.
	 */

	public User readUserFrinedsDetails(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			User details = userDAO.readUserFrinedsDetailsByUserId(user.getUserId());

			if (details == null) {
				throw new ServiceException(UserConstants.getUserDetailsNotFound());
			}
			return details;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Search the user details by the user name.
	 *
	 * @param user The user object constains the user name.
	 * @return The object of user details if the username exists in the databse,
	 *         Otherwise.
	 * @throws ServiceException throw new serviceException with there is no user in
	 *                          this name.
	 */
	public List<User> searchUserList(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();
		try {
			List<User> userDetails = userDAO.searchUserName(user);

			if (userDetails.isEmpty()) {
				throw new ServiceException(UserConstants.getUserDetailsNotFound());
			}
			return userDetails;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves the total count of users in the system.
	 *
	 * @return The total count of users.
	 * @throws ServiceException If there is an issue while retrieving the user
	 *                          count.
	 */

	public int getTotalUserCount() throws ServiceException {

		UserDAO userDAO = new UserDAO();

		try {
			return userDAO.getTotalUserCount();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves a list of all user friends for a specific user.
	 *
	 * @param userId The ID of the user for whom to retrieve friends.
	 * @return A list of User objects representing the user's friends.
	 * @throws ServiceException If there is an issue while retrieving the user's
	 *                          friends.
	 */

	public List<User> getAllUserFriends(Integer userId) throws ServiceException {
		UserDAO useDAO = new UserDAO();
		try {
			List<User> userFriends = useDAO.getAllUserFriends(userId);

			if (userFriends.isEmpty()) {
				return null;
			}
			return userFriends;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves a list of users who are blocked by the specified user.
	 *
	 * @param userId The ID of the user for whom to retrieve blocked friends.
	 * @return A list of User objects representing users who are blocked by the
	 *         specified user.
	 * @throws ServiceException If there is an issue while retrieving the blocked
	 *                          friends.
	 */
	public List<User> getUserBlockedFriends(Integer userId) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			return userDAO.getUserBlockedFriends(userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves a list of user friend suggestions for the specified user.
	 *
	 * @param userId The ID of the user for whom to retrieve friend suggestions.
	 * @return A list of User objects representing friend suggestions for the user.
	 * @throws ServiceException If there is an issue while retrieving friend
	 *                          suggestions.
	 */

	public List<User> getUserFriendsSuggestions(Integer userId) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			return userDAO.getUserFriendsSuggestions(userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Checks whether a username already exists in the system.
	 *
	 * @param username The username to be checked for existence.
	 * @return True if the username already exists, false otherwise.
	 * @throws ServiceException If there is an issue while checking the username.
	 */
	
	public boolean checkWhetherTheUsernameIsExistOrNot(String username) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUserName(username);
			List<String> userNameList = userDAO.getAllUsernames();

			for (String name : userNameList) {
				if (username.equalsIgnoreCase(name)) {
					throw new ServiceException(
							"Username '" + username + "' is already taken. Please choose a different username.");
				}
			}
			return false;
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
