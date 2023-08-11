package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.ChatDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.ChatValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

public class ChatService {

    public boolean createChat(Chat insertChat, Chat insertChatParticipant, Chat insertMessage) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateCreateChat(insertChat, insertChatParticipant, insertMessage);
            return chatDAO.insertChat(insertChat) && chatDAO.insertChatParticipant(insertChatParticipant)
                    && chatDAO.insertChatMessage(insertMessage);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // chat read
    public boolean readChat(Chat chat) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateReadChat(chat);
            return chatDAO.getChatsByUserId(chat);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // chat update
    public boolean updateChat(Chat chat) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateUpdateChat(chat);
            return chatDAO.updateChat(chat);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean deleteChat(Chat chat) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateDeleteChat(chat);
            return chatDAO.deleteChat(chat);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

}
