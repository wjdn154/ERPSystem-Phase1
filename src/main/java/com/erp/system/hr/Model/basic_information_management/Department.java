package com.erp.system.hr.Model.basic_information_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

// 부서 테이블

public class Department {
        @Unique
        @NotNull
        private final String id; // 부서 고유 식별자

        @NotNull
        private String departmentName; // 부서 이름
        @NotNull
        private String managerId; //부서 관리자 ID

        public static int idIndex = 1;

        public static class Builder {
            private String id;
            private String departmentName;
            private String managerId;

            public Builder id(String id) {
                this.id = id;
                return this;
            }

            public Builder departmentName(String departmentName) {
                this.departmentName = departmentName;
                return this;
            }

            public Builder managerId(String managerId) {
                this.managerId = managerId;
                return this;
            }
        }//end of Builder
            private Department(Builder builder){
                this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
                this.departmentName = builder.departmentName;
                this.managerId = builder.managerId;
                NotNullValidator.validateFields(this);
            }
            public Builder tobuild(){
                return new Builder()
                        .id(this.id)
                        .departmentName(this.departmentName)
                        .managerId(this.managerId);
            }
            public String getId() {return id;}
            public String getDepartmentName() {return departmentName;}
            public String getManagerId() {return managerId;}
}
