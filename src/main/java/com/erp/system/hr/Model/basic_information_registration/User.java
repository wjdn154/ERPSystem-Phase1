package com.erp.system.hr.Model.basic_information_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

// 사용자 테이블

public class User {
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
    private String role; // 사용자 역할
    private String email; // 사용자 이메일

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String departmentId;
        private String companyId;

        private String userName;
        private String password;
        private String role;
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

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
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
        NotNullValidator.safeValidateFields(this);
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

    public String getRole() {return role;}

    public String getEmail() {return email;}
}
