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

	/**
	 * Checks if a user already exists based on their user ID.
	 * 
	 * @param followRequestSenderId The ID of the user to check.
	 * @return True if the user exists and is not deleted, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean checkUserAlreadyExistsOrNotUsingUserId(int followRequestSenderId) throws DAOException {
		// SQL query to check if the user with the provided user ID exists and is not
		// deleted
		String selectQuery = "SELECT 1 FROM users WHERE user_id = ? AND is_deleted = FALSE LIMIT 1";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			// Set the user ID parameter in the query
			statement.setInt(1, followRequestSenderId);

			try (ResultSet resultSet = statement.executeQuery()) {
				// Return true if a result exists, indicating that the user exists
				return resultSet.next();
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Sends a follow request response by inserting the relationship into the
	 * database.
	 * 
	 * @param requestAndResponse The request and response object containing sender
	 *                           and receiver IDs.
	 * @return True if the follow request response was successfully sent, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean sendFollowRequestResponse(RequestAndResponse requestAndResponse) throws DAOException {
		String insertQuery = "INSERT INTO user_followers (follower_id, following_id) VALUES (?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			// Set the parameters for the query
			statement.setInt(1, requestAndResponse.getRequestSenderId());
			statement.setInt(2, requestAndResponse.getRequestReceiverId());

			int rows = statement.executeUpdate();

			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Checks if a follow request already exists between two users.
	 * 
	 * @param requestAndResponse The request and response object containing sender
	 *                           and receiver IDs.
	 * @return True if a follow request already exists, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean checkTheFollowRequestExistOrNot(RequestAndResponse requestAndResponse) throws DAOException {
		String selectQuery = "SELECT COUNT(*) FROM user_followers WHERE follower_id = ? AND following_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			// Set the parameters for the query
			statement.setInt(1, requestAndResponse.getRequestReceiverId());
			statement.setInt(2, requestAndResponse.getRequestSenderId());

			try (ResultSet resultSet = statement.executeQuery()) {
				// Return true if there's a result and the count is greater than 0
				return resultSet.next() && resultSet.getInt(1) > 0;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Allows a user to unfollow another user by updating the relationship.
	 * 
	 * @param requestAndResponse The request and response object containing sender
	 *                           and receiver IDs.
	 * @return True if the user unfollowed successfully, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean userUnFollow(RequestAndResponse requestAndResponse) throws DAOException {
		String updateQuery = "UPDATE user_followers SET is_active = 0 WHERE follower_id = ? AND following_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			// Set the parameters for the query
			statement.setInt(1, requestAndResponse.getRequestSenderId());
			statement.setInt(2, requestAndResponse.getRequestReceiverId());

			int rowsUpdated = statement.executeUpdate();

			// Return true if one or more rows were updated, indicating success
			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
