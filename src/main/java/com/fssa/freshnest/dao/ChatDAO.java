package com.fssa.freshnest.dao;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Chat;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides data access methods to interact with the chat-related database tables.
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
        String insertChatQuery = "INSERT INTO chats (chat_type, chat_name) VALUES (?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertChatQuery)) {
            statement.setString(1, chat.getChatType());
            statement.setString(2, chat.getChatName());
            int rows = statement.executeUpdate();

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
                statement.addBatch();  // Add the statement to the batch
            }

            int[] rows = statement.executeBatch();  // Execute the batch
            return Arrays.stream(rows).allMatch(row -> row == 1);

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Inserts a new chat message record into the database.
     *
     * @param chat The Chat object containing chat message information to be created.
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
     * @param chat The Chat object containing chat ID for which to retrieve messages.
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

    /**
     * Deletes a chat message in the database.
     *
     * @param chat The Chat object containing information about the message to be deleted.
     * @return True if the chat message is successfully marked as deleted, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
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
