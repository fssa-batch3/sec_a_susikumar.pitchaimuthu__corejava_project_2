package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.InviteReactionDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.InviteReaction;
import com.fssa.freshnest.services.exceptions.ServiceException;

public class InviteReactionService {

	public InviteReaction getUserInviteReaction(InviteReaction inviteReaction) throws ServiceException {

		InviteReactionDAO inviteReactionDAO = new InviteReactionDAO();

		try {
			InviteReaction details = inviteReactionDAO.getUserInviteReaction(inviteReaction);

			if (details == null) {
				return null;
			}
			return details;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

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

}
