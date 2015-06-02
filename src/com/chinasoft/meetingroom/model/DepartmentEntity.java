package com.chinasoft.meetingroom.model;

import java.util.Collection;

/**
 * Created by wei on 15/5/29.
 */
public class DepartmentEntity {
    private Integer departmentId;
    private String departmentName;
    private String remark;
    private Collection<EmployeeEntity> employeesByDepartmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    public Collection<EmployeeEntity> getEmployeesByDepartmentId() {
        return employeesByDepartmentId;
    }

    public void setEmployeesByDepartmentId(Collection<EmployeeEntity> employeesByDepartmentId) {
        this.employeesByDepartmentId = employeesByDepartmentId;
    }
}
