package org.example.repository;

import java.util.List;

public interface GenericRepository<T> {
    T findById(Long id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(Long id);
}
