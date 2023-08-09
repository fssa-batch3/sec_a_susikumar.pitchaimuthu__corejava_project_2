package com.fssa.freshnest.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import com.fssa.freshnest.DAO.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.utils.ConnectionUtils;

public class StillDAO {


	public boolean createStill(Still still) throws DAOException {
		String insertQuery = "INSERT INTO fresh_still ( user_id ,still_url, still_name, still_date, still_time, is_favourite, is_delete ) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			// Get connection

			// Prepare SQL statement
			statement.setInt(1, still.getUserId());
			statement.setString(2, still.getStillUrl());
			statement.setString(3, still.getStillName());
			statement.setDate(4, Date.valueOf(still.getStillDate()));
			statement.setTime(5, Time.valueOf(still.getStillTime()));
			statement.setInt(6, still.getIsFavourite() ? 1 : 0);
			statement.setInt(7, still.getIsDelete() ? 1 : 0);

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// add favourite feature

	public boolean FavouriteStill(Still still) throws DAOException {
		String insertQuery = "UPDATE fresh_still SET is_favourite = ? WHERE still_id = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setInt(1, still.getIsFavourite() ? 1 : 0);
			statement.setInt(2, still.getStillId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// add Update still

	public boolean UpdateStill(Still still) throws DAOException {
		String insertQuery = "UPDATE fresh_still SET is_update = ? WHERE still_id = ? ";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setInt(1, still.getIsUpdate() ? 1 : 0);
			statement.setInt(2, still.getStillId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean DeleteStill(Still still) throws DAOException {
		String insertQuery = "UPDATE fresh_still SET is_delete = ? WHERE still_id = ? AND user_id =?  ";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setInt(1, still.getIsDelete() ? 1 : 0);
			statement.setInt(2, still.getStillId());
			statement.setInt(3, still.getUserId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean readStill(Still still) throws DAOException {
		String insertQuery = "SELECT image_url from fresh_still WHERE user_id = ? ";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery);) {
			statement.setInt(1, still.getUserId());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

}
