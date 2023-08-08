package com.fssa.freshnest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.freshnest.DAO.exceptions.DAOException;

import io.github.cdimascio.dotenv.Dotenv;

public class ChatDAO {
	// Connect to database
	public Connection getConnection() throws SQLException {
		String DB_URL;
		String DB_USER;
		String DB_PASSWORD;

		if (System.getenv("CI") != null) {
			DB_URL = System.getenv("DB_URL");
			DB_USER = System.getenv("DB_USER");
			DB_PASSWORD = System.getenv("DB_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			DB_URL = env.get("DB_URL");
			DB_USER = env.get("DB_USER");
			DB_PASSWORD = env.get("DB_PASSWORD");
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:336/freshnest", "root", "root");
	}

	
	// Create the chat details 
	
	public boolean insertChat(String chatType, String chatName) throws DAOException {
		String insertChatQuery = "INSERT INTO chats (chat_type, chat_name) VALUES (?, ?)";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(insertChatQuery);) {
			statement.setString(1, chatType);
			statement.setString(2, chatName);
			int rows = statement.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean insertChatParticipant(int chatId, int userId) throws DAOException {
		String insertParticipantQuery = "INSERT INTO chat_participants (chat_id, user_id) VALUES (?, ?)";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(insertParticipantQuery)) {
			statement.setInt(1, chatId);
			statement.setInt(2, userId);
			int rows = statement.executeUpdate();
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean insertChatMessage(int chatId, int senderId, String message) throws DAOException {
		String insertMessageQuery = "INSERT INTO chat_messages (chat_id, sender_id, message) VALUES (?, ?, ?)";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(insertMessageQuery)) {
			statement.setInt(1, chatId);
			statement.setInt(2, senderId);
			statement.setString(3, message);
			int rows = statement.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	
	
	// Read the chat details
	
	

//	public boolean createChat(Chat chat) throws DAOException {
//		String insertQuery = "INSERT INTO fresh_chat (chat, chat_time, chat_date, chat_receiver_id, chat_sender_id, is_read, is_delete, is_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//		try (Connection connection = getConnection();
//				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
//
//			statement.setString(1, chat.getChat());
//			statement.setTime(2, Time.valueOf(chat.getChat_time()));
//			statement.setDate(3, Date.valueOf(chat.getChat_date()));
//			statement.setInt(4, chat.getChat_receiverId());
//			statement.setInt(5, chat.getChat_senderId());
//			statement.setInt(6, chat.get_isRead() ? 1 : 0);
//			statement.setInt(7, chat.get_isDelete() ? 1 : 0);
//			statement.setInt(8, chat.get_isUpdate() ? 1 : 0);
//			// Execute the query
//			int rows = statement.executeUpdate();
//
//			// Return successful or not
//			return (rows == 1);
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}
//
//	// Read chat
//
//	public boolean readChat(Chat chat) throws DAOException {
//		String updateQuery = "UPDATE fresh_chat SET chat = ?, chat_time = ?, chat_date = ?, chat_receiver_id = ?, chat_sender_id = ?, is_read = ?, is_delete = ?, is_update  = ? WHERE chat_id = ?";
//		try (Connection connection = getConnection();
//				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
//
//			statement.setString(1, chat.getChat());
//			statement.setTime(2, Time.valueOf(chat.getChat_time()));
//			statement.setDate(3, Date.valueOf(chat.getChat_date()));
//			statement.setInt(4, chat.getChat_receiverId());
//			statement.setInt(5, chat.getChat_senderId());
//			statement.setInt(6, chat.get_isRead() ? 1 : 0);
//			statement.setInt(7, chat.get_isDelete() ? 1 : 0);
//			statement.setInt(8, chat.get_isUpdate() ? 1 : 0);
//			statement.setInt(9, chat.get_chatId());
//
//			// Execute the query
//			int rows = statement.executeUpdate();
//
//			// Return successful or not
//			return (rows == 1);
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}
//
//	// Update chat
//
//	public boolean updateChat(Chat chat) throws DAOException {
//		String updateQuery = "UPDATE fresh_chat SET chat = ?, chat_time = ?, chat_date = ?, chat_receiver_id = ?, chat_sender_id = ?, is_read = ?, is_delete = ?, is_update  = ? WHERE chat_id = ?";
//		try (Connection connection = getConnection();
//				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
//
//			// Prepare SQL statement
//			statement.setString(1, chat.getChat());
//			statement.setTime(2, Time.valueOf(chat.getChat_time()));
//			statement.setDate(3, Date.valueOf(chat.getChat_date()));
//			statement.setInt(4, chat.getChat_receiverId());
//			statement.setInt(5, chat.getChat_senderId());
//			statement.setInt(6, chat.get_isRead() ? 1 : 0);
//			statement.setInt(7, chat.get_isDelete() ? 1 : 0);
//			statement.setInt(8, chat.get_isUpdate() ? 1 : 0);
//			statement.setInt(9, chat.get_chatId());
//
//			// Execute the query
//			int rows = statement.executeUpdate();
//
//			// Return successful or not
//			return (rows == 1);
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}
//
//	// Delete chat
//
//	public boolean deleteChat(Chat chat) throws DAOException {
//		String updateQuery = "UPDATE fresh_chat SET  is_delete = ? WHERE chat_id = ?";
//		try (Connection connection = getConnection();
//				PreparedStatement statement = connection.prepareStatement(updateQuery);) {
//
//			// Prepare SQL statement
//			statement.setInt(1, chat.get_isDelete() ? 1 : 0);
//			statement.setInt(2, chat.get_chatId());
//
//			// Execute the query
//			int rows = statement.executeUpdate();
//
//			// Return successful or not
//			return (rows == 1);
//		} catch (SQLException e) {
//			throw new DAOException(e);
//		}
//	}

}
