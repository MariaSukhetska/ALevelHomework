package ua.zhdanova.hw20.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {
    T getById(Long id) throws SQLException;

    List<T> getAll();

    T add(T entity);

    void update(T entity);

    void delete(T entity);
}
