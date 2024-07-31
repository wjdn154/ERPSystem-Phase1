package com.erp.system.hr.model.basic_information_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

// 사용자 테이블
@EnumMapping
public class User {
    public enum Role{SYSTEM_ADMINISTRATOR, HR_MANAGER, DEPARTMENT_MANAGER, FINANCIAL_MANAGER, PROCUREMENT_MANAGER, SALES_MANAGER }

    @Unique
    @NotNull
    private final String id; // 사용자의 고유 식별자
    @NotNull
    private final String departmentId; // 부서 ID 참조
    @NotNull
    private final String companyId; // 회사 ID 참조

    @NotNull
    private String userName; // 사용자 이름
    @NotNull
    private String password; // 사용자 비밀번호
    @NotNull
    private Role role; // 사용자 역할(시스템 관리자, 인사 관리자, 부서 관리자, 재무 관리자, 구매 관리자, 영업 관리자)
    @Unique
    private String email; // 사용자 이메일

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String departmentId;
        private String companyId;

        private String userName;
        private String password;
        private Role role;
        private String email;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder companyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }//end of Builder

    private User(Builder builder){
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.departmentId = builder.departmentId;
        this.companyId = builder.companyId;
        this.userName = builder.userName;
        this.password = builder.password;
        this.role = builder.role;
        this.email = builder.email;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .departmentId(this.departmentId)
                .companyId(this.companyId)
                .userName(this.userName)
                .password(this.password)
                .role(this.role)
                .email(this.email);
    }

    public String getId() {return id;}

    public String getDepartmentId() {return departmentId;}

    public String getCompanyId() {return companyId;}

    public String getUserName() {return userName;}

    public String getPassword() {return password;}

    public Role getRole() {return role;}

    public String getEmail() {return email;}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }
}
