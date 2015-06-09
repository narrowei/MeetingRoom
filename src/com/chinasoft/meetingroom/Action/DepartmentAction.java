package com.chinasoft.meetingroom.Action;

import com.chinasoft.meetingroom.model.DepartmentEntity;
import com.chinasoft.meetingroom.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wei on 15/6/5.
 */
public class DepartmentAction extends ActionSupport {
    private DepartmentService departmentService;
    private String name;
    private List<DepartmentEntity> departmentEntityList;
    private int id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DepartmentEntity> getDepartmentEntityList() {
        return departmentEntityList;
    }

    public void setDepartmentEntityList(List<DepartmentEntity> departmentEntityList) {
        this.departmentEntityList = departmentEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    public String saveDeoartment() {
        System.out.println("name"+name);
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setDepartmentName(name);
        Serializable id=departmentService.saveDepartment(departmentEntity);
        System.out.println(departmentEntity.getDepartmentName());
        return SUCCESS;
    }

    public String getDepartments() {
        departmentEntityList = departmentService.getDepartments();
        return SUCCESS;
    }

    public String deleteDepartment() {
        DepartmentEntity departmentEntity = departmentService.getDepartment(id);
        departmentService.delete(departmentEntity);
        return SUCCESS;
    }

    public String getDepartmentByJson() throws IOException{
        departmentEntityList = departmentService.getDepartments();
        return SUCCESS;
    }

}
