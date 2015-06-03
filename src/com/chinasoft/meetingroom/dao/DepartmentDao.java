package com.chinasoft.meetingroom.dao;

import com.chinasoft.meetingroom.model.DepartmentEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wei on 15/6/3.
 */
public class DepartmentDao implements BaseDao<DepartmentEntity> {
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate == null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }

    @Override
    public DepartmentEntity get(Class<DepartmentEntity> entityclazz, Serializable id) {
        return getHibernateTemplate().get(entityclazz, id);
    }

    @Override
    public Serializable save(DepartmentEntity entity) {
        return getHibernateTemplate().save(entity);
    }

    @Override
    public void update(DepartmentEntity entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(DepartmentEntity entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void delete(Class<DepartmentEntity> entityClazz, Serializable Id) {
        getHibernateTemplate().delete(String.valueOf((Integer) Id), entityClazz);
    }

    @Override
    public List<DepartmentEntity> findall(Class<DepartmentEntity> entityClazz) {
        return (List<DepartmentEntity>)getHibernateTemplate().find("from DepartmentEntity");
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
