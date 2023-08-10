package com.fssa.freshnest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	// Connect to database
	public static Connection getConnection() throws SQLException {
//        String DB_URL;
//        String DB_USER;
//        String DB_PASSWORD;
//
//        if (System.getenv("CI") != null) {
//            DB_URL = System.getenv("DB_URL");
//            DB_USER = System.getenv("DB_USER");
//            DB_PASSWORD = System.getenv("DB_PASSWORD");
//        } else {
//            Dotenv env = Dotenv.load();
//            DB_URL = env.get("DB_URL");
//            DB_USER = env.get("DB_USER");
//            DB_PASSWORD = env.get("DB_PASSWORD");
//        }
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/freshnest", "root", "root");
	}

}
