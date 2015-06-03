package com.chinasoft.meetingroom.service;

import com.chinasoft.meetingroom.dao.DepartmentDao;
import com.chinasoft.meetingroom.model.DepartmentEntity;

import java.io.Serializable;

/**
 * Created by wei on 15/6/3.
 */
public class DepartmentService {
    private DepartmentDao departmentDao;
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    public DepartmentEntity getDepartmentByID(Class<DepartmentEntity> entityclazz,Serializable id) {
        return departmentDao.get(entityclazz, id);
    }
}
