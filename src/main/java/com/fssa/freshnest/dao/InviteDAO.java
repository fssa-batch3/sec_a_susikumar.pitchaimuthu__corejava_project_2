package com.fssa.freshnest.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshnest.constants.InviteConstants;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.utils.ConnectionUtils;

/**
 * This class provides data access methods to interact with the invite database
 * table.
 *
 * @author SusikumarPitchaimuth
 */
public class InviteDAO {

	/**
	 * Creates a new invite record in the database.
	 *
	 * @param invite The Invite object containing invite information to be created.
	 * @return True if the invite is successfully created, otherwise false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	// create invite data
	public boolean createInvite(Invite invite) throws DAOException {
		String insertQuery = "INSERT INTO fresh_invite (user_id, invite_type, invite_date, invite_time, special_person, invite_slogan, invite_explanation,invite_image) VALUES (?,?,?,?,?,?,?, ?)";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			// Prepare SQL statement
			statement.setInt(1, invite.getUser().getUserId());
			statement.setString(2, invite.getInviteType());
			statement.setDate(3, Date.valueOf(invite.getInviteDate()));
			statement.setTime(4, Time.valueOf(invite.getInviteTime()));
			statement.setString(5, invite.getSpecialPerson());
			statement.setString(6, invite.getInviteSlogan());
			statement.setString(7, invite.getInviteExplanation());
			statement.setString(8, invite.getInviteImage());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	/**
	 * Updates an existing invite record in the database.
	 *
	 * @param invite The Invite object containing updated invite information.
	 * @return True if the invite information is successfully updated, otherwise
	 *         false.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public boolean updateInvite(Invite invite) throws DAOException {
		String updateQuery = "UPDATE fresh_invite SET  invite_type = ?, invite_date = ?, invite_time = ?, special_person = ?, invite_slogan = ?, invite_explanation = ?, invite_image = ? WHERE invite_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			// Prepare SQL statement
			statement.setString(1, invite.getInviteType());
			statement.setDate(2, Date.valueOf(invite.getInviteDate()));
			statement.setTime(3, Time.valueOf(invite.getInviteTime()));
			statement.setString(4, invite.getSpecialPerson());
			statement.setString(5, invite.getInviteSlogan());
			statement.setString(6, invite.getInviteExplanation());
			statement.setString(7, invite.getInviteImage());
			statement.setInt(8, invite.getInviteId());
			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not

			if (rows > 0) {
				return true;
			} else {
				throw new DAOException(InviteConstants.getInvalidInviteUpdateMessage());
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Marks an invite as deleted in the database.
	 *
	 * @param invite The Invite object containing invite information to be deleted.
	 * @return True if the invite is successfully marked as deleted, otherwise
	 *         false.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	public boolean deleteInvite(Invite invite) throws DAOException {

		String updateQuery = "UPDATE fresh_invite SET is_delete = 1 WHERE invite_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			statement.setInt(1, invite.getInviteId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			if (rows > 0) {
				return true;
			} else {
				throw new DAOException(InviteConstants.getInvalidInviteDeleteMessage());
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves a List of stills belonging to a specific user from the database.
	 *
	 * @param invite The invite object containing the user id for which to retrieve
	 *               invitation.
	 * @return A list of invitation objects associated with user.
	 * @throws DAOException If there is an issue with the database operation.
	 */

	public List<Invite> listInvites(int userId) throws DAOException {
		List<Invite> inviteList = new ArrayList<>();
		String insertQuery = "SELECT * FROM fresh_invite WHERE user_id = ? AND is_delete = FALSE";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, userId);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Invite inviteResult = createInviteFromResultSet(resultSet);
					inviteList.add(inviteResult);
				}
				return inviteList;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves a list of non-deleted friend invites excluding the user's own
	 * invites.
	 *
	 * @param invite The Invite object associated with the user.
	 * @return A list of friend invites that are not deleted.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public List<Invite> listFriendsInvite(Invite invite) throws DAOException {
		List<Invite> inviteList = new ArrayList<>();

		String selectQuery = "SELECT * FROM fresh_invite WHERE user_id != ? AND is_delete = FALSE";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, invite.getUser().getUserId());
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Invite inviteResult = createInviteFromResultSet(resultSet);
					inviteList.add(inviteResult);
				}
				return inviteList;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Reads the details of a user invite by its invite ID.
	 *
	 * @param inviteId The ID of the invite to retrieve details for.
	 * @return The Invite object with the specified invite ID, or null if not found.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public Invite readUserInviteDetailsByInviteId(int inviteId) throws DAOException {
		String selectQuery = "SELECT * FROM fresh_invite WHERE invite_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, inviteId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return createInviteFromResultSet(resultSet);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Creates an Invite object from the ResultSet obtained from a query.
	 *
	 * @param resultSet The ResultSet containing invite details.
	 * @return The constructed Invite object.
	 * @throws SQLException If there's an issue with ResultSet data retrieval.
	 */
	private Invite createInviteFromResultSet(ResultSet resultSet) throws SQLException {
		Invite inviteResult = new Invite();
		inviteResult.setInviteId(resultSet.getInt("invite_id"));
		inviteResult.setInviteType(resultSet.getString("invite_type"));
		inviteResult.setInviteDate(resultSet.getDate("invite_date").toLocalDate());
		inviteResult.setInviteTime(resultSet.getTime("invite_time").toLocalTime());
		inviteResult.setInviteSlogan(resultSet.getString("invite_slogan"));
		inviteResult.setInviteExplanation(resultSet.getString("invite_explanation"));
		inviteResult.setInviteImage(resultSet.getString("invite_image"));
		inviteResult.setSpecialPerson(resultSet.getString("special_person"));
		return inviteResult;
	}

	/**
	 * Retrieves details about the user who created a specific invite.
	 *
	 * @param inviteId The ID of the invite for which to retrieve the creator's
	 *                 details.
	 * @return The User object representing the creator of the invite, or null if
	 *         not found.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public User getInviteCreatorUserDetails(int inviteId) throws DAOException {
		UserDAO userDAO = new UserDAO();
		String selectQuery = "SELECT u.profile_image, u.user_id, u.username, u.user_theme " + "FROM fresh_invite f "
				+ "JOIN users u ON f.user_id = u.user_id " + "WHERE f.invite_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, inviteId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int userId = resultSet.getInt("user_id");
					return userDAO.readUserFrinedsDetailsByUserId(userId);
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
