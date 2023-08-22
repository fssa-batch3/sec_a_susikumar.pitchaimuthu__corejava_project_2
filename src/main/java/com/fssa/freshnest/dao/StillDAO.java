package com.fssa.freshnest.dao;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StillDAO {

    // add create feature still
    public boolean createStill(Still still) throws DAOException {
        String insertQuery = "INSERT INTO fresh_still ( user_id ,still_url, still_name, still_date, still_time, is_favourite, is_delete ) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

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

    // add favourite feature still
    public boolean favouriteStill(Still still) throws DAOException {
        String insertQuery = "UPDATE fresh_still SET is_favourite = ? WHERE still_id = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
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

    // add Update still feature
    public boolean updateStill(Still still) throws DAOException {
        String insertQuery = "INSERT INTO fresh_still ( user_id ,still_url, still_name, original_still_id, still_date, still_time, is_favourite, is_delete ) VALUES (?, ?, ?,?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Prepare SQL statement
            statement.setInt(1, still.getUserId());
            statement.setString(2, still.getStillUrl());
            statement.setString(3, still.getStillName());
            statement.setInt(4, still.getStillId());
            statement.setDate(5, Date.valueOf(still.getStillDate()));
            statement.setTime(6, Time.valueOf(still.getStillTime()));
            statement.setInt(7, still.getIsFavourite() ? 1 : 0);
            statement.setInt(8, still.getIsDelete() ? 1 : 0);

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    // add delete still feature
    public boolean deleteStill(Still still) throws DAOException {
        String insertQuery = "UPDATE fresh_still SET is_delete = ? WHERE still_id = ? AND user_id =?  ";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, still.getIsDelete() ? 1 : 0);
            statement.setInt(2, still.getStillId());
            statement.setInt(3, still.getUserId());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            if (rows <= 0)
                throw new DAOException(StillConstants.getInvalidStillIdMessage());
            else
                return true;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    // read still feature by the user id
    public List<Still> readStill(Still still) throws DAOException {
        List<Still> stillList = new ArrayList<>();
        String insertQuery = "SELECT * from fresh_still WHERE user_id = ? AND is_delete = FALSE";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)
        ) {
            statement.setInt(1, still.getUserId());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Still stillResult = new Still();
                    stillResult.setStillUrl(resultSet.getString("still_url"));
                    stillResult.setStillId(resultSet.getInt("still_id"));
                    stillResult.setUserId(resultSet.getInt("user_id"));
                    stillResult.setStillName(resultSet.getString("still_name"));
                    stillResult.setStillDate(resultSet.getDate("still_date").toLocalDate());
                    stillResult.setStillTime(resultSet.getTime("still_time").toLocalTime());
                    stillResult.setIsFavourite(resultSet.getBoolean("is_favourite"));
                    stillList.add(stillResult);
                }
                return stillList;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

}
