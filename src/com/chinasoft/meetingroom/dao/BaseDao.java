package com.chinasoft.meetingroom.dao;

import java.io.Serializable;
import java.util.IdentityHashMap;
import java.util.List;

/**
 * Created by wei on 15/5/29.
 */
public interface BaseDao<T> {
    T get(Class<T> entityclazz, Serializable id);
    Serializable save(T entity);
    void update(T entity);
    void delete(T entity);
    void delete(Class<T> entityClazz, Serializable Id);
    List<T> findall(Class<T> entityClazz);

}
