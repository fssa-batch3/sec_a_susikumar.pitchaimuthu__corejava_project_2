package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.StillDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
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
                System.out.println(still.getStillName() + " Successfully Taken!");
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
                System.out.println(still.getStillId() + " is added as favourite Successfully!");
                return true;
            } else {
                System.out.println(still.getStillId() + " is not added as favourite...");
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
                System.out.println(still.getStillId() + " is updated Successfully!");
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
                System.out.println(still.getStillId() + " addde Successfully Taken!");
                return true;
            } else {
                return false;
            }

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean ReadStill(Still still) throws ServiceException {

        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateReadStill(still);
            if (stillDAO.readStill(still)) {
                System.out.println(still.getUserId() + " stills are read!");
                return true;
            } else {
                return false;
            }

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }

}
