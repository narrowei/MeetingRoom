package com.chinasoft.meetingroom.Action;

import com.chinasoft.meetingroom.model.DepartmentEntity;
import com.chinasoft.meetingroom.model.EmployeeEntity;
import com.chinasoft.meetingroom.service.DepartmentService;
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
    private String username;
    private String password;
    private String repwd;
    private String telnumber;
    private String email;
    private String departmentId;
    private DepartmentService departmentService;
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

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

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
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
        if(employeeService.verifyUser(name,pwd)) {
            employeeEntity = employeeService.getEmployeebyName(name);
            ActionContext actionContext = ActionContext.getContext();
            actionContext.getSession().put("level", employeeEntity.getRoleByRoleid().getRoleName());
            pwd = null;
            return SUCCESS;
        }else {
            return ERROR;
        }
    }
    public String saveEmployee() {
        System.out.println(realname+username);
        DepartmentEntity departmentEntity = departmentService.getDepartmentByID(DepartmentEntity.class, Integer.valueOf(departmentId));
        if(password.equals(repwd)) {
            EmployeeEntity employee = new EmployeeEntity(realname, username, password, telnumber, email, departmentEntity);
            employeeService.saveEmployee(employee);
            return SUCCESS;
        } else
            return ERROR;
    }


}
