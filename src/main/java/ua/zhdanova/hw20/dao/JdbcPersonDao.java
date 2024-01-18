package ua.zhdanova.hw20.dao;

import ua.zhdanova.hw20.exception.DataProcessingException;
import ua.zhdanova.hw20.model.Person;
import ua.zhdanova.hw20.util.ConnectionUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements Dao<Person>{

    private static final String SELECT_BY_ID = "SELECT * FROM persons WHERE id = ?";
    private static final String SELECT_ALL = "SELECT * FROM persons";
    private static final String INSERT = "INSERT INTO persons (firstName, lastName, livingAddress) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE persons SET firstName = ?, lastName = ?, livingAddress = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM persons WHERE id = ?";


    @Override
    public Person getById(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID)) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return extractPerson(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't getting person by ID: " + id, e);
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL)) {

            while (resultSet.next()) {
                persons.add(extractPerson(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't getting all persons", e);
        }
        return persons;
    }

    @Override
    public Person add(Person entity) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLivingAddress());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating person failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getLong("id"));
                } else {
                    throw new SQLException("Creating person failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't adding person: " + entity, e);
        }
        return entity;
    }

    @Override
    public void update(Person entity) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {

            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getLivingAddress());
            statement.setLong(4, entity.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't updating person: " + entity, e);
        }
    }

    @Override
    public void delete(Person entity) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {

            statement.setLong(1, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't deleting person: " + entity, e);
        }
    }

    private Person extractPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getLong("id"));
        person.setFirstName(resultSet.getString("firstName"));
        person.setLastName(resultSet.getString("lastName"));
        person.setLivingAddress(resultSet.getString("livingAddress"));
        return person;
    }
}
