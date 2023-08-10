package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.UserDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.UserValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class UserService {

	// User first page registration service
	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUser(user);
			if (userDAO.createUser(user)) {
				System.out.println(user.getUsername() + " Successfully registered!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// User second page reagistration service
	public boolean secondPageRegisterUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUserSecondRegistration(user);
			if (userDAO.secondPageUserUpdate(user)) {
				System.out.println(user.getEmail() + " Successfully registered!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// User log in service

	public boolean logInUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateLogIn(user);
			if (userDAO.checkUserLogin(user.getEmail(), user.getPassword())) {
				System.out.println(user.getEmail() + " Successfully Logged In!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// usre update details service
	public boolean UpdateUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateUpdateUser(user);
			if (userDAO.updateUser(user)) {
				System.out.println(user.getEmail() + " Detials are Successfully Modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// User delete user service
	public boolean DeleteUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateDeleteUser(user);
			if (userDAO.deleteUser(user)) {
				System.out.println(user.getEmail() + " Detials are Successfully deleted successfully!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean profileImageUpdate(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validateProfileImageUpdate(user);
			if (userDAO.updateProfileImage(user)) {
				System.out.println(user.getUserId() + " profile image is Successfully modified!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

}
