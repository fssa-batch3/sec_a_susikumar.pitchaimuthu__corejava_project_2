package com.fssa.freshnest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This utility class provides methods for establishing a database connection.
 *
 * @author SusikumarPitchaimuth
 */
public class ConnectionUtils {

	/**
	 * Establishes a connection to the database.
	 *
	 * @return A Connection object representing the database connection.
	 * @throws SQLException If there is an issue with the database connection.
	 */
	// Connect to database
	public static Connection getConnection() {

		final String dbUrl;
		final String dbUser;
		final String dbPassword;

		dbUrl = System.getenv("DB_URL");
		dbUser = System.getenv("DB_USER");
		dbPassword = System.getenv("DB_PASSWORD");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			throw new RuntimeException("Unable to connect database", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Database driver class not found", e);

		}
	}

}
