package com.chinasoft.meetingroom.service;

import com.chinasoft.meetingroom.dao.DepartmentDao;
import com.chinasoft.meetingroom.model.DepartmentEntity;

import java.io.Serializable;
import java.util.List;

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
    public Serializable saveDepartment(DepartmentEntity departmentEntity) {
        System.out.println(departmentEntity.getDepartmentName());
        return departmentDao.save(departmentEntity);
    }

    public List<DepartmentEntity> getDepartments() {
        return departmentDao.findall(DepartmentEntity.class);
    }

    public void delete(DepartmentEntity departmentEntity){
        departmentDao.delete(departmentEntity);
    }

    public DepartmentEntity getDepartment(Serializable id) {
        return departmentDao.get(DepartmentEntity.class, id);
    }
}
