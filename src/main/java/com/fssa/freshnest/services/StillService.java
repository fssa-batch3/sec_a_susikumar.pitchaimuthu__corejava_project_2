package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.StillDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.StillValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.util.List;

/**
 * This class provides services related to still management, such as take, list, update, favourite, and delete.
 *
 * @author SusikumarPitchaimuth
 */
public class StillService {

    /**
     * Take a new still
     *
     * @param still The still object to create.
     * @return A success message if still creation is successful, or an error message if not.
     * @throws ServiceException If there is a problem with the service.
     */

    // Service layer for the take still
    public boolean takeStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateTakeStill(still);
            return stillDAO.createStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    /**
     * Update still as a favourite.
     *
     * @param still The still object should be added with favourite.
     * @return A success message if still added as favourite is successful, or an error message if not.
     * @throws ServiceException If there is a problem with the service.
     */

    // Service layer for add still in their favourite list
    public boolean favouriteStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateFavouriteStill(still);
            return stillDAO.favouriteStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    /**
     * Update the still.
     *
     * @param still The still object should be updated and the updated still should be added to the gallery.
     * @return A success message if still is updated  successful, or an error message if not.
     * @throws ServiceException If there is a problem with the service.
     */

    // Service layer for the update the still
    public boolean updateStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateUpdateStill(still);
            return stillDAO.updateStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    /**
     * Delete a user.
     *
     * @param still The still of the user to be deleted.
     * @return True if the still is deleted successfully, false otherwise.
     * @throws ServiceException If there's a problem with the service.
     */

    // Service layer for the delete the still
    public boolean deleteStill(Still still) throws ServiceException {
        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateDeleteStill(still);
            return stillDAO.deleteStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    /**
     * Get a list of all stills of the user.
     *
     * @return A list of still objects.
     * @throws ServiceException If there's a problem with the service.
     */
    // Service layer for the read still
    public List<Still> readStill(Still still) throws ServiceException {

        StillDAO stillDAO = new StillDAO();
        try {
            StillValidator.validateReadStill(still);
            return stillDAO.readStill(still);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }

}
