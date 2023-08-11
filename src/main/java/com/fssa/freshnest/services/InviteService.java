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
            return inviteDAO.createInvite(invite);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean updateInvite(Invite invite) throws ServiceException {
        InviteDAO inviteDAO = new InviteDAO();
        try {
            InviteValidator.validateInviteUpdate(invite);
            return inviteDAO.updateInvite(invite);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean deleteInvite(Invite invite) throws ServiceException {
        InviteDAO inviteDAO = new InviteDAO();
        try {
            InviteValidator.validateDeleteInvite(invite);
            return inviteDAO.deleteInvite(invite);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean reactionInvite(Invite invite) throws ServiceException {
        InviteDAO inviteDAO = new InviteDAO();

        try {
            InviteValidator.validateInviteReact(invite);
            return inviteDAO.reactInvite(invite);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

}
