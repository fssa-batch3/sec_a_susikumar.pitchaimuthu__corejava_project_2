package com.fssa.freshnest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.InviteReaction;
import com.fssa.freshnest.utils.ConnectionUtils;

public class InviteReactionDAO {

	public boolean checkUserReaction(InviteReaction inviteReaction, String columnName) throws DAOException {
		String inviteReactionGetQuery = "SELECT COUNT(*) AS request_count FROM invite_react_details WHERE user_id = ? AND invite_id = ? AND "
				+ columnName + " = 1";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(inviteReactionGetQuery)) {
			statement.setInt(1, inviteReaction.getUserId());
			statement.setInt(2, inviteReaction.getInviteId());

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int requestCount = resultSet.getInt("request_count");
					return requestCount > 0;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean checkTheUserSendRequestOrNot(InviteReaction inviteReaction) throws DAOException {
		return checkUserReaction(inviteReaction, "is_send_request");
	}

	public boolean checkTheUserSendRejectResponseOrNot(InviteReaction inviteReaction) throws DAOException {
		return checkUserReaction(inviteReaction, "is_reject");
	}

	public boolean changeReactionStatus(int reactId, String columnName) throws DAOException {
		String updateQuery = "UPDATE invite_react_details SET " + columnName + " = 0 WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setInt(1, reactId);

			int rowsUpdated = statement.executeUpdate();

			// Check if the update was successful
			return rowsUpdated > 0;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean changeTheInviteSendRequestIntoFalse(int reactId) throws DAOException {
		return changeReactionStatus(reactId, "is_send_request");
	}

	public boolean changeTheInviteRejectResponseIntoFalse(int reactId) throws DAOException {
		return changeReactionStatus(reactId, "is_reject");
	}

	public InviteReaction getUserInviteReaction(InviteReaction inviteReaction) throws DAOException {
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
				}
			}
			return inviteReaction1;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean checkWhetherTheUserInviteReactionAlreadyPresentOrNot(InviteReaction inviteReaction)
			throws DAOException {
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

	public boolean userInviteReactionCreate(InviteReaction inviteReaction) throws DAOException {
		String insertQuery = "INSERT INTO invite_react_details (invite_id, user_id, is_send_request, is_like, is_reject, invite_message) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			// Set values for the INSERT statement
			statement.setInt(1, inviteReaction.getInviteId());
			statement.setInt(2, inviteReaction.getUserId());
			statement.setInt(3, inviteReaction.isSendRequest() ? 1 : 0);
			statement.setInt(4, inviteReaction.isLike() ? 1 : 0);
			statement.setInt(5, inviteReaction.isReject() ? 1 : 0);
			statement.setString(6, inviteReaction.getInviteMessage());

			// Execute the INSERT statement
			int rowsInserted = statement.executeUpdate();

			// Check if a row was successfully inserted
			return (rowsInserted > 0);

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public boolean setInviteLikeUsingReactId(InviteReaction inviteReaction) throws DAOException {
		String updateQuery = "UPDATE invite_react_details SET is_like = ? WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			// Set values for the UPDATE statement
			statement.setInt(1, inviteReaction.isLike() ? 1 : 0);
			statement.setInt(2, inviteReaction.getReactId());

			// Execute the UPDATE statement
			int rowsUpdated = statement.executeUpdate();

			// Check if a row was successfully updated
			return (rowsUpdated > 0);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean setUserInviteRequestUsingReactId(InviteReaction inviteReaction) throws DAOException {
		String updateQuery = "UPDATE invite_react_details SET is_send_request = ? WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			// Set values for the UPDATE statement
			statement.setInt(1, inviteReaction.isSendRequest() ? 1 : 0);
			statement.setInt(2, inviteReaction.getReactId());

			// Execute the UPDATE statement
			int rowsUpdated = statement.executeUpdate();

			// Check if a row was successfully updated
			return (rowsUpdated > 0);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean setUserInviteRejectResponseUsingReactId(InviteReaction inviteReaction) throws DAOException {
		String updateQuery = "UPDATE invite_react_details SET is_reject = ? WHERE react_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			// Set values for the UPDATE statement
			statement.setInt(1, inviteReaction.isReject() ? 1 : 0);
			statement.setInt(2, inviteReaction.getReactId());

			// Execute the UPDATE statement
			int rowsUpdated = statement.executeUpdate();

			// Check if a row was successfully updated
			return (rowsUpdated > 0);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
