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
            userDAO.checkUserDataExistOrNot(user.getEmail());
            return userDAO.createUser(user);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // User second page registration service
    public boolean secondPageRegisterUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validateUserSecondRegistration(user);
            return userDAO.secondPageUserUpdate(user);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // User log in service

    public boolean logInUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validateLogIn(user);
            return userDAO.checkUserLogin(user.getEmail(), user.getPassword());

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // user update details service
    public boolean updateUser(User user, User email) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validateUpdateUser(user, email);
            return userDAO.updateUser(user, email);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // User delete user service
    public boolean deleteUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validateDeleteUser(user);
            return userDAO.deleteUser(user);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean profileImageUpdate(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validateProfileImageUpdate(user);
            return userDAO.updateProfileImage(user);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

}
