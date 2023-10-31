package com.fssa.freshnest.services;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.dao.ChatDAO;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.services.exceptions.ServiceException;
import com.fssa.freshnest.validation.ChatValidator;
import com.fssa.freshnest.validation.exceptions.InvalidUserException;

import java.util.List;

/**
 * This class provides services related to chat management, such as register,
 * login, list, update, and delete.
 *
 * @author SusikumarPitchaimuth
 */
public class ChatService {

	public boolean insertDirectGroup(Chat chat) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.insertChat(chat);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean insertChatParticipants(Chat chat) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.insertChatParticipant(chat);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Send the chat message.
	 *
	 * @param chat The sender message will be added to the database with the chat
	 *             id.
	 * @return A success message if the message send successfully, or an error
	 *         message if not.
	 * @throws ServiceException If there is a problem with service.
	 */

	// Create the chat message service layer.
	public boolean createChat(Chat chat) throws ServiceException {

		ChatDAO chatDAO = new ChatDAO();
		try {

			ChatValidator.validateChatSendMessage(chat);
			return chatDAO.insertChatMessage(chat);

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e.getMessage());
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
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Delete the chat message
	 *
	 * @param chat The chat object containing the deleting chat id and user id
	 *             information.
	 * @return True if the chat message is deleted, false otherwise.
	 * @throws ServiceException If there's a problem with the service.
	 */

	public boolean deleteChat(Chat chat) throws ServiceException {

		ChatDAO chatDAO = new ChatDAO();
		try {
			if (chatDAO.deleteChat(chat)) {
				return true;
			} else {
				throw new DAOException(ChatConstants.getInvalidChatDeleteMessage());
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}

	}

	/**
	 * Retrieves specific chat messages for a group chat.
	 *
	 * @param chat The Chat object representing the group chat.
	 * @return A list of Chat messages for the specified group chat.
	 * @throws ServiceException If there's an issue while retrieving chat messages.
	 */
	public List<Chat> getSpecificChatGroupChatMessages(Chat chat) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.getSpecificChatGroupMessages(chat);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves details of a direct chat group.
	 *
	 * @param chat The Chat object representing the direct chat group.
	 * @return The details of the direct chat group.
	 * @throws ServiceException If there's an issue while retrieving direct chat
	 *                          group details.
	 */
	public Chat getDirectChatGroupDetails(Chat chat) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.getDirectChatGroupDetails(chat);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves details of a group chat.
	 *
	 * @param chat The Chat object representing the group chat.
	 * @return The details of the group chat.
	 * @throws ServiceException If there's an issue while retrieving group chat
	 *                          details.
	 */
	public Chat getGroupChatDetails(Chat chat) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.getGroupChatDetails(chat);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Creates a new chat group.
	 *
	 * @param chat The Chat object representing the chat group to be created.
	 * @return True if the chat group is created successfully; otherwise, false.
	 * @throws ServiceException If there's an issue while creating the chat group.
	 */
	public boolean createChatGroup(Chat chat) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.createChatGroup(chat);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves chat groups that a user is a member of.
	 *
	 * @param userId The ID of the user for whom chat groups are retrieved.
	 * @return A list of Chat objects representing the chat groups that the user is
	 *         a member of.
	 * @throws ServiceException If there's an issue while retrieving chat groups for
	 *                          the user.
	 */
	public List<Chat> getUserChatGroups(int userId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.getUserChatGroups(userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves details of a direct conversation chat group for a user.
	 *
	 * @param chatId The ID of the chat group representing the direct conversation.
	 * @param userId The ID of the user who is part of the direct conversation.
	 * @return The Chat object containing details of the direct conversation chat
	 *         group.
	 * @throws ServiceException If there's an issue while retrieving direct
	 *                          conversation chat group details.
	 */
	public Chat getUserDirectConversationGroupDetails(int chatId, int userId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.getUserDirectConversationGroups(chatId, userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves details of a group conversation chat group.
	 *
	 * @param chatId The ID of the chat group representing the group conversation.
	 * @return The Chat object containing details of the group conversation chat
	 *         group.
	 * @throws ServiceException If there's an issue while retrieving group
	 *                          conversation chat group details.
	 */
	public Chat getUserGroupConversationGroupDetails(int chatId, int userId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();

		try {
			return chatDAO.getUserGroupConversationGroups(chatId,  userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Retrieves participants of a chat group.
	 *
	 * @param chatId The ID of the chat group for which participants are retrieved.
	 * @return A list of Chat objects representing the participants of the chat
	 *         group.
	 * @throws ServiceException If there's an issue while retrieving chat group
	 *                          participants.
	 */
	public List<Chat> getChatGroupParticipants(int chatId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.getChatGroupParticipants(chatId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Marks chat messages as read.
	 *
	 * @param chat The Chat object representing the chat and messages to be marked
	 *             as read.
	 * @return True if the chat messages are marked as read successfully; otherwise,
	 *         false.
	 * @throws ServiceException If there's an issue while marking chat messages as
	 *                          read.
	 */
	public boolean makeChatMessagesAsRead(List<Chat> chatMessage, int chatId,  int userId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.makeChatMessagesAsRead(chatMessage , chatId, userId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Checks whether a user is an admin of a chat group.
	 *
	 * @param userId The ID of the user to check for admin status.
	 * @param chatId The ID of the chat group to check for admin status.
	 * @return True if the user is an admin of the chat group; otherwise, false.
	 * @throws ServiceException If there's an issue while checking the user's admin
	 *                          status.
	 */
	public boolean checkWhetherTheUserIsAdminOrNot(int userId, int chatId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.checkWhetherTheUserIsAdminOrNot(userId, chatId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Makes a user an admin or removes admin status from a user in a chat group.
	 *
	 * @param userId  The ID of the user to be made an admin or removed from admin
	 *                status.
	 * @param chatId  The ID of the chat group in which the user's admin status is
	 *                modified.
	 * @param isAdmin True if the user should be made an admin; false to remove
	 *                admin status.
	 * @return True if the user's admin status is successfully modified; otherwise,
	 *         false.
	 * @throws ServiceException If there's an issue while modifying the user's admin
	 *                          status.
	 */
	public boolean makeUserAsGroupAdmin(int userId, int chatId, boolean isAdmin) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.makeUserAsGroupAdmin(userId, chatId, isAdmin);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Removes a user from a chat group.
	 *
	 * @param userId The ID of the user to be removed from the chat group.
	 * @param chatId The ID of the chat group from which the user is removed.
	 * @return True if the user is successfully removed from the chat group;
	 *         otherwise, false.
	 * @throws ServiceException If there's an issue while removing the user from the
	 *                          chat group.
	 */
	public boolean removeUserFromChatGroup(int userId, int chatId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.removeUserFromChatGroup(userId, chatId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Updates the profile image of a chat group.
	 *
	 * @param groupProfileImage The new profile image URL for the chat group.
	 * @param chatId            The ID of the chat group to update its profile
	 *                          image.
	 * @return True if the chat group's profile image is successfully updated;
	 *         otherwise, false.
	 * @throws ServiceException If there's an issue while updating the chat group's
	 *                          profile image.
	 */
	public boolean updateChatGroupProfileImage(String groupProfileImage, int chatId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.updateChatGroupProfileImage(groupProfileImage, chatId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Updates the details of a chat group, such as its name and theme.
	 *
	 * @param groupName  The new name for the chat group.
	 * @param groupTheme The new theme for the chat group.
	 * @param chatId     The ID of the chat group to update its details.
	 * @return True if the chat group's details are successfully updated; otherwise,
	 *         false.
	 * @throws ServiceException If there's an issue while updating the chat group's
	 *                          details.
	 */
	public boolean updateChatGroupDetails(String groupName, String groupTheme, int chatId) throws ServiceException {
		ChatDAO chatDAO = new ChatDAO();
		try {
			return chatDAO.updateChatGroupDetails(groupName, groupTheme, chatId);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

}
