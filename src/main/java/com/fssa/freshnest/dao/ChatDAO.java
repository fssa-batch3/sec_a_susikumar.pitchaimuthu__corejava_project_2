package com.fssa.freshnest.dao;

import com.fssa.freshnest.constants.ChatConstants;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	// Create the chat details
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
			return Arrays.stream(rows).allMatch(row -> row == 1);

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

			System.out.println("emoji :" + chat.getChatMessage());
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

			// Prepare SQL statement
			statement.setString(1, chat.getChatMessage());
			statement.setInt(2, chat.getMessageId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not

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

			// Prepare SQL statement
			System.out.println(chat.getMessageId());
			statement.setInt(1, chat.getMessageId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Get user chat groups

	public List<Chat> getUserChatGroups(int userId) throws DAOException {

		List<Chat> userChatGroups = new ArrayList<>();
		String getQuery = "SELECT c.chat_id, c.chat_type" + " FROM chats c "
				+ "JOIN chat_participants cp ON c.chat_id = cp.chat_id" + " WHERE cp.user_id = ? AND is_active = 0";
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

		}

		catch (SQLException e) {
			throw new DAOException(e);
		}

	}

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
				}
			}

			return chat;
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public Chat getGroupChatDetails(Chat chat) throws DAOException {
		String getGroupDetailQuery = "SELECT group_name, group_image FROM chats WHERE chat_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(getGroupDetailQuery)) {
			statement.setInt(1, chat.getChatId());

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					chat.setUsername(resultSet.getString("group_name"));
					chat.setProfileImage(resultSet.getString("group_image"));
				}
			}

			return chat;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

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
			chatStatement.setInt(6, 0);

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

	public Chat getGroupConversationDetails(int chatId) throws DAOException {

		String query = "SELECT c.chat_id, c.group_name, c.group_image, cm.message, cm.timestamp AS last_message_time, 'group' AS chat_type "
				+ "FROM chats c " + "LEFT JOIN chat_messages cm ON c.chat_id = cm.chat_id " + "WHERE c.chat_id = ? "
				+ "ORDER BY cm.timestamp DESC " + "LIMIT 1";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, chatId);
			Chat chat = new Chat();
			System.out.println("I am enter");
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {

					System.out.println("group message");
					chat.setChatId(resultSet.getInt("chat_id"));
					chat.setChatName(resultSet.getString("group_name"));
					chat.setGroupImage(resultSet.getString("group_image"));
					chat.setChatMessage(resultSet.getString("message"));
					chat.setTimestamp(resultSet.getTimestamp("last_message_time"));
					chat.setChatType(resultSet.getString("chat_type"));
				}
				return chat;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	public Chat getDirectConversationDetails(int chatId) throws DAOException {
		String query = "SELECT" + "    cp.chat_id," + "    u2.profile_image AS profile_image,"
				+ "    u2.username AS username," + "    cm.message," + "    cm.timestamp AS last_message_time,"
				+ "    'direct' AS chat_type " + "FROM " + "    chat_participants cp " + "JOIN "
				+ "    users u2 ON cp.user_id != ? AND cp.user_id = u2.user_id " + "LEFT JOIN "
				+ "    chat_messages cm ON cp.chat_id = cm.chat_id " + "WHERE " + "    cp.chat_id = ? " + "ORDER BY "
				+ "    cm.timestamp DESC " + "LIMIT 1;";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, chatId);
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
				}
				return chat;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

}
