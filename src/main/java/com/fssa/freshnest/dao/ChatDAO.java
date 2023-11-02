package com.fssa.freshnest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.utils.ConnectionUtils;

/**
 * This class provides data access methods to interact with the chat-related
 * database tables.
 *
 * @author SusikumarPitchaimuth
 */
public class ChatDAO {

	/**
	 * Inserts a new chat record into the database.
	 *
	 * @param chat The Chat object containing chat information to be created.
	 * @return True if the chat is successfully created, otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	public boolean insertChat(Chat chat) throws DAOException {
		String insertChatQuery = "INSERT INTO chats (chat_type, chat_name ) VALUES (?, ?)";
		String getLastChatId = "SELECT LAST_INSERT_ID() AS chat_id";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertChatQuery)) {
			statement.setString(1, chat.getChatType());
			statement.setString(2, chat.getChatName());
			int rows = statement.executeUpdate();

			try (ResultSet resultSet = statement.executeQuery(getLastChatId)) {
				if (resultSet.next()) {
					chat.setChatId(resultSet.getInt("chat_id"));
				}
			}

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Inserts participants for a chat record in the database.
	 *
	 * @param chat The Chat object containing chat and participant information.
	 * @return True if the participants are successfully inserted, otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	public boolean insertChatParticipant(Chat chat) throws DAOException {
		String insertParticipantQuery = "INSERT INTO chat_participants (chat_id, user_id) VALUES (?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertParticipantQuery)) {

			// Getting total chat participants id
			int[] chatParticipantsId = chat.getParticipantsId();

			for (int id : chatParticipantsId) {
				statement.setInt(1, chat.getChatId());
				statement.setInt(2, id);
				statement.addBatch();
			}

			int[] rows = statement.executeBatch();
			return Arrays.stream(rows).allMatch(row -> row > 0);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Inserts a new chat message record into the database.
	 *
	 * @param chat The Chat object containing chat message information to be
	 *             created.
	 * @return True if the chat message is successfully created, otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	public boolean insertChatMessage(Chat chat) throws DAOException {
		String insertMessageQuery = "INSERT INTO chat_messages (chat_id, sender_id, message) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertMessageQuery)) {
			statement.setInt(1, chat.getChatId());
			statement.setInt(2, chat.getSenderId());
			statement.setString(3, chat.getChatMessage());

			int rows = statement.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves a list of chat messages for a specific chat from the database.
	 *
	 * @param chat The Chat object containing chat ID for which to retrieve
	 *             messages.
	 * @return A list of Chat objects representing chat messages.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	// Read chat details
	public List<Chat> getChatsByChatId(Chat chat) throws DAOException {
		List<Chat> chatMessages = new ArrayList<>();

		String selectChatsQuery = "SELECT cm.message_id, cm.message, cm.timestamp, cm.sender_id "
				+ "FROM chat_messages cm " + "JOIN users u ON cm.sender_id = u.user_id " + "WHERE cm.chat_id = ? "
				+ "ORDER BY cm.timestamp;";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectChatsQuery)) {

			statement.setInt(1, chat.getChatId());
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Chat chatResult = new Chat();
					chatResult.setMessageId(resultSet.getInt("message_id"));
					chatResult.setChatMessage(resultSet.getString("message"));
					chatResult.setTimestamp(resultSet.getTimestamp("timestamp"));
					chatResult.setSenderId(resultSet.getInt("sender_id"));

					chatMessages.add(chatResult);
				}
				return chatMessages;
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * Updates a chat message in the database.
	 *
	 * @param chat The Chat object containing updated chat message information.
	 * @return True if the chat message is successfully updated, otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	// Update chat
	public boolean updateChat(Chat chat) throws DAOException {
		String updateQuery = "UPDATE chat_messages SET message = ? WHERE message_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setString(1, chat.getChatMessage());
			statement.setInt(2, chat.getMessageId());

			int rows = statement.executeUpdate();

			if (rows > 0) {
				return true;
			} else {
				throw new DAOException(ChatConstants.getInvalidChatUpdateMessage());
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Deletes a chat message in the database.
	 *
	 * @param chat The Chat object containing information about the message to be
	 *             deleted.
	 * @return True if the chat message is successfully marked as deleted, otherwise
	 *         false.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	// Delete chat
	public boolean deleteChat(Chat chat) throws DAOException {
		String updateQuery = "UPDATE chat_messages SET is_delete = 1 WHERE message_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setInt(1, chat.getMessageId());

			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Get the all user chat groups by the user ID.
	 * 
	 * @param userId This is the unique ID of the user.
	 * @return The function will return a list of chat groups, including both Direct
	 *         Message and Group Conversation groups, if the user has followers or
	 *         is a participant in any chat groups. Otherwise, it will throw an
	 *         exception.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public List<Chat> getUserChatGroups(int userId) throws DAOException {
		List<Chat> userChatGroups = new ArrayList<>();
		String getQuery = "SELECT c.chat_id, c.chat_type " + "FROM chats c "
				+ "JOIN chat_participants cp ON c.chat_id = cp.chat_id " + "WHERE cp.user_id = ? AND c.is_active = 1";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(getQuery)) {
			statement.setInt(1, userId);

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Chat chat = new Chat();
					chat.setChatId(resultSet.getInt("chat_id"));
					chat.setChatType(resultSet.getString("chat_type"));
					userChatGroups.add(chat);
				}
			}
			return userChatGroups;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Get the all user chat groups by the user ID.
	 * 
	 * @param userId This is the unique ID of the user.
	 * @return The function will return a list of chat groups, including both Direct
	 *         Message and Group Conversation groups, if the user has followers or
	 *         is a participant in any chat groups. Otherwise, it will throw an
	 *         exception.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public List<Chat> getAllUserChatGroupList(int userId) throws DAOException {
		List<Chat> chatGroups = new ArrayList<>();
		String chatGroupGetQuery = "SELECT cu.username AS other_user_username, cu.profile_image AS other_user_profile_image, cu.user_theme AS user_theme, c.chat_id, c.chat_name, c.chat_type, cm.message AS last_message, latest_messages.max_timestamp AS last_message_timestamp "
				+ "FROM chat_participants cp " + "JOIN chats c ON cp.chat_id = c.chat_id "
				+ "JOIN users u ON cp.user_id = u.user_id "
				+ "LEFT JOIN chat_participants cp2 ON c.chat_id = cp2.chat_id AND u.user_id != cp2.user_id "
				+ "LEFT JOIN users cu ON cp2.user_id = cu.user_id " + "LEFT JOIN ( "
				+ "    SELECT chat_id, MAX(timestamp) AS max_timestamp " + "    FROM chat_messages "
				+ "    GROUP BY chat_id " + ") AS latest_messages ON c.chat_id = latest_messages.chat_id "
				+ "LEFT JOIN chat_messages cm ON latest_messages.chat_id = cm.chat_id AND latest_messages.max_timestamp = cm.timestamp "
				+ "WHERE u.user_id = ?;";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(chatGroupGetQuery)) {
			statement.setInt(1, userId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Chat chatResult = new Chat();
					chatResult.setChatId(resultSet.getInt("chat_id"));
					chatResult.setChatName(resultSet.getString("chat_name"));
					chatResult.setChatType(resultSet.getString("chat_type"));
					chatResult.setProfileImage(resultSet.getString("other_user_profile_image"));
					chatResult.setUsername(resultSet.getString("other_user_username"));
					chatResult.setUserTheme(resultSet.getString("user_theme"));
					String latestMessage = resultSet.getString("last_message");
					Timestamp lastTimeStamp = resultSet.getTimestamp("last_message_timestamp");

					if (latestMessage != null) {
						chatResult.setChatMessage(latestMessage);
					}
					if (lastTimeStamp != null) {
						chatResult.setTimestamp(lastTimeStamp);
					}

					chatGroups.add(chatResult);
				}
			}
			return chatGroups;

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * Get the all chat messsages of specific chat groups.
	 * 
	 * @param chat The chat contains the chat group unique ID of chat ID.
	 * @return The function will return the list chat message if there is any
	 *         converstaion present in the chat group. Otherwise it will throw an
	 *         exception.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public List<Chat> getSpecificChatGroupMessages(Chat chat) throws DAOException {
		String getQuery = "SELECT cm.message_id, cm.chat_id, cm.sender_id, cm.message, cm.timestamp, u.profile_image, u.username "
				+ "FROM chat_messages cm " + "JOIN users u ON cm.sender_id = u.user_id "
				+ "WHERE cm.chat_id = ? AND cm.is_delete = 0 " + "ORDER BY cm.timestamp";

		List<Chat> chatMessages = new ArrayList<>();

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(getQuery)) {
			statement.setInt(1, chat.getChatId());

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Chat message = new Chat();
					message.setMessageId(resultSet.getInt("message_id"));
					message.setChatId(resultSet.getInt("chat_id"));
					message.setSenderId(resultSet.getInt("sender_id"));
					message.setChatMessage(resultSet.getString("message"));
					message.setTimestamp(resultSet.getTimestamp("timestamp"));
					message.setProfileImage(resultSet.getString("profile_image"));
					message.setUsername(resultSet.getString("username"));

					chatMessages.add(message);
				}
			}
			return chatMessages;
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * Get chat Direct chat group other side participant details.
	 * 
	 * @param chat The chat contains the chat ID of the group and the user ID.
	 * @return It will return the chat object.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public Chat getDirectChatGroupDetails(Chat chat) throws DAOException {
		String getQuery = "SELECT u.username, u.profile_image " + "FROM chat_participants cp "
				+ "INNER JOIN users u ON cp.user_id = u.user_id " + "WHERE cp.chat_id = ? AND cp.user_id != ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(getQuery)) {
			statement.setInt(1, chat.getChatId());
			statement.setInt(2, chat.getUserId());
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					chat.setUsername(resultSet.getString("username"));
					chat.setProfileImage(resultSet.getString("profile_image"));
					return chat;
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * Get the chat group details of group name, group theme and group profile
	 * image.
	 * 
	 * @param chat The chat contains the unque ID of the chat group.
	 * @return It will return chat object.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public Chat getGroupChatDetails(Chat chat) throws DAOException {
		String getGroupDetailQuery = "SELECT group_name, group_image, group_theme FROM chats WHERE chat_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(getGroupDetailQuery)) {
			statement.setInt(1, chat.getChatId());
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					chat.setUsername(resultSet.getString("group_name"));
					chat.setProfileImage(resultSet.getString("group_image"));
					chat.setGroupTheme(resultSet.getString("group_theme"));
					return chat;
				} else {
					return null;
				}
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * This is the function to check whether the user is admin of the chat group or
	 * not.
	 * 
	 * @param userId The user ID is the unique ID of the user.
	 * @param chatId The chat ID is the unique ID of the chat group.
	 * @return It will return true if the user is admin of the chat group. Otherwise
	 *         false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public boolean checkWhetherTheUserIsAdminOrNot(int userId, int chatId) throws DAOException {
		String checkQuery = "SELECT is_admin FROM chat_participants WHERE chat_id = ? AND user_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(checkQuery)) {
			statement.setInt(1, chatId);
			statement.setInt(2, userId);

			try (ResultSet resultSet = statement.executeQuery()) {
				return resultSet.next() && resultSet.getInt("is_admin") == 1;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * This is the function to create a chat group.
	 * 
	 * @param chat The chat contains chat group name, group profile image, chat name
	 *             and chat group theme.
	 * @return It will return true if the chat has been created. Otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public boolean createChatGroup(Chat chat) throws DAOException {
		String insertChatQuery = "INSERT INTO chats (chat_type, chat_name, group_image, group_name, group_theme, is_active) VALUES (?, ?, ?, ?, ?, ?)";
		String getLastChatId = "SELECT LAST_INSERT_ID() AS chat_id";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement chatStatement = connection.prepareStatement(insertChatQuery)) {

			chatStatement.setString(1, "group");
			chatStatement.setString(2, chat.getChatName());
			chatStatement.setString(3, chat.getGroupImage());
			chatStatement.setString(4, chat.getChatName());
			chatStatement.setString(5, chat.getGroupTheme());
			chatStatement.setInt(6, 1);

			int affectedRows = chatStatement.executeUpdate();

			try (ResultSet resultSet = chatStatement.executeQuery(getLastChatId)) {
				if (resultSet.next()) {
					chat.setChatId(resultSet.getInt("chat_id"));
				}
			}
			return (affectedRows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * This is the function to get the get the group image , name and last message
	 * with that time.
	 * 
	 * @param chatId The chatId is the unique ID of the chat group.
	 * @return It will return the chat object with above deatils. Otherwise throw an
	 *         exception.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public Chat getUserGroupConversationGroups(int chatId, int userId) throws DAOException {

		String query = "SELECT c.chat_id, c.group_name, c.group_image, cm.message, cm.sender_id ,cm.timestamp AS last_message_time, 'group' AS chat_type "
				+ "FROM chats c LEFT JOIN chat_messages cm ON c.chat_id = cm.chat_id "
				+ "WHERE c.chat_id = ? AND c.is_active = 1 ORDER BY cm.timestamp DESC LIMIT 1";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, chatId);
			Chat chat = new Chat();
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {

					chat.setChatId(resultSet.getInt("chat_id"));
					chat.setChatName(resultSet.getString("group_name"));
					chat.setGroupImage(resultSet.getString("group_image"));
					chat.setChatMessage(resultSet.getString("message"));
					chat.setTimestamp(resultSet.getTimestamp("last_message_time"));
					chat.setChatType(resultSet.getString("chat_type"));
					//int lastMessageSenderId = resultSet.getInt("sender_id");
					//chat.setUsername(userDAO.readUserFrinedsDetailsByUserId(lastMessageSenderId).getUsername());
					chat.setUnReadMessageCount(getUnReadChatMessageCount(chatId, userId));
				}
				return chat;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * This is the function to get the direct chat group of the user major details
	 * like last message and that time, group name and profile message.
	 * 
	 * @param chatId The chatId is the unique ID of the chat group.
	 * @param userId The userId is the unique ID of the user.
	 * @return It will return the chat object of above details. Otherwise throw an
	 *         exception.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public Chat getUserDirectConversationGroups(int chatId, int userId) throws DAOException {
		String query = "SELECT cp.chat_id, u2.profile_image AS profile_image, u2.username AS username, cm.message, cm.sender_id, cm.message_id ,cm.sender_id AS last_messsage_sender,cm.timestamp AS last_message_time, 'direct' AS chat_type "
				+ "FROM chat_participants cp JOIN users u2 ON cp.user_id != ? AND cp.user_id = u2.user_id "
				+ "LEFT JOIN chat_messages cm ON cp.chat_id = cm.chat_id "
				+ "WHERE cp.chat_id = ? AND cp.is_active = 1 ORDER BY cm.timestamp DESC LIMIT 1;";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			statement.setInt(2, chatId);
			Chat chat = new Chat();

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					chat.setChatId(resultSet.getInt("chat_id"));
					chat.setGroupImage(resultSet.getString("profile_image"));
					chat.setChatName(resultSet.getString("username"));
					chat.setChatMessage(resultSet.getString("message"));
					chat.setTimestamp(resultSet.getTimestamp("last_message_time"));
					chat.setChatType(resultSet.getString("chat_type"));
				//	int lastMessageSenderId = resultSet.getInt("sender_id");

				//	chat.setUsername(userDAO.readUserFrinedsDetailsByUserId(lastMessageSenderId).getUsername());
					chat.setUnReadMessageCount(getUnReadChatMessageCount(chatId, userId));

					if (resultSet.getInt("last_messsage_sender") == userId) {
						chat.setLastMessageSender("user");
						int messageId = resultSet.getInt("message_id");
						chat.setDoesEveryoneReadMessage(checkDoesEveryOneReadMessageOrNOt(chatId, messageId));
					} else {
						chat.setLastMessageSender("others");
					}
				}
				return chat;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * This is the function to get chat group participants details.
	 * 
	 * @param chatId The chatId is the unique ID of the chat group.
	 * @return It will return list of user details. Otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public List<Chat> getChatGroupParticipants(int chatId) throws DAOException {
		List<Chat> participants = new ArrayList<>();
		UserDAO userDAO = new UserDAO();
		String getQuery = "SELECT user_id FROM chat_participants WHERE chat_id = ? AND is_active = 1";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(getQuery)) {
			statement.setInt(1, chatId);

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					int userId = resultSet.getInt("user_id");
					User user = userDAO.readUserFrinedsDetailsByUserId(userId);
					if (user != null) {
						Chat participant = new Chat();
						boolean isAdmin = checkWhetherTheUserIsAdminOrNot(user.getUserId(), chatId);
						participant.setUser(user);
						participant.setAdmin(isAdmin);
						participants.add(participant);
					}
				}
			}
			return participants;
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * This is the function to make the user is read the chat message.
	 * 
	 * @param chat The chat contains the chat group unique and user Id.
	 * @return It will return true if updated. Otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public boolean makeChatMessagesAsRead(List<Chat> chatMessages, int chatId, int userId) throws DAOException {
		String makeIsReadQuery = "INSERT IGNORE INTO chat_message_reads (chat_id, message_id, user_id, is_read) VALUES (?, ?, ?, true);";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(makeIsReadQuery)) {

			for (Chat chatMessage : chatMessages) {
				int messageId = chatMessage.getMessageId();
				if (!isMessageRead(connection, chatId, messageId, userId)) {
					statement.setInt(1, chatId);
					statement.setInt(2, messageId);
					statement.setInt(3, userId);

					statement.executeUpdate();
				}
			}

			return true;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Helper method to check if the message is already marked as read by the user
	private boolean isMessageRead(Connection connection, int chatId, int messageId, int userId) throws SQLException {
		String query = "SELECT 1 FROM chat_message_reads WHERE chat_id = ? AND message_id = ? AND user_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, chatId);
			stmt.setInt(2, messageId);
			stmt.setInt(3, userId);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

	/**
	 * This is the function to give access as an admin to the chat group and remove
	 * access(Vice Versa).
	 * 
	 * @param userId  This userId is the unique ID of the user who is going to get
	 *                an admin access.
	 * @param chatId  The chaId is the unique Id of the chat group.
	 * @param isAdmin The isAdmin only will decide if the user going to get an
	 *                access or get back their access.
	 * @return It will return true if data updated. Otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	public boolean makeUserAsGroupAdmin(int userId, int chatId, boolean isAdmin) throws DAOException {
		String makeUserAdminQuery = "UPDATE chat_participants SET is_admin = ? WHERE chat_id = ? AND user_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(makeUserAdminQuery)) {
			statement.setInt(1, isAdmin ? 1 : 0);
			statement.setInt(2, chatId);
			statement.setInt(3, userId);
			int rowsUpdated = statement.executeUpdate();
			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * This is the function to remvoe the from the chat group.
	 * 
	 * @param userId The userid removing user unique ID.
	 * @param chatId The chatid is the unique ID of the chat group.
	 * @return It will return true if the user has been deleted from the chat group.
	 *         Otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public boolean removeUserFromChatGroup(int userId, int chatId) throws DAOException {

		String deleteUserQueryFromChatGroup = "UPDATE chat_participants SET is_delete = 1 WHERE chat_id = ? AND user_id = ?";
		try (Connection conn = ConnectionUtils.getConnection();
				PreparedStatement stmt = conn.prepareStatement(deleteUserQueryFromChatGroup)) {
			stmt.setInt(1, chatId);
			stmt.setInt(2, userId);
			int rowsUpdated = stmt.executeUpdate();
			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * This is the function to update the chat group profile image.
	 * 
	 * @param groupProfileImage This the updating chat group image.
	 * @param chatId            The chatid is the unique ID of the chat group.
	 * @return It wil return true if the profile image updated. Otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public boolean updateChatGroupProfileImage(String groupProfileImage, int chatId) throws DAOException {
		String updateQuery = "UPDATE chats SET group_image = ? WHERE chat_id = ?";

		try (Connection conn = ConnectionUtils.getConnection();
				PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
			stmt.setString(1, groupProfileImage);
			stmt.setInt(2, chatId);
			int rowsUpdated = stmt.executeUpdate();
			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * This is the function to update chat group details like group name and theme.
	 * 
	 * @param groupName  This is the updating the chat group name.
	 * @param groupTheme This is the updating the group theme.
	 * @param chatId     The chatid is the unique ID of that group.
	 * @return It will return true if the data updated. Otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public boolean updateChatGroupDetails(String groupName, String groupTheme, int chatId) throws DAOException {

		String updateQuery = "UPDATE chats SET group_name = ?, group_theme = ? WHERE chat_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setString(1, groupName);
			statement.setString(2, groupTheme);
			statement.setInt(3, chatId);
			int rowsUpdated = statement.executeUpdate();
			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public int getUnReadChatMessageCount(int chatId, int userId) throws DAOException {
		String selectQuery = "SELECT COUNT(*) FROM chat_messages cm "
				+ "LEFT JOIN chat_message_reads cmr ON cm.message_id = cmr.message_id AND cmr.user_id = ? "
				+ "WHERE cm.chat_id = ? AND cmr.message_id IS NULL;";
		int unReadMessageCount = 0;

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, userId);
			statement.setInt(2, chatId);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					unReadMessageCount = resultSet.getInt(1);
				}
			}

			return unReadMessageCount;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean checkDoesEveryOneReadMessageOrNOt(int chatId, int messageId) throws DAOException {
		List<Integer> participants = getChatParticipants(chatId);
		String selectQuery = "SELECT user_id FROM chat_message_reads WHERE chat_id = ? AND message_id = ? AND is_read = FALSE";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, chatId);
			statement.setInt(2, messageId);

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					int userId = resultSet.getInt("user_id");
					if (participants.contains(userId)) {
						return false;
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return true;
	}

	public List<Integer> getChatParticipants(int chatId) throws DAOException {
		List<Integer> participants = new ArrayList<>();
		String selectQuery = "SELECT user_id FROM chat_participants WHERE chat_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, chatId);

			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					participants.add(resultSet.getInt("user_id"));
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}

		return participants;
	}

}
