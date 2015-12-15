package org.eja.sisolf.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDAO<E, ID extends Serializable> implements Serializable{
    
    @Autowired
    private SessionFactory sessionFactory;

    private Class<E> type;

    public GenericDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class<E>) pt.getActualTypeArguments()[0];
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    protected Session getCurrentSession(){
        return getSessionFactory().getCurrentSession();
    }
    
    protected Criteria createCriteria() {
        return getCurrentSession().createCriteria(type);
    }
    
    public void save(E e){
        getCurrentSession().save(e);
    }
    
    public void update(E e){
        getCurrentSession().update(e);
    }
    
    public void saveOrUpdate(E e){
        getCurrentSession().saveOrUpdate(e);
    }
    
    public void delete(E e){
        getCurrentSession().delete(e);
    }
    
    public E findById(ID id){
        return (E)getCurrentSession().get(type, id);
    }
    
    public List<E> findAll(){
        return getCurrentSession().createQuery("FROM "+type.getSimpleName()).list();
    }

}
