package ua.zhdanova.hw20.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String PASSWORD = "Friend888";
    private static final String JDBC_URL_CONNECTION = "jdbc:postgresql://localhost:5432/alevel";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can not load JDBC driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", "postgres");
            dbProperties.put("password", PASSWORD);
            return DriverManager.getConnection(JDBC_URL_CONNECTION, dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB", e);
        }
    }
}
