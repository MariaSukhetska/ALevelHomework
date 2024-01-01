package ua.zhdanova.hw17;

import java.sql.*;

public class DatabaseOperations {
    private static final String URL = "jdbc:postgresql://localhost:5432/alevel";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Friend888";

    public static void main(String[] args) {
        createEmployees();
        getAllEmployees();
    }

    private static void createEmployees() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO employee (first_name, last_name, contact_id) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                preparedStatement.setString(1, "Daria");
                preparedStatement.setString(2, "Dudka");
                preparedStatement.setInt(3, 1);
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Anna");
                preparedStatement.setString(2, "Hulita");
                preparedStatement.setInt(3, 2);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't create an employee" + e);
        }
    }

    private static void getAllEmployees() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM employee";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(selectQuery)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    int contactId = resultSet.getInt("contact_id");

                    System.out.println("ID: " + id + ", Name: " + firstName
                            + ", Last_name: " + lastName + ", Contact_ID: " + contactId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all employees" + e);
        }
    }
}
