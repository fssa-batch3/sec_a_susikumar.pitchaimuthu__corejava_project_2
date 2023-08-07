package freshnest.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import freshnest.DAO.exceptions.DAOException;
import freshnest.model.Invite;

public class InviteDAO {
	// Connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freshnest", "root", "root");
		return connection;

	}

	// create invite data

	public boolean createInvite(Invite invite) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();

			// Getting the date and time data

			LocalDate invite_date = LocalDate.parse(invite.getInvite_date());
			LocalTime invite_time = LocalTime.parse(invite.getInvite_time());
			// Prepare SQL statement
			String insertQuery = "INSERT INTO fresh_invite (user_id, invite_type, invite_date, invite_time, special_person, invite_slogan, invite_explanation) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, invite.getUser_id());
			statement.setString(2, invite.getInvite_type());
			statement.setDate(3, Date.valueOf(invite_date));
			statement.setTime(4, Time.valueOf(invite_time));
			statement.setString(5, invite.getSpecial_person());
			statement.setString(6, invite.getInvite_slogan());
			statement.setString(7, invite.getInvite_explanation());
			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public boolean updateInvite(Invite invite) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();

			// Getting the date and time data

			LocalDate invite_date = LocalDate.parse(invite.getInvite_date());
			LocalTime invite_time = LocalTime.parse(invite.getInvite_time());
			// Prepare SQL statement
			String updateQuery = "UPDATE fresh_invite SET user_id = ?, invite_type = ?, invite_date = ?, invite_time = ?, special_person = ?, invite_slogan = ?, invite_explanation = ? WHERE invite_id = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setInt(1, invite.getUser_id());
			statement.setString(2, invite.getInvite_type());
			statement.setDate(3, Date.valueOf(invite_date));
			statement.setTime(4, Time.valueOf(invite_time));
			statement.setString(5, invite.getSpecial_person());
			statement.setString(6, invite.getInvite_slogan());
			statement.setString(7, invite.getInvite_explanation());
			statement.setInt(8, invite.getInvite_id());
			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean deleteInvite(Invite invite) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String updateQuery = "UPDATE fresh_invite SET is_delete = ?  WHERE invite_id = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setInt(1, 1);
			statement.setInt(2, invite.getInvite_id());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean reactInvite(Invite invite) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String updateQuery = "INSERT INTO invite_react_details ( invite_id, reactor_id , is_accept, is_like  , is_dislike, invite_message) VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setInt(1, invite.getInvite_id());
			statement.setInt(2, invite.getReactor_id());
			statement.setInt(3, invite.getIs_accept() ? 1 : 0);
			statement.setInt(4, invite.getIs_like() ? 1 : 0);
			statement.setInt(5, invite.getIs_dislike() ? 1 : 0);
			statement.setString(6, invite.getInvite_message());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
