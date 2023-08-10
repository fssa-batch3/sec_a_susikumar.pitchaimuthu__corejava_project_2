package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.InviteDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.InviteValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class InviteService {

	public boolean createInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteCreate(invite);
			if (inviteDAO.createInvite(invite)) {
				System.out.println(invite.getUserId() + " invite is Successfully registered!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean updateInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteUpdate(invite);
			if (inviteDAO.updateInvite(invite)) {
				System.out.println(invite.getUserId() + " invite is Successfully updated!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean deleteInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateDeleteInvite(invite);
			if (inviteDAO.deleteInvite(invite)) {
				System.out.println(invite.getInviteId() + " invite is Successfully updated!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

	public boolean reactionInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();

		try {
			InviteValidator.validateInviteReact(invite);
			if (inviteDAO.reactInvite(invite)) {
				System.out.println(invite.getReactorId() + " invite reaction is successfully stored");
				return true;
			} else {
				System.out.println(invite.getReactorId() + " invite reaction is not  stored");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

}
