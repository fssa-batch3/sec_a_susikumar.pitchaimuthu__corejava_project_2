package com.fssa.freshnest.dao;

import com.fssa.freshnest.constants.StillConstants;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.Still;
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
        String insertQuery = "UPDATE fresh_still SET is_delete = ? , deletion_date = ? WHERE still_id = ? AND user_id =?  ";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, still.getIsDelete() ? 1 : 0);
            statement.setDate(2, Date.valueOf(still.getStillDate()));
            statement.setInt(3, still.getStillId());
            statement.setInt(4, still.getUser().getUserId());

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
    public List<Still> listStills(int userId ) throws DAOException {
        String query = "SELECT * FROM fresh_still WHERE user_id = ? AND is_delete = FALSE";
        return fetchStillsByQuery(query, userId);
    }

    /**
     * Read the each and every stills details
     *
     * @param still The still object contains the user object.
     * @return The still object if that is true, Otherwise
     * @throws DAOException throw new DAOException "No stills are found".
     */
    public Still readStillDetails(Still still) throws DAOException {
        String query = "SELECT * FROM fresh_still WHERE still_id = ? AND is_delete = FALSE";
        List<Still> stillList = fetchStillsByQuery(query, still.getStillId());
        return stillList.isEmpty() ? null : stillList.get(0);
    }

    /**
     * List the still between the two dates.
     *
     * @param still The still list contains the user object.
     * @return The still list if that is true, Otherwise
     * @throws DAOException throw new DAOException "No stills are found".
     */

    public List<Still> filterStills(Still still) throws DAOException {
        String query = "SELECT * FROM fresh_still WHERE still_date >= ? AND still_date <= ? AND user_id = ? AND is_delete = FALSE";

        return fetchStillsByQuery(query, Date.valueOf(still.getFormDate()), Date.valueOf(still.getToDate()),
                still.getUser().getUserId());
    }

    /**
     * List the stills by the user's favourite.
     *
     * @param still The still list contains the user object.
     * @return The still list if that is true, Otherwise
     * @throws DAOException throw new DAOException "No stills are found".
     */

    public List<Still> filterStillsByFavourite(Still still) throws DAOException {
        String favouriteQuery = "SELECT * FROM fresh_still WHERE user_id = ? AND is_favourite = ? AND is_delete = FALSE";
        return fetchStillsByQuery(favouriteQuery, still.getUser().getUserId(), 1);
    }

    /**
     * List the still user recently deleted.
     *
     * @param still The still list contains the user object.
     * @return The still list if that is true, Otherwise
     * @throws DAOException throw new DAOException "No stills are found".
     */

    public List<Still> filterStillByRecentlyDeleted(int userId) throws DAOException {
        String recentlyDeletedQuery = "SELECT * FROM fresh_still WHERE user_id = ? AND is_delete = 1 AND deletion_date >= DATE_SUB(CURRENT_DATE(), INTERVAL 15 DAY)";
        return fetchStillsByQuery(recentlyDeletedQuery, userId);
    }

    /**
     * Fetching the sill querys
     *
     * @param query  Contains the execute query.
     * @param params contains the parameter of the queries.
     * @return The list of stills if true, Otherwise
     * @throws DAOException throw new DAOException "No stills are found".
     */

    private List<Still> fetchStillsByQuery(String query, Object... params) throws DAOException {
        List<Still> stillList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            setParameters(statement, params);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Still stillResult = mapResultSetToStill(resultSet);
                    stillList.add(stillResult);
                }
                return stillList;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Set parameter for the statements.
     *
     * @param statement constains the prepared statement of the query.
     * @param params    constains the parameter of the queries.
     * @throws SQLException If there is any error in the prepared statement.
     */

    private void setParameters(PreparedStatement statement, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof Integer integer) {
                statement.setInt(i + 1, integer);
            } else if (params[i] instanceof Date date) {
                statement.setDate(i + 1, date);
            }
        }
    }

    /**
     * Map the value for the result sets.
     *
     * @param resultSet contains the set of results of the executed queries.
     * @return the object if data is present. Otherwise
     * @throws SQLException throw new DAOExcption if there any error occurs while gets the values.
     */

    private Still mapResultSetToStill(ResultSet resultSet) throws SQLException {
        Still stillResult = new Still();
        stillResult.setStillUrl(resultSet.getString("still_url"));
        stillResult.setStillId(resultSet.getInt("still_id"));
        stillResult.setStillName(resultSet.getString("still_name"));
        stillResult.setStillDate(resultSet.getDate("still_date").toLocalDate());
        stillResult.setStillTime(resultSet.getTime("still_time").toLocalTime());
        stillResult.setIsFavourite(resultSet.getBoolean("is_favourite"));
        return stillResult;
    }

    
}
