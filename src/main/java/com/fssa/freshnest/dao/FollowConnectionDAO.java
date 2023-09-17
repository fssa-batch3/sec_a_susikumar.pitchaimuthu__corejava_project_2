package com.fssa.freshnest.dao;


import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This is the class to make the user follow connections.
 *
 * @author SusikumarPitchaimuth
 */
public class FollowConnectionDAO {

    public boolean checkUserAlreadyExistsOrNotUsingUserId(int followRequestSenderId) throws DAOException {
        String selectQuery = "SELECT 1 FROM users WHERE user_id = ? AND is_deleted = FALSE LIMIT 1";

        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            System.out.println(followRequestSenderId);
            statement.setInt(1, followRequestSenderId);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public boolean sendFollowRequestResponse(RequestAndResponse requestAndResponse) throws DAOException {
        String insertQuery = "INSERT INTO user_followers (follower_id , following_id) VALUES (?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, requestAndResponse.getRequestSenderId());
            statement.setInt(2, requestAndResponse.getRequestReceiverId());


            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    public boolean checkTheFollowRequestExistOrNot(RequestAndResponse requestAndResponse) throws DAOException {
        String selectQuery = "SELECT COUNT(*) FROM user_followers WHERE follower_id = ? AND following_id = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {

            statement.setInt(1, requestAndResponse.getRequestReceiverId());
            statement.setInt(2, requestAndResponse.getRequestSenderId());

            // Execute the query and obtain the result set
            try (ResultSet resultSet = statement.executeQuery()) {
                // Check if a record with the given follower_id and following_id exists
                System.out.println("request present");
                return resultSet.next() && resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


}

