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
	public boolean createTimeTales(TimeTales timeTales) throws DAOException {
		String insertQuery = "INSERT INTO time_tales (user_id, media_url, duration) VALUES (?, ?,?)";

		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, timeTales.getUserId());
			statement.setString(2, timeTales.getMedia_url());
			statement.setDouble(3, timeTales.getTaleDuration());

			int rows = statement.executeUpdate();
			return (rows > 0);

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public TimeTales readTimeTaleDetail(TimeTales timeTales) throws DAOException {
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
					timeTales1.setMedia_url(resultSet.getString("media_url"));
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

	public List<TimeTales> listUserTimeTales(TimeTales timeTales) throws DAOException {
		UserDAO userDAO = new UserDAO();
		String insertQuery = "SELECT " + "u.user_id, " + "u.username, " + "u.profile_image, " + "tt.tale_id, "
				+ "tt.media_url, " + "tt.duration, " + "tt.created_at, " + "tt.expires_at " + "FROM " + "users u "
				+ "LEFT JOIN " + "time_tales tt ON u.user_id = tt.user_id " + "WHERE " + "u.user_id = ? "
				+ "AND tt.is_delete = FALSE " + "AND tt.expires_at >= NOW();";

		List<TimeTales> timeTaleDetails = new ArrayList<>();
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			statement.setInt(1, timeTales.getUserId());
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					TimeTales timeTales1 = new TimeTales();
					int userId = resultSet.getInt("user_id");
					timeTales1.setTaleId(resultSet.getInt("tale_id"));
					timeTales1.setTaleDuration(resultSet.getDouble("duration"));
					timeTales1.setMedia_url(resultSet.getString("media_url"));
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
}
