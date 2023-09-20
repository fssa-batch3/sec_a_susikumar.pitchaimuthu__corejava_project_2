package com.fssa.freshnest.dao;

import com.fssa.freshnest.constants.UserConstants;
import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides data access methods to interact with the user database
 * table.
 *
 * @author SusikumarPitchaimuth
 */
public class UserDAO {

    /**
     * Creates a new user record in the database.
     *
     * @param user The User object containing user information.
     * @return True if the user is successfully created, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
    // create user DAO
    public boolean createUser(User user) throws DAOException {
        String insertQuery = "Insert INTO users (email,username, password, firstname, lastname, profile_image, user_theme) VALUES(?, ?,?, ? ,?, ?, ?)";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertQuery)) {

            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getProfileImage());
            statement.setString(7, "Hey! there I'm in the freshnest");

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows == 1);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Updates the gender and date of birth information of a user in the database.
     *
     * @param user The User object containing updated user information.
     * @return True if the user information is successfully updated, otherwise
     * false.
     * @throws DAOException If there is an issue with the database operation.
     */
    // Second page user details adding DAO
    public boolean secondPageUserUpdate(User user) throws DAOException {
        String updateQuery = "UPDATE users SET gender = ?, dob = ? WHERE email = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Prepare SQL statement
            statement.setString(1, user.getGender());
            statement.setDate(2, Date.valueOf(user.getDob()));
            statement.setString(3, user.getEmail());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows > 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Updates the user's information in the database.
     *
     * @param user  The User object containing updated user information.
     * @param email The email of the user whose information is to be updated.
     * @return True if the user information is successfully updated, otherwise
     * false.
     * @throws DAOException If there is an issue with the database operation.
     */
    // Update user data
    public boolean updateUser(User user, User email) throws DAOException {
        String updateQuery = "UPDATE users SET username = ?, firstname = ?, lastname = ?, gender = ?, nationality = ?, dob = ?, mobile_number = ?, user_theme = ?  WHERE email = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

            // Prepare SQL statement
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getGender());
            statement.setString(5, user.getNationality());
            statement.setDate(6, Date.valueOf(user.getDob()));
            statement.setLong(7, user.getMobileNumber());
            statement.setString(8, user.getUserTheme());
            statement.setString(9, email.getEmail());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            if (rows <= 0)
                throw new DAOException(UserConstants.getEmailIdNotExistsMessage());
            else
                return true;

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Updates the user's profile image in the database.
     *
     * @param user The User object containing the updated profile image information.
     * @return True if the profile image is successfully updated, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
    // User profile image update check
    public boolean updateProfileImage(User user) throws DAOException {
        String deleteQuery = "Update users SET profile_image = ?  WHERE user_id = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            // Prepare SQL statement
            statement.setString(1, user.getProfileImage());
            statement.setInt(2, user.getUserId());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            return (rows > 0);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

    }

    /**
     * Marks a user as deleted in the database.
     *
     * @param user The User object containing user information to be deleted.
     * @return True if the user is successfully marked as deleted, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */
    // Delete user dao
    public boolean deleteUser(User user) throws DAOException {
        String deleteQuery = "Update users SET is_deleted = TRUE  WHERE email = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

            statement.setString(1, user.getEmail());

            // Execute the query
            int rows = statement.executeUpdate();

            // Return successful or not
            if (rows <= 0)
                throw new DAOException(UserConstants.getEmailIdNotExistsMessage());
            else
                return true;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * User lists feature in the home page once the user logged in
     *
     * @param user The user object contain the user email id to list the existing
     *             users.
     * @return List of users if the information are valid, otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */

    public List<User> listUser(User user) throws DAOException {
        String selectQuery = "SELECT * FROM users WHERE email != ? AND is_deleted = FALSE";
        return fetchUsers(selectQuery, user.getEmail());
    }

    /**
     * List the user details once the clicked there profile.
     *
     * @param user The user object contain the user email id to list the user
     *             profile details.
     * @return List of user details if the information are valid or email is exist
     * otherwise false.
     * @throws DAOException If there is an issue with the database operation.
     */

    public User readUserDetailsByEmail(String email) throws DAOException {
        String selectQuery = "SELECT * FROM users WHERE email = ? AND is_deleted = FALSE";
        List<User> userList = fetchUsers(selectQuery, email);
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * Show the user details which one user searched.
     *
     * @param user The user object contain the user searched name.
     * @return List the user details If the username is existed in the database,
     * otherwise .
     * @throws DAOException If there is no user object like that.
     */

    public List<User> searchUserName(User user) throws DAOException {
        String selectQuery = "SELECT * FROM users WHERE  username = ? ";
        return fetchUsers(selectQuery, user.getUsername());
    }

    /**
     * @param query     The contains the user request query to execute.
     * @param parameter The parameter contains parameter of the execute query.
     * @return List the user details if the information is valid else.
     * @throws DAOException If there is no user object like that.
     */

    private List<User> fetchUsers(String query, String parameter) throws DAOException {
        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, parameter);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User userResult = createUserFromResultSet(resultSet);
                    userList.add(userResult);
                }
                return userList;
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * @param resultSet containing the result set object.
     * @return It will assign the values to the respective attributes.
     */

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        User userResult = new User();
        userResult.setUsername(resultSet.getString("username"));
        userResult.setProfileImage(resultSet.getString("profile_image"));
        userResult.setUserId(resultSet.getInt("user_id"));
        userResult.setFirstName(resultSet.getString("firstname"));
        userResult.setLastName(resultSet.getString("lastname"));
        userResult.setUserTheme(resultSet.getString("user_theme"));
        userResult.setNationality(resultSet.getString("nationality"));
        userResult.setMobileNumber(resultSet.getLong("mobile_number"));
        userResult.setGender(resultSet.getString("gender"));
        userResult.setEmail(resultSet.getString("email"));
        userResult.setPassword(resultSet.getString("password"));
        if (resultSet.getDate("dob") != null) {
            userResult.setDob(resultSet.getDate("dob").toLocalDate());
        }
        return userResult;
    }

    /**
     * @param email Containing the registered user email.
     * @return True if the user is not exists , otherwise.
     * @throws DAOException If there is any error occur.
     */
    // Check the user is already exists or not
    public boolean checkUserDataExistOrNot(String email) throws DAOException {
        String selectQuery = "SELECT email FROM users WHERE email = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    throw new DAOException("User details already exist");
                } else {
                    return true;
                }
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    /**
     * Read user friend details or read the use choosen object.
     *
     * @param user The user object constains the user id.
     * @return If the user id exists return a object of value, Otherwise
     * @throws DAOException throw new DAOException "No user details found"
     */

    public User readUserFrinedsDetailsByUserId(int userId) throws DAOException {
        List<User> userList = new ArrayList<>();

        String selectQuery = "SELECT * FROM users WHERE  user_id = ?";
        try (Connection connection = ConnectionUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User userResult = createUserFromResultSet(resultSet);
                    userList.add(userResult);
                }
            }
            return userList.get(0); 

        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
