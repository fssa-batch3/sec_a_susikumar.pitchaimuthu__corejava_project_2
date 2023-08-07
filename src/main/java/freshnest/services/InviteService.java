package freshnest.services;

import freshnest.DAO.InviteDAO;
import freshnest.DAO.exceptions.DAOException;
import freshnest.model.Invite;
import freshnest.services.exceptions.ServiceException;
import freshnest.validation.InviteValidator;
import freshnest.validation.exceptions.InvalidUserException;

public class InviteService {

	public boolean createInvite(Invite invite) throws ServiceException {
		InviteDAO inviteDAO = new InviteDAO();
		try {
			InviteValidator.validateInviteCreate(invite);
			if (inviteDAO.createInvite(invite)) {
				System.out.println(invite.getUser_id() + " invite is Successfully registered!");
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
				System.out.println(invite.getUser_id() + " invite is Successfully updated!");
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
				System.out.println(invite.getInvite_id() + " invite is Successfully updated!");
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
				System.out.println(invite.getReactor_id() + " invite reaction is successfully stored");
				return true;
			} else {
				System.out.println(invite.getReactor_id() + " invite reaction is not  stored");
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}

	}

}
