package com.chinasoft.meetingroom.Action;

import com.chinasoft.meetingroom.model.DepartmentEntity;
import com.chinasoft.meetingroom.model.EmployeeEntity;
import com.chinasoft.meetingroom.service.DepartmentService;
import com.chinasoft.meetingroom.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.applet2.preloader.event.ErrorEvent;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by wei on 15/6/1.
 */
public class EmployeeAction extends ActionSupport{
    private int pagenum;
    private long count;
    private int currentPage;
    private int page;
    private String name;
    private String pwd;
    private int offset;
    private int employeeStates;
    private EmployeeEntity employeeEntity;
    private String realname;
    private String username;
    private String password;
    private String repwd;
    private String newpwd;
    private String telnumber;
    private String email;
    private String departmentId;
    private DepartmentService departmentService;
    private List<EmployeeEntity> employees;
    private int id;

    public int getEmployeeStates() {
        return employeeStates;
    }

    public void setEmployeeStates(int employeeStates) {
        this.employeeStates = employeeStates;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
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

    //登录
    public String employeeLogin(){
        if(employeeService.verifyUser(name, pwd)) {
            employeeEntity = employeeService.getEmployeebyName(name);
            ActionContext actionContext = ActionContext.getContext();
            actionContext.getSession().put("level", employeeEntity.getRoleByRoleid().getRoleName());
            actionContext.getSession().put("id", employeeEntity.getEmployeeId());
            pwd = null;
            return SUCCESS;
        }else {
            return ERROR;
        }
    }

    //保存用户
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



    //更改密码
    public String changePassword() {
        if(repwd.equals(newpwd)) {
            ActionContext actionContext = ActionContext.getContext();
            Integer id = (Integer) actionContext.getSession().get("id");
            if (employeeService.changePassword(password, newpwd, id)) {
                return SUCCESS;
            } else {
            }
                return ERROR;
        }else
            return ERROR;
    }

    //显示所有待验证的用户
    public String showUncheckedEmployee() {
        employees=employeeService.showUncheckedEmployee();
        return SUCCESS;
    }

    //删除用户
    public String deleteEmployee() {
        System.out.println(id);
        EmployeeEntity emplyee=employeeService.getEmployee(id);
        employeeService.deleteEmployee(emplyee);
        return SUCCESS;
    }

    //验证用户
    public String checkEmployee(){
        System.out.println(id);
        EmployeeEntity emplyee=employeeService.getEmployee(id);
        emplyee.setEmployeeStatus(1);
        employeeService.updateEmployee(emplyee);
        System.out.println(emplyee.getEmployeeName() + emplyee.getEmployeeStatus());
        return SUCCESS;
    }
//
//    public String getAllEmployee() {
//        if(pagenum!=0) {
//            offset = (int) (pagenum * 5 - 4);
//            employees = employeeService.getAllEmployee(offset, 6);
//            pagenum = 0;
//            return SUCCESS;
//        }else {
//        count = employeeService.getListSize();
//        page = (int)Math.ceil(count / 5);
//        currentPage=(int)(offset/5+1);
//        employees = employeeService.getAllEmployee(offset, 6);
//        return SUCCESS;
//        }
//
//    }

    //通过姓名或用户名来寻找employee
    public String findByEmployeeByRealnameOrAccountNameOrEmployeeStates() {
        if(pagenum!=0){
            offset = (int) (pagenum * 5 - 4);
            employees = employeeService.findByEmployeeByRealnameOrAccountNameOrEmployeeStates(offset, 5, realname, username);
            pagenum = 0;
            return SUCCESS;

        }else {
            count = employeeService.getListSize(realname,username);
            if(count<=5) {
                page = 1;
            }else {
            page = (int) Math.ceil(count / 5.0);
            }
            currentPage = (int) (offset / 5 + 1);
            System.out.println(realname + username);
            employees = employeeService.findByEmployeeByRealnameOrAccountNameOrEmployeeStates(offset, 5, realname, username);
            System.out.println(count);
            return SUCCESS;
        }
    }





}
