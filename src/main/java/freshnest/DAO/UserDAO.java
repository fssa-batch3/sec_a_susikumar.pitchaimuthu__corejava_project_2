package freshnest.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import freshnest.DAO.exceptions.DAOException;
import freshnest.model.User;

public class UserDAO {

	// Connect to database
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/freshnest", "root", "root");
		return connection;

	}

	// Get user from DB - Login
	public boolean checkUserLogin(String email, String password) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			String selectQuery = "SELECT * FROM user WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(selectQuery);
			statement.setString(1, email);

			// Execute the query
			ResultSet resultSet = statement.executeQuery();

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
				System.out.println("User credentials not exists.");
			}

			resultSet.close();
			statement.close();
			connection.close();

			return userExists;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean createUser(User user) throws DAOException {

		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String insertQuery = "Insert INTO user (email,username, password, firstname, lastname) VALUES(?, ?,?, ? , ?)";
			PreparedStatement statement = connection.prepareStatement(insertQuery);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getFirstName());
			statement.setString(5, user.getLastName());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean updateUser(User user) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String updateQuery = "UPDATE user SET username = ?, firstname = ?, lastname = ?, gender = ?, password = ?, nationality = ?, dob = ?, profile_image = ?, age = ?, mobile_number = ? WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getFirstName());
			statement.setString(3, user.getLastName());
			statement.setString(4, user.getGender());
			statement.setString(5, user.getPassword());
			statement.setString(6, user.getNationality());
			statement.setDate(7, user.getDob());
			statement.setString(8, user.getProfile_image());
			statement.setInt(9, user.getAge());
			statement.setLong(10, user.getMobile_number());
			statement.setString(11, user.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public boolean deleteUser(User user) throws DAOException {
		try {
			// Get connection
			Connection connection = getConnection();

			// Prepare SQL statement
			String deleteQuery = "Update user SET is_deleted = ?  WHERE email = ?";
			PreparedStatement statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, user.getIs_delete()? 1: 0);
			statement.setString(2, user.getEmail());

			// Execute the query
			int rows = statement.executeUpdate();

			// Return successful or not
			return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

}
