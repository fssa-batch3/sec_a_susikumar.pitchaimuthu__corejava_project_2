package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.InviteReactionDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.InviteReaction;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class InviteReactionService {

	/**
	 * Retrieves the details of a user's reaction to an invite.
	 *
	 * @param inviteReaction The InviteReaction object containing the user's
	 *                       reaction details.
	 * @return The InviteReaction object with the user's reaction details, or null
	 *         if no reaction found.
	 * @throws ServiceException If there's an issue while retrieving the user's
	 *                          invite reaction details.
	 */
	public InviteReaction getUserInviteReaction(InviteReaction inviteReaction) throws ServiceException {
		InviteReactionDAO inviteReactionDAO = new InviteReactionDAO();

		try {
			InviteReaction details = inviteReactionDAO.getUserInviteReaction(inviteReaction);

			return details;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Allows a user to like or react to an invite.
	 *
	 * @param inviteReaction The InviteReaction object containing the user's
	 *                       reaction details.
	 * @return True if the reaction was successfully updated or created; otherwise,
	 *         false.
	 * @throws ServiceException If there's an issue while updating or creating the
	 *                          invite reaction.
	 */
	public boolean userInviteLikeReaction(InviteReaction inviteReaction) throws ServiceException {
		InviteReactionDAO inviteReactionDAO = new InviteReactionDAO();

		try {
			if (inviteReactionDAO.checkWhetherTheUserInviteReactionAlreadyPresentOrNot(inviteReaction)) {
				return inviteReactionDAO.setInviteLikeUsingReactId(inviteReaction);
			} else {
				return inviteReactionDAO.userInviteReactionCreate(inviteReaction);
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Allows a user to send an invite request.
	 *
	 * @param inviteReaction The InviteReaction object containing the user's invite
	 *                       request details.
	 * @return True if the request was successfully updated or created; otherwise,
	 *         false.
	 * @throws ServiceException If there's an issue while updating or creating the
	 *                          invite request.
	 */

	public boolean userInviteSendRequest(InviteReaction inviteReaction) throws ServiceException {
		InviteReactionDAO inviteReactionDAO = new InviteReactionDAO();

		try {

			if (inviteReactionDAO.checkWhetherTheUserInviteReactionAlreadyPresentOrNot(inviteReaction)) {

				if (inviteReactionDAO.checkTheUserSendRejectResponseOrNot(inviteReaction)) {
					inviteReactionDAO.changeTheInviteRejectResponseIntoFalse(inviteReaction.getReactId());
				}

				return inviteReactionDAO.setUserInviteRequestUsingReactId(inviteReaction);
			} else {
				return inviteReactionDAO.userInviteReactionCreate(inviteReaction);
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Allows a user to send a reject response to an invite.
	 *
	 * @param inviteReaction The InviteReaction object containing the user's reject
	 *                       response details.
	 * @return True if the response was successfully updated or created; otherwise,
	 *         false.
	 * @throws ServiceException If there's an issue while updating or creating the
	 *                          reject response.
	 */

	public boolean userSendRejectResponse(InviteReaction inviteReaction) throws ServiceException {
		InviteReactionDAO inviteReactionDAO = new InviteReactionDAO();

		try {

			if (inviteReactionDAO.checkWhetherTheUserInviteReactionAlreadyPresentOrNot(inviteReaction)) {

				if (inviteReactionDAO.checkTheUserSendRequestOrNot(inviteReaction)) {
					inviteReactionDAO.changeTheInviteSendRequestIntoFalse(inviteReaction.getReactId());
				}
				return inviteReactionDAO.setUserInviteRejectResponseUsingReactId(inviteReaction);
			} else {
				return inviteReactionDAO.userInviteReactionCreate(inviteReaction);
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Sends a response to an invite request, updating the database.
	 *
	 * @param inviteReaction The InviteReaction object containing the user's
	 *                       response details.
	 * @return True if the response was successfully updated; otherwise, false.
	 * @throws ServiceException If there's an issue while updating the invite
	 *                          request response.
	 */
	public boolean sendBackTheInviteRequestResponse(InviteReaction inviteReaction) throws ServiceException {
		InviteReactionDAO inviteReactionDAO = new InviteReactionDAO();

		try {
			return inviteReactionDAO.sendBackTheInviteRequestResponse(inviteReaction);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
