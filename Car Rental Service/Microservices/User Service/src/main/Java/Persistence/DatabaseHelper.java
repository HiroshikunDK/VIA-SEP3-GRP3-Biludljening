package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlite:userservice.db";

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Failed to connect to SQLite database.");
            e.printStackTrace();
            return null;
        }
    }
}
