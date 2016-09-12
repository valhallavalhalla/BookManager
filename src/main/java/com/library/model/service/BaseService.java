package com.library.model.service;

import java.util.List;

/**
 * Basic service layer interface.
 *
 * @author Andrii Shchavinskyi
 *
 * @param <T> entity of service
 */
public interface BaseService<T> {

    boolean add(T t);
    boolean edit(T t);
    void deleteById(int id);
    T getById(int id);
    List<T> getAll();

}
