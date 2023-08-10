package com.fssa.freshnest.dao;

import com.fssa.freshnest.dao.exceptions.DAOException;
import com.fssa.freshnest.model.User;
import com.fssa.freshnest.utils.ConnectionUtils;

import java.sql.*;
import java.time.LocalDate;

public class UserDAO {

	// Get user from DB - Login
	public boolean checkUserLogin(String email, String password) throws DAOException {
		String selectQuery = "SELECT * FROM users WHERE email = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery)) {

			// Set the email parameter
			statement.setString(1, email);

			// Execute the query
			try (ResultSet resultSet = statement.executeQuery()) {
				boolean userExists = resultSet.next();

				if (userExists) {
					System.out.println("User present.");
					String storedPassword = resultSet.getString("password");
					if (storedPassword.equals(password)) {
						System.out.println("User successfully logged in.");
					} else {
						System.out.println("Incorrect password.");
					}
				} else {
					System.out.println("User credentials do not exist.");
				}

				return userExists;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// create user DAO
	public boolean createUser(User user) throws DAOException {
		String insertQuery = "Insert INTO users (email,username, password, firstname, lastname, profile_image) VALUES(?, ?,?, ? , ?, ?)";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertQuery)) {

			statement.setString(1, user.getEmail());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());
			statement.setString(6, user.getProfileImage());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Second page user details adding DAO

	public boolean secondPageUserUpdate(User user) throws DAOException {
		String updateQuery = "UPDATE users SET gender = ?, dob = ? WHERE email = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			LocalDate dob = LocalDate.parse(user.getDob());
			// Prepare SQL statement
			statement.setString(1, user.getGender());
			statement.setDate(2, Date.valueOf(dob));
			statement.setString(3, user.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	// Update user data
	public boolean updateUser(User user) throws DAOException {
		String updateQuery = "UPDATE users SET username = ?, firstname = ?, lastname = ?, gender = ?, password = ?, nationality = ?, dob = ?, age = ?, mobile_number = ? WHERE email = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery)) {

			LocalDate dob = LocalDate.parse(user.getDob());

			// Prepare SQL statement
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getGender());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getNationality());
			statement.setDate(7, Date.valueOf(dob));
			statement.setInt(8, user.getAge());
			statement.setLong(9, user.getMobileNumber());
			statement.setString(10, user.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

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

	// Delete user dao
	public boolean deleteUser(User user) throws DAOException {
		String deleteQuery = "Update users SET is_deleted = TRUE  WHERE email = ?";
		try (Connection connection = ConnectionUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteQuery)) {

			statement.setString(1, user.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows > 0);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
