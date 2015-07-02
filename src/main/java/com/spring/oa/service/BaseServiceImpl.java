package com.spring.oa.service;

import com.spring.oa.dao.BaseDao;
import com.spring.oa.util.GenericClass;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by burning-.- on 2015/6/27.
 */
public class BaseServiceImpl<T> implements BaseService<T> {
    private BaseDao<T> baseDao;
    private Class<?> entityClazz= GenericClass.getGenericClass(this.getClass());

    public void setEntity(Class<?> entityClass) {
       this.entityClazz=entityClass;
    }
    public void setBaseDao(BaseDao<T> baseDao){
        this.baseDao=baseDao;
    }

    public void save(T entity) {
        baseDao.save(entity);
    }

    public void update(T entity) {
        baseDao.update(entity);
    }

    public T findById(Serializable id) {
        return baseDao.findById(id);
    }

    public void deleteById(Serializable... ids) {
        baseDao.deleteById(ids);
    }

    public void deleteAll(Collection<T> entityClass) {
        baseDao.deleteAll(entityClass);
    }

    public List<T> findByCondition(String whereHql, Object[] params, Map<String, String> orderBy, boolean cacheable) {
        return baseDao.findByCondition(whereHql,params,orderBy,cacheable);
    }

    public List<T> findByCondition(String whereHql, Object[] params, boolean cacheable) {
        return baseDao.findByCondition(whereHql,params,cacheable);
    }

    public List<T> findByCondition(Map<String, String> orderBy, boolean cacheable) {
        return baseDao.findByCondition(orderBy,cacheable);
    }

    public List<T> findAll(boolean cacheable) {
        return baseDao.findAll(cacheable);
    }

    public T findFirstByCondition(String whereHql, Object[] params, boolean cacheable) {
        return baseDao.findFirstByCondition(whereHql,params,cacheable);
    }

    public List<T> findConditionWithPaging(String whereHQl, Object[] params, Map<String, String> orderBy, int offset, int length) {
        return baseDao.findConditionWithPaging(whereHQl,params,orderBy,offset,length);
    }

    public int getRowCount(String whereHql, Object[] params) {
        return baseDao.getRowCount(whereHql,params);
    }
}
