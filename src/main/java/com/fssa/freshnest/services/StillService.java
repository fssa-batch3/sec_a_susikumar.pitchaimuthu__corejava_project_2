package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.StillDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.StillValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class StillService {

    public boolean takeStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateTakeStill(still);
            return stillDAO.createStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // Test still favourite

    public boolean favouriteStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateFavouriteStill(still);
            return stillDAO.favouriteStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // Test still Update

    public boolean updateStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateUpdateStill(still);
            return stillDAO.updateStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    /// Test still Delete
    public boolean deleteStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateDeleteStill(still);
            return stillDAO.deleteStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean readStill(Still still) throws ServiceException {

        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateReadStill(still);
            return stillDAO.readStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }

}
