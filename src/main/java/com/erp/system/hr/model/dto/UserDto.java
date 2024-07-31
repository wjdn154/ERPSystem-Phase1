package com.erp.system.hr.model.dto;

import com.erp.system.hr.model.basic_information_management.User;

public class UserDto {
    private String departmentId; // 부서 ID 참조
    private String companyId; // 회사 ID 참조
    private String userName; // 사용자 이름
    private String password; // 사용자 비밀번호
    private User.Role role; // 사용자 역할
    private String email; // 사용자 이메일

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User.Role getRole() {
        return role;
    }

    public void setRole(User.Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "departmentId='" + departmentId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }
}
