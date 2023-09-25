package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.dao.StillDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.StillValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;
import java.util.Collections;

import java.util.List;

/**
 * This class provides services related to still management, such as take, list,
 * update, favourite, and delete.
 *
 * @author SusikumarPitchaimuth
 */
public class StillService {

	/**
	 * Take a new still
	 *
	 * @param still The still object to create.
	 * @return A success message if still creation is successful, or an error
	 *         message if not.
	 * @throws ServiceException If there is a problem with the service.
	 */

	// Service layer for the take still
	public boolean takeStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateTakeStill(still);
			return stillDAO.createStill(still);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Update still as a favourite.
	 *
	 * @param still The still object should be added with favourite.
	 * @return A success message if still added as favourite is successful, or an
	 *         error message if not.
	 * @throws ServiceException If there is a problem with the service.
	 */

	// Service layer for add still in their favourite list
	public boolean favouriteStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateFavouriteStill(still);
			return stillDAO.favouriteStill(still);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Update the still.
	 *
	 * @param still The still object should be updated and the updated still should
	 *              be added to the gallery.
	 * @return A success message if still is updated successful, or an error message
	 *         if not.
	 * @throws ServiceException If there is a problem with the service.
	 */

	// Service layer for the update the still
	public boolean updateStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateUpdateStill(still);
			return stillDAO.updateStill(still);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
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
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Get a list of all stills of the user.
	 *
	 * @return A list of still objects.
	 * @throws ServiceException If there's a problem with the service.
	 */
	// Service layer for the read still
	public List<Still> listStills(int userId) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			List<Still> result = stillDAO.listStills(userId);
			if(result.isEmpty()) {
				throw new ServiceException(StillConstants.getInvalidStillReadMessage());
			}
			return result;

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Read the each and every still details.
	 *
	 * @param still The still object contains the still id.
	 * @return If true return a still object , Otherwise
	 * @throws ServiceException throw new ServiceExcption if there is any error.
	 */

	public Still readStill(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateReadStill(still);

			Still result = stillDAO.readStillDetails(still);
			if (result == null) {
				throw new ServiceException(StillConstants.getInvalidStillReadMessage());
			}
			return result;
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Filter the still by the two dates.
	 *
	 * @param still The still object contains the form date, to date and user
	 *              object.
	 * @return If true return the list of stills, Otherwise
	 * @throws ServiceException throw new ServiceException "No stills found".
	 */

	public List<Still> filterStills(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			StillValidator.validateReadStill(still);
			List<Still> result = stillDAO.filterStills(still);

			if (result.isEmpty()) {
				throw new ServiceException(StillConstants.getInvalidStillFilterMessage());
			}
			return result;

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Filter the stills by the user's favourites.
	 *
	 * @param still The still object contains user id.
	 * @return If true return the list of stills, Otherwise
	 * @throws ServiceException throw new ServiceException "No stills found".
	 */
	public List<Still> filterStillByFavourite(Still still) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			List<Still> result = stillDAO.filterStillsByFavourite(still);

			if (result.isEmpty()) {
				throw new ServiceException(StillConstants.getInvalidStillFilterMessage());
			}
			return result;

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Filter the stills by the user's recently deleted (15 days).
	 *
	 * @param still The still object constains the user id.
	 * @return The list of stills if the stills are available, Otherwise
	 * @throws ServiceException throw new ServiceException "No stills are found"
	 */

	public List<Still> filterStillByRecentlyDeleted(int userId) throws ServiceException {
		StillDAO stillDAO = new StillDAO();
		try {
			List<Still> result = stillDAO.filterStillByRecentlyDeleted(userId);
			System.out.println(result);

			if (result.isEmpty()) {
				throw new ServiceException(StillConstants.getInvalidStillFilterMessage());
			}
			return result;

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
