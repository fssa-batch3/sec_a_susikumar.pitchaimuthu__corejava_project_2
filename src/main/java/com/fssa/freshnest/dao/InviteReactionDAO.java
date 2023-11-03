package com.fssa.freshnest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.InviteReaction;
import com.fssa.freshnest.utils.ConnectionUtils;

/**
 * 
 * @author SusikumarPitchaimuth
 *
 */
public class InviteReactionDAO {

	/**
	 * Checks if a user has a specific reaction in the invite reaction details.
	 * 
	 * @param inviteReaction The InviteReaction object containing user and invite
	 *                       details.
	 * @param columnName     The name of the column representing the reaction to
	 *                       check.
	 * @return True if the user has the specified reaction, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean checkUserReaction(InviteReaction inviteReaction, String columnName) throws DAOException {
		String inviteReactionGetQuery = "SELECT COUNT(*) AS request_count FROM invite_react_details WHERE user_id = ? AND invite_id = ? AND "
				+ columnName + " = 1";

		return executeQuery(inviteReactionGetQuery, inviteReaction.getUserId(), inviteReaction.getInviteId());
	}

	private boolean executeQuery(String query, int userId, int inviteId) throws DAOException {
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			statement.setInt(2, inviteId);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int requestCount = resultSet.getInt("request_count");
					return (requestCount > 0);
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Checks if the user has sent a request reaction for a specific invite.
	 * 
	 * @param inviteReaction The InviteReaction object containing user and invite
	 *                       details.
	 * @return True if the user has sent a request reaction, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean checkTheUserSendRequestOrNot(InviteReaction inviteReaction) throws DAOException {
		return checkUserReaction(inviteReaction, "is_send_request");
	}

	/**
	 * Checks if the user has sent a reject response for a specific invite.
	 * 
	 * @param inviteReaction The InviteReaction object containing user and invite
	 *                       details.
	 * @return True if the user has sent a reject response, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean checkTheUserSendRejectResponseOrNot(InviteReaction inviteReaction) throws DAOException {
		return checkUserReaction(inviteReaction, "is_reject");
	}

	/**
	 * Changes the status of a specific reaction in the invite reaction details to
	 * false.
	 * 
	 * @param reactId    The ID of the reaction to update.
	 * @param columnName The name of the column representing the reaction to change.
	 * @return True if the reaction status was successfully updated, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean changeReactionStatus(int reactId, String columnName) throws DAOException {
		// SQL query to set the specified reaction column to false
		String updateQuery = "UPDATE invite_react_details SET " + columnName + " = 0 WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setInt(1, reactId);

			int rowsUpdated = statement.executeUpdate();

			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Changes the status of the "send request" reaction to false for a specific
	 * reaction.
	 * 
	 * @param reactId The ID of the reaction to update.
	 * @return True if the "send request" reaction status was successfully updated,
	 *         false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean changeTheInviteSendRequestIntoFalse(int reactId) throws DAOException {
		return changeReactionStatus(reactId, "is_send_request");
	}

	/**
	 * Changes the status of the "reject" reaction to false for a specific reaction.
	 * 
	 * @param reactId The ID of the reaction to update.
	 * @return True if the "reject" reaction status was successfully updated, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean changeTheInviteRejectResponseIntoFalse(int reactId) throws DAOException {
		return changeReactionStatus(reactId, "is_reject");
	}

	/**
	 * Retrieves the user's reaction to a specific invite.
	 * 
	 * @param inviteReaction The InviteReaction object containing user and invite
	 *                       details.
	 * @return An InviteReaction object with the user's reactions and invite
	 *         message, or null if not found.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public InviteReaction getUserInviteReaction(InviteReaction inviteReaction) throws DAOException {
		// SQL query to select the user's reactions and invite message for a specific
		// invite
		String inviteReactionGetQuery = "SELECT * FROM invite_react_details WHERE user_id = ? AND invite_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(inviteReactionGetQuery)) {
			statement.setInt(1, inviteReaction.getUserId());
			statement.setInt(2, inviteReaction.getInviteId());

			InviteReaction inviteReaction1 = new InviteReaction();
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					inviteReaction1.setLike(resultSet.getBoolean("is_like"));
					inviteReaction1.setReject(resultSet.getBoolean("is_reject"));
					inviteReaction1.setSendRequest(resultSet.getBoolean("is_send_request"));
					inviteReaction1.setInviteMessage(resultSet.getString("invite_message"));
				} else {
					return null;
				}
			}
			return inviteReaction1;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Checks if the user's invite reaction is already present in the database.
	 * 
	 * @param inviteReaction The InviteReaction object containing user and invite
	 *                       details.
	 * @return True if the user's reaction is already present, and sets the react
	 *         ID, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean checkWhetherTheUserInviteReactionAlreadyPresentOrNot(InviteReaction inviteReaction)
			throws DAOException {
		// SQL query to check if the user's invite reaction is already present
		String chekcQuery = "SELECT react_id FROM invite_react_details WHERE invite_id = ? AND user_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(chekcQuery)) {
			statement.setInt(1, inviteReaction.getInviteId());
			statement.setInt(2, inviteReaction.getUserId());
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					inviteReaction.setReactId(resultSet.getInt("react_id"));
					return true;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return false;
	}

	/**
	 * Creates a new user invite reaction in the database.
	 * 
	 * @param inviteReaction The InviteReaction object containing user reactions and
	 *                       invite message.
	 * @return True if the reaction was successfully created, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean userInviteReactionCreate(InviteReaction inviteReaction) throws DAOException {
		// SQL query to insert the user's invite reaction
		String insertQuery = "INSERT INTO invite_react_details (invite_id, user_id, is_send_request, is_like, is_reject, invite_message) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			statement.setInt(1, inviteReaction.getInviteId());
			statement.setInt(2, inviteReaction.getUserId());
			statement.setInt(3, inviteReaction.isSendRequest() ? 1 : 0);
			statement.setInt(4, inviteReaction.isLike() ? 1 : 0);
			statement.setInt(5, inviteReaction.isReject() ? 1 : 0);
			statement.setString(6, inviteReaction.getInviteMessage());

			int rowsInserted = statement.executeUpdate();

			return (rowsInserted > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Updates the "like" status of a user's invite reaction using the reaction ID.
	 * 
	 * @param inviteReaction The InviteReaction object containing the new "like"
	 *                       status and reaction ID.
	 * @return True if the "like" status was successfully updated, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean setInviteLikeUsingReactId(InviteReaction inviteReaction) throws DAOException {
		// SQL query to update the "like" status of the invite reaction
		String updateQuery = "UPDATE invite_react_details SET is_like = ? WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setInt(1, inviteReaction.isLike() ? 1 : 0);
			statement.setInt(2, inviteReaction.getReactId());

			int rowsUpdated = statement.executeUpdate();

			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Updates the "send request" status of a user's invite reaction using the
	 * reaction ID.
	 * 
	 * @param inviteReaction The InviteReaction object containing the new "send
	 *                       request" status and reaction ID.
	 * @return True if the "send request" status was successfully updated, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean setUserInviteRequestUsingReactId(InviteReaction inviteReaction) throws DAOException {
		// SQL query to update the "send request" status of the invite reaction
		String updateQuery = "UPDATE invite_react_details SET is_send_request = ? WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setInt(1, inviteReaction.isSendRequest() ? 1 : 0);
			statement.setInt(2, inviteReaction.getReactId());

			int rowsUpdated = statement.executeUpdate();

			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Updates the "reject" status of a user's invite reaction using the reaction
	 * ID.
	 * 
	 * @param inviteReaction The InviteReaction object containing the new "reject"
	 *                       status and reaction ID.
	 * @return True if the "reject" status was successfully updated, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean setUserInviteRejectResponseUsingReactId(InviteReaction inviteReaction) throws DAOException {
		// SQL query to update the "reject" status of the invite reaction
		String updateQuery = "UPDATE invite_react_details SET is_reject = ? WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setInt(1, inviteReaction.isReject() ? 1 : 0);
			statement.setInt(2, inviteReaction.getReactId());

			int rowsUpdated = statement.executeUpdate();

			return (rowsUpdated > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves user's invite reaction details using the reaction ID.
	 * 
	 * @param reactId The ID of the invite reaction to retrieve details for.
	 * @return An InviteReaction object with the reaction details, or an empty
	 *         object if not found.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public InviteReaction getUserUserReactionDetailsByReactId(int reactId) throws DAOException {
		// SQL query to select the user's invite reaction details by reaction ID
		String getQuery = "SELECT * FROM invite_react_details WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(getQuery)) {

			statement.setInt(1, reactId);
			InviteReaction inviteReaction = new InviteReaction();
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					inviteReaction.setReactId(resultSet.getInt("react_id"));
					inviteReaction.setInviteId(resultSet.getInt("invite_id"));
					inviteReaction.setUserId(resultSet.getInt("user_id"));
					inviteReaction.setSendRequest(resultSet.getBoolean("is_send_request"));
					inviteReaction.setLike(resultSet.getBoolean("is_like"));
					inviteReaction.setReject(resultSet.getBoolean("is_reject"));
					inviteReaction.setInviteMessage(resultSet.getString("invite_message"));
				}
			}

			return inviteReaction;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Sends back the invite request response by updating the
	 * invite_request_reaction field using the reaction ID.
	 * 
	 * @param inviteReaction The InviteReaction object containing the invite request
	 *                       reaction and reaction ID.
	 * @return True if the invite request response was successfully updated, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean sendBackTheInviteRequestResponse(InviteReaction inviteReaction) throws DAOException {
		// SQL query to update the invite request reaction
		String updateQuery = "UPDATE invite_react_details SET invite_request_reaction = ? WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setString(1, inviteReaction.getInviteRequsestReaction());
			statement.setInt(2, inviteReaction.getReactId());
			int rows = statement.executeUpdate();

			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
