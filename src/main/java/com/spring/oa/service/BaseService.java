package com.spring.oa.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by burning-.- on 2015/6/27.
 */
public interface BaseService<T> {
    void setEntity(Class<?> entityClass);
    void save(T entity);
    void update(T entity);
    T findById(Serializable id);
    void  deleteById(Serializable... ids);
    void deleteAll(Collection<T> entityClass);
    List<T> findByCondition(String whereHql, Object[] params, Map<String, String> orderBy, boolean cacheable);
    List<T> findByCondition(String whereHql, Object[] params, boolean cacheable);
    List<T> findByCondition(Map<String, String> orderBy, boolean cacheable);
    List<T> findAll(boolean cacheable);
    T findFirstByCondition(String whereHql, Object[] params, boolean cacheable);
    List<T> findConditionWithPaging(String whereHQl, Object[] params, Map<String, String> orderBy, int offset, int length);
    int getRowCount(String whereHql, Object[] params);
}
