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
            if (chatDAO.insertChat(insertChat) && chatDAO.insertChatParticipant(insertChatParticipant)
                    && chatDAO.insertChatMessage(insertMessage)) {
                System.out.println(insertMessage.getChat_message() + " chat send Successfully!");
                return true;
            } else {
                return false;
            }

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // chat read
    public boolean readChat(Chat chat) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateReadChat(chat);
            if (chatDAO.getChatsByUserId(chat)) {
                System.out.println(chat.getUserId() + " chat readed Successfully!");
                return true;
            } else {
                return false;
            }

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    // chat update
    public boolean updateChat(Chat chat) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateUpdateChat(chat);
            if (chatDAO.updateChat(chat)) {
                System.out.println(chat.getChatId() + " chat updated Successfully!");
                return true;
            } else {
                return false;
            }

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    public boolean deleteChat(Chat chat) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateDeleteChat(chat);
            if (chatDAO.deleteChat(chat)) {
                System.out.println(chat.getChatId() + " chat deleted Successfully!");
                return true;
            } else {
                return false;
            }

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

}
