package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.dao.InviteDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.InviteValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.util.List;

/**
 * This class provides services related to invite management, such as take,
 * list, update, favourite, and delete.
 *
 * @author SusikumarPitchaimuth
 */
public class InviteService {

	/**
	 * Create invitation
	 *
	 * @param invite The invite object to be created
	 * @return A success message if the invitation is successfully created, or and
	 *         error message if not.
	 * @throws ServiceException If there is an problem with the service
	 */

	public boolean createInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteCreate(invite);
			return inviteDAO.createInvite(invite);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Update the invitation
	 *
	 * @param invite The invitation object of the user containing the updated
	 *               information.
	 * @return The updated invite object of the user.
	 * @throws ServiceException If there is an issue with the service.
	 */

	public boolean updateInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteUpdate(invite);
			return inviteDAO.updateInvite(invite);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * @param invite The invite details of the user to be deleted.
	 * @return The message will be true id the invite object of the user is deleted,
	 *         false otherwise.
	 * @throws ServiceException If there is a problem with the service.
	 */

	public boolean deleteInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateDeleteInvite(invite);
			return inviteDAO.deleteInvite(invite);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * @param invite Get the list of invite of the user.
	 * @return List the invite of the user.
	 * @throws ServiceException If there is a problem with the service.
	 */

	public List<Invite> listInvites(int userId) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			return inviteDAO.listInvites(userId);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<Invite> listFriendsInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			return inviteDAO.listFriendsInvite(invite);

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Invite readInviteDetails(int inviteId) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			Invite inviteDetail = inviteDAO.readUserInviteDetailsByInviteId(inviteId);
			System.out.println(inviteDetail);
			if (inviteDetail == null) {
				throw new ServiceException(InviteConstants.getInvalidInviteReadMessage());
			}
			return inviteDetail;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public User getInviteCreatorUserDetails(int inviteId) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();

		try {
			User creator = inviteDAO.getInviteCreatorUserDetails(inviteId);
			if (creator == null) {
				throw new ServiceException(InviteConstants.getCreatorDetailNotFound());
			}
			return creator;

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
