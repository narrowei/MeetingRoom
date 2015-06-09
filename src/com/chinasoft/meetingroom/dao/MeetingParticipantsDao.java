package com.chinasoft.meetingroom.dao;

import com.chinasoft.meetingroom.model.MeetingParticipantsEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wei on 15/6/9.
 */
public class MeetingParticipantsDao implements BaseDao<MeetingParticipantsEntity>{
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate != null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }

    @Override
    public MeetingParticipantsEntity get(Class<MeetingParticipantsEntity> entityclazz, Serializable id) {
        return null;
    }

    @Override
    public Serializable save(MeetingParticipantsEntity entity) {
        return hibernateTemplate.save(entity);
    }

    @Override
    public void update(MeetingParticipantsEntity entity) {

    }

    @Override
    public void delete(MeetingParticipantsEntity entity) {

    }

    @Override
    public void delete(Class<MeetingParticipantsEntity> entityClazz, Serializable Id) {

    }

    @Override
    public List<MeetingParticipantsEntity> findall(Class<MeetingParticipantsEntity> entityClazz) {
        return null;
    }

    //通过会议的id来寻找被邀请参加的用户
    public List<Object[]> getEmployeesByMeetingId(final int id){
        final List<Object[]> list=getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {
            @Override
            public List<Object[]> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select e.employeeName,e.phone,e.email from EmployeeEntity e,MeetingParticipantsEntity m " +
                        "where m.participantId=e.id and m.meetingId=?");
                query.setInteger(0, id);
                List<Object[]> l = query.list();
                return l;
            }
        });
        return list;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
