package com.fssa.freshnest.dao;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides data access methods to interact with the stills database
 * table.
 *
 * @author SusikumarPitchaimuth
 */

public class StillDAO {

    /**
     * Creates a new still record in the database.
     *
     * @param still The Still object containing still information to be created.
     * @return True if the still is successfully created, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
    // add create feature still
    public boolean createStill(Still still) throws DAOException {
        String insertQuery = "INSERT INTO fresh_still ( user_id ,still_url, still_name, still_date, still_time, is_favourite, is_delete ) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Prepare SQL statement
            statement.setInt(1, still.getUser().getUserId());
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

    /**
     * Marks a still as favorite or not in the database.
     *
     * @param still The Still object containing the updated favorite status.
     * @return True if the favorite status is successfully updated, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
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

    /**
     * Updates a still record in the database.
     *
     * @param still The Still object containing updated still information.
     * @return True if the still information is successfully updated, otherwise
     * false.
     * @throws DAOException If there is an issue with the database operation.
     */
    // add Update still feature
    public boolean updateStill(Still still) throws DAOException {
        String insertQuery = "INSERT INTO fresh_still ( user_id ,still_url, still_name, original_still_id, still_date, still_time, is_favourite, is_delete ) VALUES (?, ?, ?,?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            // Prepare SQL statement
            statement.setInt(1, still.getUser().getUserId());
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

    /**
     * Marks a still as deleted or not in the database.
     *
     * @param still The Still object containing the updated delete status.
     * @return True if the delete status is successfully updated, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */

    // add delete still feature
    public boolean deleteStill(Still still) throws DAOException {
        String insertQuery = "UPDATE fresh_still SET is_delete = ? WHERE still_id = ? AND user_id =?  ";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, still.getIsDelete() ? 1 : 0);
            statement.setInt(2, still.getStillId());
            statement.setInt(3, still.getUser().getUserId());

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

    /**
     * Retrieves a list of stills belonging to a specific user from the database.
     *
     * @param still The Still object containing the user ID for which to retrieve
     *              stills.
     * @return A list of Still objects associated with the user.
     * @throws DAOException If there is an issue with the database operation.
     */
    // read still feature by the user id
    public List<Still> readStill(Still still) throws DAOException {
        List<Still> stillList = new ArrayList<>();
        String insertQuery = "SELECT * from fresh_still WHERE user_id = ? AND is_delete = FALSE";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, still.getUser().getUserId());

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Still stillResult = new Still();
                    int userId = resultSet.getInt("user_id");
                    User user = new User();
                    user.setUserId(userId);
                    stillResult.setStillUrl(resultSet.getString("still_url"));
                    stillResult.setStillId(resultSet.getInt("still_id"));
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
