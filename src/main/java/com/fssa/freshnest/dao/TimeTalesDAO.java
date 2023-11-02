package com.fssa.freshnest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.TimeTales;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.utils.ConnectionUtils;

public class TimeTalesDAO {
	/**
	 * Creates a time tale record in the database.
	 * 
	 * @param timeTales The TimeTales object containing user ID, media URL, and
	 *                  duration.
	 * @return True if the time tale record was successfully created, false
	 *         otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean createTimeTales(TimeTales timeTales) throws DAOException {
		// SQL query to insert a time tale record
		String insertQuery = "INSERT INTO time_tales (user_id, media_url, duration) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, timeTales.getUserId());
			statement.setString(2, timeTales.getMediaUrl());
			statement.setDouble(3, timeTales.getTaleDuration());
			int rows = statement.executeUpdate();
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Reads a specific time tale's details from the database.
	 * 
	 * @param timeTales The TimeTales object containing the tale ID.
	 * @return A TimeTales object representing the time tale details.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public TimeTales readTimeTaleDetail(TimeTales timeTales) throws DAOException {
		// SQL query to retrieve time tale details by tale ID
		String insertQuery = "SELECT * FROM time_tales WHERE tale_id = ?";
		List<TimeTales> timeTaleDetails = new ArrayList<>();
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, timeTales.getTaleId());
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					TimeTales timeTales1 = new TimeTales();
					timeTales1.setTaleId(resultSet.getInt("tale_id"));
					timeTales1.setTaleDuration(resultSet.getDouble("duration"));
					timeTales1.setUsername(resultSet.getString("username"));
					timeTales1.setUserId(resultSet.getInt("user_id"));
					timeTales1.setMediaUrl(resultSet.getString("media_url"));
					timeTales1.setExpireAt(resultSet.getTimestamp("expire_at"));
					timeTales1.setProfileImage(resultSet.getString("profile_image"));
					timeTaleDetails.add(timeTales1);
				}
			}
			return timeTaleDetails.get(0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Lists time tales for a specific user.
	 * 
	 * @param id The user ID for whom time tales are to be listed.
	 * @return A list of TimeTales objects representing the user's time tales.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public List<TimeTales> listUserTimeTales(int id) throws DAOException {
		UserDAO userDAO = new UserDAO();
		List<TimeTales> timeTaleDetails = new ArrayList<>();
		// SQL query to retrieve user's time tales that are not deleted and haven't
		String insertQuery = "SELECT u.user_id, tt.tale_id, tt.media_url, tt.duration, "
				+ "tt.created_at, tt.expires_at  FROM users u LEFT JOIN "
				+ "time_tales tt ON u.user_id = tt.user_id WHERE u.user_id = ? AND tt.is_delete = FALSE "
				+ "AND tt.expires_at >= NOW();";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					TimeTales timeTales1 = new TimeTales();
					int userId = resultSet.getInt("user_id");
					timeTales1.setTaleId(resultSet.getInt("tale_id"));
					timeTales1.setTaleDuration(resultSet.getDouble("duration"));
					timeTales1.setMediaUrl(resultSet.getString("media_url"));
					timeTales1.setExpireAt(resultSet.getTimestamp("expires_at"));
					timeTales1.setCreatedAt(resultSet.getTimestamp("created_at"));
					User user = userDAO.readUserFrinedsDetailsByUserId(userId);
					timeTales1.setUser(user);
					timeTaleDetails.add(timeTales1);
				}
			}
			return timeTaleDetails;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Deletes a time tale from the database using its tale ID.
	 * 
	 * @param taleId The ID of the time tale to be deleted.
	 * @return True if the time tale was successfully deleted, false otherwise.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public boolean deleteTimeTalesByTaleId(int taleId) throws DAOException {
		// SQL query to delete a time tale by tale ID
		String deleteQuery = "UPDATE time_tales SET is_delete = 1 WHERE tale_id = ?;";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
			statement.setInt(1, taleId);
			int rows = statement.executeUpdate();
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	/**
	 * Retrieves time tales of a user's friends that are not deleted and haven't
	 * expired.
	 * 
	 * @param id The user ID for whom friends' time tales are to be retrieved.
	 * @return A list of TimeTales objects representing the time tales of user's
	 *         friends.
	 * @throws DAOException If there's an issue with the database connection or
	 *                      query.
	 */
	public List<TimeTales> getUserFriendsTimeTales(int id) throws DAOException {
		// SQL query to retrieve time tales of a user's friends
		String selectQuery = "SELECT tt.tale_id, tt.user_id, tt.media_url, tt.duration, tt.created_at "
				+ "FROM time_tales tt " + "INNER JOIN users u ON tt.user_id = u.user_id " + "WHERE tt.user_id = ? "
				+ "AND tt.expires_at > CURRENT_TIMESTAMP " + "AND tt.is_delete = false";

		List<TimeTales> timeTalesList = new ArrayList<>();
		UserDAO userDAO = new UserDAO();
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					TimeTales timeTale = new TimeTales();
					timeTale.setTaleId(resultSet.getInt("tale_id"));
					timeTale.setUserId(resultSet.getInt("user_id"));
					timeTale.setMediaUrl(resultSet.getString("media_url"));
					timeTale.setTaleDuration(resultSet.getDouble("duration"));
					timeTale.setCreatedAt(resultSet.getTimestamp("created_at"));
					timeTale.setUser(userDAO.readUserFrinedsDetailsByUserId(id));
					timeTalesList.add(timeTale);
				}
			}
			return timeTalesList;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
