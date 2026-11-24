package com.university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class handles the connection to the database
public class DatabaseUtil {

    // Database connection URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/university_db";

    // MySQL username
    private static final String USER = "root";

    // Change this to your actual MySQL password
     private static final String PASSWORD = "root";

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {

        // DriverManager connects using the URL, USER, and PASSWORD
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
