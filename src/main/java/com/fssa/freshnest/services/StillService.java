package com.fssa.freshnest.services;

import com.fssa.freshnest.DAO.StillDAO;
import com.fssa.freshnest.DAO.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.StillValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class StillService {

	public boolean TakeStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateTakeStill(still);
			if (stillDAO.createStill(still)) {
				System.out.println(still.getStill_name() + " Successfully Taken!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// Test still favourite

	public boolean FavouriteStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateFavouriteStill(still);
			if (stillDAO.FavouriteStill(still)) {
				System.out.println(still.get_still_id() + " is added as favourite Successfully!");
				return true;
			} else {
				System.out.println(still.get_still_id() + " is not added as favourite...");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	// Test still Update

	public boolean UpdateStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateUpdateStill(still);
			if (stillDAO.UpdateStill(still)) {
				System.out.println(still.get_still_id() + " is updated Successfully!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	/// Test still Delete
	public boolean DeleteStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateDeleteStill(still);
			if (stillDAO.DeleteStill(still)) {
				System.out.println(still.get_still_id() + " addde Successfully Taken!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean ReadStill(Still still)throws ServiceException {

		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateReadStill(still);
			if (stillDAO.readStill(still)) {
				System.out.println(still.getUser_id() + " stills are read!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

}