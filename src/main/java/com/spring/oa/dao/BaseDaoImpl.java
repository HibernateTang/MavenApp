package com.spring.oa.dao;


import com.mysql.jdbc.StringUtils;
import com.spring.oa.util.GenericClass;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by burning-.- on 2015/6/26.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    /*泛型参数的具体类型*/
    private Class<?> entityClass= GenericClass.getGenericClass(this.getClass());
   /*注入spring容器中的Sessionfactory*/
    @Resource(name="sessionFactory")
    public void setSessionFactory4Spring(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
    public void setEntity(Class<?> entityClass) {
       this.entityClass=entityClass;
    }

    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }
    @SuppressWarnings("unchecked")
    public T findById(Serializable id) {
        return (T)this.getHibernateTemplate().get(entityClass,id);
    }

    public void deleteById(Serializable... ids) {
        if(ids!=null&&ids.length>0){
            for (Serializable id:ids){
                Object entity=this.getHibernateTemplate().get(entityClass,id);
                if(entity!=null){
                    this.getHibernateTemplate().delete(entity);
                }
            }
        }
    }

    public void deleteAll(Collection<T> entityClass) {
            this.getHibernateTemplate().deleteAll(entityClass);
    }
    @SuppressWarnings({"rawtypes","unchecked"})
    public List<T> findByCondition(String whereHql, final Object[] params, Map<String, String> orderBy, final boolean cacheable) {
        String hql="select o from"+entityClass.getSimpleName()+"o where 1=1";
        if(!StringUtils.isNullOrEmpty(whereHql)){
            hql=hql+whereHql;
        }
        String orderByStr=this.buildOrderBy(orderBy);
        hql=hql+whereHql;
        final String _hql=hql;
        List<T> list=(List<T>)this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                org.hibernate.Query query=session.createQuery(_hql);
                if(cacheable){
                    query.setCacheable(true);
                }
                setParams((Query) query,params);
                return query.list();
            }
        });
        return list;
    }

    public List<T> findByCondition(String whereHql, Object[] params, boolean cacheable) {
        return this.findByCondition(whereHql,params,null,cacheable);
    }

    public List<T> findByCondition(Map<String, String> orderBy, boolean cacheable) {
        return this.findByCondition(null,null,orderBy,cacheable);
    }

    public List<T> findAll(boolean cacheable) {
        return this.findByCondition(null,null,null,cacheable);
    }

    public T findFirstByCondition(String whereHql, Object[] params, boolean cacheable) {
        List<T> list=this.findByCondition(whereHql,params,cacheable);
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @SuppressWarnings({"rawtypes","unchecked"})
    public List<T> findConditionWithPaging(String whereHql, final Object[] params, Map<String, String> orderBy, final int offset, final int length) {
        String hql="select o from"+entityClass.getSimpleName()+" o where 1=1";
        if(!StringUtils.isNullOrEmpty(whereHql)){
            hql=hql+whereHql;
        }
        String orderByStr=buildOrderBy(orderBy);
        hql=hql+orderByStr;
        final String _hql=hql;
        List<T>list=this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
                org.hibernate.Query query=session.createQuery(_hql);
                query.setFirstResult(offset);
                query.setMaxResults(length);
                setParams((Query) query,params);
                return query.list();
            }
        });
        return list;
    }
    private void setParams(Query query,Object []params){
        if(params!=null&&params.length>0){
            for (int i = 0; i <params.length ; i++) {
               query.setParameter(i,params);
            }
        }
    }
    private String buildOrderBy(Map<String ,String > orderBy){
        StringBuffer buffer=new StringBuffer();
        if(orderBy!=null&&!orderBy.isEmpty()){
            buffer.append(" order by");
            for(Map.Entry<String ,String> em:orderBy.entrySet()){
                buffer.append(em.getKey()+" "+em.getValue()+",");
            }
            buffer.deleteCharAt(buffer.length() - 1);
        }
        return buffer.toString();
    }

    public int getRowCount(String whereHql, final Object[] params) {
        String hql="select count(*) from "+entityClass.getSimpleName()+" o where 1=1";
        if(!StringUtils.isNullOrEmpty(whereHql)){
            hql=hql+whereHql;
        }
        final String _hql=hql;
        long count=this.getHibernateTemplate().execute(new HibernateCallback<Long>() {
            public Long doInHibernate(Session session) throws HibernateException, SQLException {
                org.hibernate.Query query=session.createQuery(_hql);
                setParams((Query) query,params);
                return (Long) query.uniqueResult();
            }
        });
        return 0;
    }
}
