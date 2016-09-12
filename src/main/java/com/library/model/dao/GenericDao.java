package com.library.model.dao;

import java.util.List;

/**
 * Generic interface for DAO pattern.
 *
 * @author Andrii Shchavinskyi
 *
 * @param <T> entity
 */
public interface GenericDao<T> {

    void save(T t);

    void update(T t);

    T findById(int id);

    void deleteById(int id);

    void delete(T t);

    List<T> findAll();


}
