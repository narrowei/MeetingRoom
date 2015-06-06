package com.chinasoft.meetingroom.dao;

import com.chinasoft.meetingroom.model.EmployeeEntity;
import com.chinasoft.meetingroom.model.MeetingRoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wei on 15/6/6.
 */
public class MeetingRoomDao implements BaseDao<MeetingRoomEntity> {
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate == null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }
    @Override
    public MeetingRoomEntity get(Class<MeetingRoomEntity> entityclazz, Serializable id) {
        return getHibernateTemplate().get(entityclazz, id);
    }

    @Override
    public Serializable save(MeetingRoomEntity entity) {
        return getHibernateTemplate().save(entity);
    }

    @Override
    public void update(MeetingRoomEntity entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(MeetingRoomEntity entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void delete(Class<MeetingRoomEntity> entityClazz, Serializable Id) {
        getHibernateTemplate().delete((String)Id, entityClazz);
    }

    @Override
    public List<MeetingRoomEntity> findall(Class<MeetingRoomEntity> entityClazz) {
        return (List<MeetingRoomEntity>) getHibernateTemplate().find("from MeetingRoomEntity");
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
