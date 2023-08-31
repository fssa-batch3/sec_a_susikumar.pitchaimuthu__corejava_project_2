package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.UserDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.UserValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.util.List;

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
     * if not.
     * @throws ServiceException If there is a problem with the service.
     */

    // User first page registration service
    public boolean registerUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validateUser(user);
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
     * if not.
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
            return userDAO.checkUserLogin(user.getEmail(), user.getPassword());

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

    public List<User> listUser(User user) throws ServiceException {

        UserDAO userDAO = new UserDAO();
        try {

            UserValidator.validateListUserDetails(user);
            return userDAO.listUser(user);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public List<User> readUserDetails(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validateUserDetailReadFeature(user);
            return userDAO.readUser(user);
        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }

    public List<User> searchUserList(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            return userDAO.searchUserName(user);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
