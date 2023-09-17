package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.InviteDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Invite;
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

	public List<Invite> listInvites(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteRead(invite);
			return inviteDAO.listInvites(invite);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<Invite> listFriendsInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteRead(invite);
			return inviteDAO.listFriendsInvite(invite);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public Invite listInviteDetails(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteRead(invite);
			return inviteDAO.listUserInviteDetails(invite);
		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean checkUserLikedTheInviteOrNot(Invite invite) throws ServiceException {

		InviteDAO inviteDAO = new InviteDAO();

		try {
			return inviteDAO.checkUserLikedTheInviteOrNot(invite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean checkUserSendNoResponseOrNot(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();

		try {
			return inviteDAO.checkUserSendNoResponseOrNot(invite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean checkTheUserSendRequestOrNot(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();

		try {
			return inviteDAO.checkTheUserSendRequestOrNot(invite);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}
}
