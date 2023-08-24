package com.fssa.freshnest.services;

import com.fssa.freshnest.dao.ChatDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.ChatValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.util.List;

/**
 * This class provides services related to chat management, such as register, login, list, update, and delete.
 *
 * @author SusikumarPitchaimuth
 */
public class ChatService {

    /**
     * Send the chat message.
     *
     * @param insertChat            The chat group to be created.
     * @param insertChatParticipant The chat participant details like id will be added.
     * @param insertMessage         The sender message will be added to the database with the chat id.
     * @return A success message if the message send successfully, or an error message if not.
     * @throws ServiceException If there is a problem with service.
     */

    // Create the chat message service layer.
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

    /**
     * List the group chats.
     *
     * @param chat List the chat message to the group according to the chat group id.
     * @return A success message if they list the chat message successfully, or an error message.
     * @throws ServiceException If there is a problem with the service.
     */

    // List the chat message service layer
    public List<Chat> readChat(Chat chat) throws ServiceException {
        ChatDAO chatDAO = new ChatDAO();
        try {
            ChatValidator.validateReadChat(chat);
            return chatDAO.getChatsByChatId(chat);
        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Update the chat message
     *
     * @param chat The chat object containing the updated information
     * @return The updated chat object
     * @throws ServiceException If there is an issue with the service.
     */

    // Update the chat message service layer
    public boolean updateChat(Chat chat) throws ServiceException {

        ChatDAO chatDAO = new ChatDAO();
        try {

            ChatValidator.validateUpdateChat(chat);
            return chatDAO.updateChat(chat);

        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }

    }

    /**
     * Delete the chat message
     *
     * @param chat The chat object containing the deleting chat id and user id information.
     * @return True if the chat message is deleted, false otherwise.
     * @throws ServiceException If there's a problem with the service.
     */

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
