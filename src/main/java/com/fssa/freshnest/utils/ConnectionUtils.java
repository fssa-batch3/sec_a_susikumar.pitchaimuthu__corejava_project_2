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
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/freshnest", "root", "root");
    }

}
