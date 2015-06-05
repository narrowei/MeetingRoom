package com.chinasoft.meetingroom.service;

import com.chinasoft.meetingroom.dao.EmployeeDao;
import com.chinasoft.meetingroom.model.DepartmentEntity;
import com.chinasoft.meetingroom.model.EmployeeEntity;

import javax.jws.soap.SOAPBinding;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wei on 15/6/1.
 */
public class EmployeeService {
    public EmployeeDao employeeDao;
    public EmployeeEntity employeeEntity;
    private EmployeeEntity employee;



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

    public boolean changePassword(String oldPwd, String newPwd ,Serializable id) {
         employee = employeeDao.get(EmployeeEntity.class, id);
        if (oldPwd.equals(employee.getUserPwd())) {
            employee.setUserPwd(newPwd);
            employeeDao.update(employee);
            return  true;
        }else
            return  false;

    }

    public List<EmployeeEntity> showUncheckedEmployee(){
        Integer states=0;
        return employeeDao.findByEmployeeStates(states);
    }

    public void deleteEmployee(EmployeeEntity employeeEntity) {
        employeeDao.delete(employeeEntity);
    }

    public void updateEmployee(EmployeeEntity employee) {
        employeeDao.update(employee);
    }

    public List<EmployeeEntity> getAllEmployee(int offset, int length) {
        return employeeDao.getAllEmployee(offset, length);
    }
    public long getListSize(String realname,String username) {
        if(realname.equals("")&&username.equals("")) {
            realname = "%%";
            username = "%%";
        }
        if(!realname.equals("")) {
            realname = "%" + realname + "%";
        }
        if(!username.equals("")) {
            username = "%" + username + "%";
        }
        return employeeDao.getListSize(realname, username);
    }
    public List<EmployeeEntity> findByEmployeeByRealnameOrAccountNameOrEmployeeStates( int offset,  int length,
                                                                                       String Realname,  String Username) {
        if(Realname.equals("")&&Username.equals("")) {
            Realname = "%%";
            Username = "%%";
        }
        if(!Realname.equals("")) {
            Realname = "%" + Realname + "%";
        }
        if(!Username.equals("")) {
            Username = "%" + Username + "%";
        }
        System.out.println(Username);
        return employeeDao.findByEmployeeByRealnameOrAccountNameOrEmployeeStates(offset, length, Realname, Username);
    }



}
