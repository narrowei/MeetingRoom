package com.chinasoft.meetingroom.service;

import com.chinasoft.meetingroom.dao.EmployeeDao;
import com.chinasoft.meetingroom.model.EmployeeEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei on 15/6/1.
 */
public class EmployeeService {
    public EmployeeDao employeeDao;
    public EmployeeEntity employeeEntity;



    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public boolean verifyUser(String name,String pwd)
    {
        List<EmployeeEntity> employees=(ArrayList<EmployeeEntity>)employeeDao.findByAccountName(name);
        if(employees.size()>=1){
            EmployeeEntity employee=employees.get(0);
            System.out.println(employee.getUserName()+employee.getUserPwd());
            if(employee.getUserName().equals(name)&&employee.getUserPwd().equals(pwd)){
                return true;
            }
            else {
                return false;
            }
        }
        else{
        return false;
        }
    }

    public EmployeeEntity getEmployee(Serializable Id){
        return employeeDao.get(EmployeeEntity.class,Id);
    }
    public EmployeeEntity getEmployeebyName(String name){return employeeDao.getEmployeeEntityByName(name);}
    public void saveEmployee(EmployeeEntity employeeEntity){
        employeeDao.save(employeeEntity);
    }
}
