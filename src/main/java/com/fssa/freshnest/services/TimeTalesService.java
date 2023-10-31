package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.TimeTalesDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.TimeTales;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.TimeTalesValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.util.List;

public class TimeTalesService {

	/**
	 * Creates a time-tale for a user, storing its details in the database.
	 *
	 * @param timeTales The TimeTales object containing details of the time-tale to
	 *                  be created.
	 * @return true if the time-tale was successfully created, false otherwise.
	 * @throws ServiceException If there is an issue while creating the time-tale.
	 */
	public boolean createTimeTale(TimeTales timeTales) throws ServiceException {
		TimeTalesDAO timeTalesDAO = new TimeTalesDAO();

		try {
			TimeTalesValidator.validateCreateTimeTales(timeTales);
			return timeTalesDAO.createTimeTales(timeTales);
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Reads and retrieves details of a specific time-tale.
	 *
	 * @param timeTales The TimeTales object containing the ID of the time-tale to
	 *                  be read.
	 * @return The TimeTales object with details of the specified time-tale.
	 * @throws ServiceException If there is an issue while reading the time-tale
	 *                          details.
	 */

	public TimeTales readTimeTaleDetails(TimeTales timeTales) throws ServiceException {
		TimeTalesDAO timeTalesDAO = new TimeTalesDAO();

		try {
			return timeTalesDAO.readTimeTaleDetail(timeTales);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves a list of time-tales for a specific user.
	 *
	 * @param timeTales The TimeTales object containing the user ID for which to
	 *                  retrieve time-tales.
	 * @return A list of TimeTales objects representing the user's time-tales.
	 * @throws ServiceException If there is an issue while retrieving the
	 *                          time-tales.
	 */

	public List<TimeTales> listUserTimeTales(TimeTales timeTales) throws ServiceException {
		TimeTalesDAO timeTalesDAO = new TimeTalesDAO();

		try {
			return timeTalesDAO.listUserTimeTales(timeTales.getUserId());
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Deletes a time-tale by its ID.
	 *
	 * @param timeTale The TimeTales object containing the ID of the time-tale to be
	 *                 deleted.
	 * @return true if the time-tale was successfully deleted, false otherwise.
	 * @throws ServiceException If there is an issue while deleting the time-tale.
	 */
	public boolean deleteTimeTalesByTaleId(TimeTales timeTale) throws ServiceException {

		TimeTalesDAO timeTalesDAO = new TimeTalesDAO();

		try {
			return timeTalesDAO.deleteTimeTalesByTaleId(timeTale.getTaleId());
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves a list of time-tales from user's friends for a specific user.
	 *
	 * @param id The user ID for which to retrieve time-tales from friends.
	 * @return A list of TimeTales objects representing time-tales from user's
	 *         friends.
	 * @throws ServiceException If there is an issue while retrieving the
	 *                          time-tales.
	 */

	public List<TimeTales> getUserFriendsTimeTales(int id) throws ServiceException {
		TimeTalesDAO timeTaleDAO = new TimeTalesDAO();

		try {
			return timeTaleDAO.getUserFriendsTimeTales(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	
}
