package com.chinasoft.meetingroom.dao;

import com.chinasoft.meetingroom.model.MeetingEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by wei on 15/6/8.
 */
public class MeetingDao implements BaseDao<MeetingEntity> {
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate(){
        if(hibernateTemplate==null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }
    @Override
    public MeetingEntity get(Class<MeetingEntity> entityclazz, Serializable id) {
        return getHibernateTemplate().get(entityclazz, id);
    }

    @Override
    public Serializable save(MeetingEntity entity) {
        return getHibernateTemplate().save(entity);
    }

    @Override
    public void update(MeetingEntity entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(MeetingEntity entity) {
getHibernateTemplate().delete(entity);
    }

    @Override
    public void delete(Class<MeetingEntity> entityClazz, Serializable Id) {

    }

    @Override
    public List<MeetingEntity> findall(Class<MeetingEntity> entityClazz) {
        return (List<MeetingEntity>)getHibernateTemplate().find("from MeetingEntity", entityClazz);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    //查询7天内的会议
    public List<Object[]> find7DayMeetings() {
        Date d = new Date();
        final Date before = new Date(d.getTime());
        final Date after = new Date(d.getTime() + 7 * 24 * 60 * 60 * 1000);
        List<Object[]> list =getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select m.meetingName,r.roomName,m.beginTime,m.endTime " +
                        "from MeetingEntity m ,MeetingRoomEntity r,EmployeeEntity e ,m.id " +
                        "where m.roomId=r.roomId and m.reservationistId=e.id and m.beginTime between ? and ?");
                query.setDate(0, before);
                query.setDate(1, after);
                List<Object[]> l = (List<Object[]>)query.list();
                return l;
            }
        });
        return list;
    }

    //查询取消的会议
    public List<Object[]> findCanceledMeetings() {
        List<Object[]> list =getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select m.meetingName,r.roomName,m.beginTime,m.endTime " +
                        "from MeetingEntity m ,MeetingRoomEntity r,EmployeeEntity e ,m.id " +
                        "where m.roomId=r.roomId and m.reservationistId=e.id and m.meetingStatus=2");
                List<Object[]> l = (List<Object[]>)query.list();
                return l;
            }
        });
        return list;
    }


    //通过会议的预订者的id来得到会议
    public List<Object[]> findMeetingsById(final int id) {
        List<Object[]> list =getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select m.meetingName,r.roomName,m.beginTime," +
                        "m.endTime,m.reservationTime ,m.id from MeetingEntity m ,MeetingRoomEntity r,EmployeeEntity e " +
                        "where m.roomId=r.roomId and m.reservationistId=e.id and m.reservationistId=?");
                query.setInteger(0, id);
                List<Object[]> l = (List<Object[]>)query.list();
                return l;
            }
        });
        return list;
    }

    //寻找用户所被邀请的会议
    public List<Object[]> findAttendMeeting(final int id) {

        List<Object[]> list =getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select m.meetingName,r.roomName,m.beginTime,m.endTime," +
                        "m.reservationTime,e.employeeName,m.id from MeetingEntity m ,MeetingRoomEntity r,EmployeeEntity e ," +
                        "MeetingParticipantsEntity mpe where m.roomId=r.roomId and m.reservationistId=e.id " +
                        "and mpe.meetingId=m.id and mpe.participantId=?");
                query.setInteger(0, id);
                List<Object[]> l = (List<Object[]>)query.list();
                return l;
            }
        });
        return list;
    }


    //通过会议的id来寻找会议
    public List<Object[]> findByMeetingId(final int id){
        List<Object[]> list =getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select m.meetingName,m.numOfParticipants," +
                        "m.beginTime,m.endTime,m.description,m.id from MeetingEntity m ,MeetingRoomEntity r," +
                        "EmployeeEntity e " +
                        "where m.roomId=r.roomId and m.reservationistId=e.id and m.id=?");
                query.setInteger(0, id);
                List<Object[]> l = (List<Object[]>)query.list();
                return l;
            }
        });
        return list;
    }


}
