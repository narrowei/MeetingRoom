package com.chinasoft.meetingroom.Action;

import com.chinasoft.meetingroom.model.EmployeeEntity;
import com.chinasoft.meetingroom.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.applet2.preloader.event.ErrorEvent;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by wei on 15/6/1.
 */
public class EmployeeAction extends ActionSupport{
    private String name;
    private String pwd;
    private EmployeeEntity employeeEntity;
    private String realname;
    private String repwd;
    private int telnumber;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRepwd() {
        return repwd;
    }

    public void setRepwd(String repwd) {
        this.repwd = repwd;
    }

    public int getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(int telnumber) {
        this.telnumber = telnumber;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String employeeLogin(){
        if(employeeService.verifyUser(name,pwd)){
            employeeEntity=employeeService.getEmployee(name);
            ActionContext actionContext=ActionContext.getContext();
            actionContext.put("level",employeeEntity.getRoleid());
            pwd=null;
            return SUCCESS;
        }else {
            return ERROR;
        }
    }
    public String saveEmployee(){


        return ERROR;
    }

}
