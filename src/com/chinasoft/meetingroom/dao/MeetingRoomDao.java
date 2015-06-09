package com.chinasoft.meetingroom.dao;


import com.chinasoft.meetingroom.model.MeetingRoomEntity;
import org.aspectj.apache.bcel.generic.RET;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public List<Object[]> findMeetingRoomByWords(final int offset,final int length,final String meetingName,final String roomName,
    final String reservername,final String berforeReserve,final String AfterReserve,final String beforeEnd,final String afterEnd  ) {
        final List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select r.roomName,e.employeeName,m.meetingName,m.beginTime,m.endTime,m.reservationTime from MeetingEntity m ,MeetingRoomEntity r,EmployeeEntity e \n" +
                        "     where m.roomId=r.roomId and m.reservationistId=e.id and(m.meetingName  like ? or r.roomName  like ? or e.employeeName like ? or m.beginTime between ? and ? or m.endTime between ? and ?) ");
                query.setString(0, meetingName);
                query.setString(1, roomName);
                query.setString(2, reservername);
                query.setString(3, berforeReserve);
                query.setString(4, AfterReserve);
                query.setString(5, beforeEnd);
                query.setString(6, afterEnd);
                query.setFirstResult(offset);
                query.setMaxResults(length);
                ArrayList<Object[]> arrayList= (ArrayList<Object[]>)query.list();
                return arrayList;
            }
        });
        return list;
    }

    public Long getMeetingsSize(final String meetingName,final String roomName,
                                final String reservername,final String berforeReserve,final String AfterReserve,final String beforeEnd,final String afterEnd){
        final long count=getHibernateTemplate().execute(new HibernateCallback<Long>() {
            @Override
            public Long doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select count(*) from MeetingEntity m ,MeetingRoomEntity r,EmployeeEntity e \n" +
                        "     where m.roomId=r.roomId and m.reservationistId=e.id and(m.meetingName  like ? or r.roomName  like ? or e.employeeName like ? or m.beginTime between ? and ? or m.endTime between ? and ?) ");
                query.setString(0, meetingName);
                query.setString(1, roomName);
                query.setString(2, reservername);
                query.setString(3, berforeReserve);
                query.setString(4, AfterReserve);
                query.setString(5, beforeEnd);
                query.setString(6, afterEnd);
                List list = query.list();
                return (long) list.get(0);
            }
        });
        return count;
    }

 }


