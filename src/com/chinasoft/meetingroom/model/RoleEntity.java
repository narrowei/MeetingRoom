package com.chinasoft.meetingroom.model;

import java.util.Collection;

/**
 * Created by wei on 15/5/29.
 */
public class RoleEntity {
    private Integer roleId;
    private String roleName;
    private String remark;
    private Collection<EmployeeEntity> employeesByRoleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

        RoleEntity that = (RoleEntity) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }

    public Collection<EmployeeEntity> getEmployeesByRoleId() {
        return employeesByRoleId;
    }

    public void setEmployeesByRoleId(Collection<EmployeeEntity> employeesByRoleId) {
        this.employeesByRoleId = employeesByRoleId;
    }
}
