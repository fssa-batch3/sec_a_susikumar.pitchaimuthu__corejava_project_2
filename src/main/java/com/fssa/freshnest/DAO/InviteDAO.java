package com.fssa.freshnest.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fssa.freshnest.DAO.exceptions.DAOException;
import com.fssa.freshnest.model.Invite;
import com.fssa.freshnest.utils.ConnectionUtils;

public class InviteDAO {

	// create invite data

	public boolean createInvite(Invite invite) throws DAOException {
		String insertQuery = "INSERT INTO fresh_invite (user_id, invite_type, invite_date, invite_time, special_person, invite_slogan, invite_explanation) VALUES (?,?,?,?,?,?,?)";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {

			LocalDate invite_date = LocalDate.parse(invite.getInviteDate());
			LocalTime invite_time = LocalTime.parse(invite.getInviteTime());
			// Prepare SQL statement
			statement.setInt(1, invite.getUserId());
			statement.setString(2, invite.getInviteType());
			statement.setDate(3, Date.valueOf(invite_date));
			statement.setTime(4, Time.valueOf(invite_time));
			statement.setString(5, invite.getSpecialPerson());
			statement.setString(6, invite.getInviteSlogan());
			statement.setString(7, invite.getInviteExplanation());
			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public boolean updateInvite(Invite invite) throws DAOException {
		String updateQuery = "UPDATE fresh_invite SET user_id = ?, invite_type = ?, invite_date = ?, invite_time = ?, special_person = ?, invite_slogan = ?, invite_explanation = ? WHERE invite_id = ?";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {

			LocalDate invite_date = LocalDate.parse(invite.getInviteDate());
			LocalTime invite_time = LocalTime.parse(invite.getInviteTime());
			// Prepare SQL statement
			statement.setInt(1, invite.getUserId());
			statement.setString(2, invite.getInviteType());
			statement.setDate(3, Date.valueOf(invite_date));
			statement.setTime(4, Time.valueOf(invite_time));
			statement.setString(5, invite.getSpecialPerson());
			statement.setString(6, invite.getInviteSlogan());
			statement.setString(7, invite.getInviteExplanation());
			statement.setInt(8, invite.getInviteId());
			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean deleteInvite(Invite invite) throws DAOException {

		String updateQuery = "UPDATE fresh_invite SET is_delete = ?  WHERE invite_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {

			statement.setInt(1, 1);
			statement.setInt(2, invite.getInviteId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean reactInvite(Invite invite) throws DAOException {
		String updateQuery = "INSERT INTO invite_react_details ( invite_id, reactor_id , is_accept, is_like  , is_dislike, invite_message) VALUES (?,?,?,?,?,?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {

			statement.setInt(1, invite.getInviteId());
			statement.setInt(2, invite.getReactorId());
			statement.setInt(3, invite.getIsAccept() ? 1 : 0);
			statement.setInt(4, invite.getIsLike() ? 1 : 0);
			statement.setInt(5, invite.getIsDislike() ? 1 : 0);
			statement.setString(6, invite.getInviteMessage());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
