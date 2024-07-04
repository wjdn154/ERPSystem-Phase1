package com.erp.system.production.model.basic_information_management.factory;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

/**
 * 공장 정보 관리 테이블
 */
@EnumMapping
public class Factory {
    public enum Type { MANUFACTURING, ASSEMBLY, PACKAGING, HYBRID, DISTRIBUTION_CENTER, R_AND_D_CENTER };

    @Unique
    @NotNull
    private final String id; // 공장 ID (PK, not null, unique)
    @NotNull
    private Type type; // 공장 구분( 제조 공장, 조립 공장, 포장 공장, 분배 센터, 연구 개발 센터 )
    @NotNull
    private String name; // 공장 이름 (not null)
    @NotNull
    private String location; // 공장 위치 (not null)
    private String description; // 공장 설명
    @NotNull
    private String managerId; // 공장 관리자 ID (FK, 인사 Employee.id)
    @NotNull
    private String managerDepartmentId; // 공장 관리자 부서 ID (FK, 인사 Department.id)
    private String contactNumber; // 공장 연락처

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private Type type;
        private String name;
        private String location;
        private String description;
        private String managerId;
        private String managerDepartmentId;
        private String contactNumber;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder managerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder managerDepartmentId(String managerDepartmentId) {
            this.managerDepartmentId = managerDepartmentId;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Factory build() {
            return new Factory(this);
        }
    }

    private Factory(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.type = builder.type;
        this.name = builder.name;
        this.location = builder.location;
        this.description = builder.description;
        this.managerId = builder.managerId;
        this.managerDepartmentId = builder.managerDepartmentId;
        this.contactNumber = builder.contactNumber;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .type(this.type)
                .name(this.name)
                .location(this.location)
                .description(this.description)
                .managerId(this.managerId)
                .managerDepartmentId(this.managerDepartmentId)
                .contactNumber(this.contactNumber)
    }

    // Getters

    public String getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getManagerDepartmentId() {
        return managerDepartmentId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", managerId='" + managerId + '\'' +
                ", managerDepartmentId='" + managerDepartmentId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
