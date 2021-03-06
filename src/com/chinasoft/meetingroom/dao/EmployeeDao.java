package com.chinasoft.meetingroom.dao;

import com.chinasoft.meetingroom.model.EmployeeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei on 15/6/1.
 */
public class EmployeeDao implements BaseDao<EmployeeEntity> {
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public HibernateTemplate getHibernateTemplate() {
        if (hibernateTemplate == null) {
            hibernateTemplate = new HibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }

    @Override
    public EmployeeEntity get(Class<EmployeeEntity> entityclazz, Serializable id) {
        return getHibernateTemplate().get(entityclazz,id);
    }

    @Override
    public Serializable save(EmployeeEntity entity) {
        return (Integer)getHibernateTemplate().save(entity);
    }

    @Override
    public void update(EmployeeEntity entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void delete(EmployeeEntity entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void delete(Class<EmployeeEntity> entityClazz, Serializable Id) {
        getHibernateTemplate().delete(entityClazz);

    }

    @Override
    public List<EmployeeEntity> findall(Class<EmployeeEntity> entityClazz) {

        return (List<EmployeeEntity>)getHibernateTemplate().find("from EmployeeEntity");
    }

    public List<EmployeeEntity> findByRealName(String name) {
        return ((List<EmployeeEntity>) getHibernateTemplate().find("from EmployeeEntity where employeeName=?", name));
    }

    public List<EmployeeEntity> findByAccountName(String accountname) {
        return ((List<EmployeeEntity>) getHibernateTemplate().find("from EmployeeEntity where userName=?", accountname));
    }

    public List<EmployeeEntity> findByEmployeeStates(int States ) {
        return ((List<EmployeeEntity>) getHibernateTemplate().find("from EmployeeEntity where employeeStatus=?", States));

    }

    public List<EmployeeEntity> findByEmployeeByRealnameOrAccountNameOrEmployeeStates(final int offset, final int length,
                                                                                      final String Realname, final String Username) {
        List<EmployeeEntity> employeeEntities=getHibernateTemplate().execute(new HibernateCallback<List<EmployeeEntity>>() {
            @Override
            public List<EmployeeEntity> doInHibernate(Session session) throws HibernateException {
                Query query=session.createQuery("from EmployeeEntity e where e.employeeName like ? or e.userName like ?");
                query.setString(0, Realname);
                query.setString(1, Username);
                query.setFirstResult(offset);
                query.setMaxResults(length);
                List<EmployeeEntity> list = query.list();
                return list;
            }
        });
        return employeeEntities;
    }

    //通过username取到employee类
    public EmployeeEntity getEmployeeEntityByName(String name){
        List<EmployeeEntity> employeeEntities=(ArrayList<EmployeeEntity>)findByAccountName(name);
        return employeeEntities.get(0);
    }

    //查询Employee的所有实例并且有分页操作
    public List<EmployeeEntity> getListForPage(final String hql, final int offset, final int length) {
        List<EmployeeEntity> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
            @Override
            public List doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery(hql);
                query.setFirstResult(offset);
                query.setMaxResults(length);
                List list = query.list();
                return list;
            }
        });
        return list;
    }


    public List<EmployeeEntity> getAllEmployee(int offset, int length) {
        String hql = "from EmployeeEntity";
        return getListForPage(hql, offset, length);

    }

    //读取用户所搜索的所有用户个数
    public long getListSize(final String Realname, final String Username) {
        final long count = getHibernateTemplate().execute(new HibernateCallback<Long>() {
            @Override
            public Long doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("select  count (*) from EmployeeEntity e where e.employeeName like ? or e.userName like ?");
                query.setString(0, Realname);
                query.setString(1, Username);
                List list = query.list();
                return (Long) list.get(0);
            }
        });
        return count;
    }

    //通过department的id来取得employee
    public List<EmployeeEntity> getEmployeeNameByDepartment(final int D_id) {
        final List<EmployeeEntity> nameList = getHibernateTemplate().execute(new HibernateCallback<List<EmployeeEntity>>() {
            @Override
            public List<EmployeeEntity> doInHibernate(Session session) throws HibernateException {
                Query query = session.createQuery("from EmployeeEntity e where e.departmentByDepartmentId=?");
                query.setInteger(0, D_id);
                List<EmployeeEntity> list = (List<EmployeeEntity>) query.list();
                return list;
            }
        });
        return nameList;
    }



}
