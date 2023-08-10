package com.fssa.freshnest.dao;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ChatDAO {
    // Create the chat details
    public boolean insertChat(Chat chat) throws DAOException {
        String insertChatQuery = "INSERT INTO chats (chat_type, chat_name) VALUES (?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertChatQuery)) {
            statement.setString(1, chat.getChatType());
            statement.setInt(2, chat.getChatName());
            int rows = statement.executeUpdate();

            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(e);
        } 
    }

    public boolean insertChatParticipant(Chat chat) throws DAOException {
        String insertParticipantQuery = "INSERT INTO chat_participants (chat_id, user_id) VALUES (?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertParticipantQuery)) {
            statement.setInt(1, chat.getChatId());
            statement.setInt(2, chat.getUserId());
            int rows = statement.executeUpdate();
            return (rows == 1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

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

    // Read chat details
    public boolean getChatsByUserId(Chat chat) throws DAOException {
        String selectChatsQuery = "SELECT cm.message_id, u.username AS sender, cm.message, cm.timestamp "
                + "FROM chat_messages cm " + "JOIN users u ON cm.sender_id = u.user_id " + "WHERE cm.chat_id = ? "
                + "ORDER BY cm.timestamp;";

        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectChatsQuery)) {

            statement.setInt(1, chat.getChatId());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String chatMessage = resultSet.getString("message");
                    int chatId = resultSet.getInt("message_id");
                    System.out.println("chatId is : " + chatId + " correspond message is : " + chatMessage);
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    // Update chat

    public boolean updateChat(Chat chat) throws DAOException {
        String updateQuery = "UPDATE chat_messages SET message = ? WHERE chat_id = ?  AND message_id = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Prepare SQL statement
            statement.setString(1, chat.getChatMessage());
            statement.setInt(2, chat.getChatId());
            statement.setInt(3, chat.getMessageId());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    // Delete chat

    public boolean deleteChat(Chat chat) throws DAOException {
        String updateQuery = "UPDATE chat_messages SET message = ? WHERE chat_id = ? AND message_id = ? ";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
 
            // Prepare SQL statement
            statement.setInt(1, chat.getDelete() ? 1 : 0);
            statement.setInt(2, chat.getChatId());
            statement.setInt(3, chat.getMessageId());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);
        } catch (SQLException e) { 
            throw new DAOException(e);
        }
    }

}
