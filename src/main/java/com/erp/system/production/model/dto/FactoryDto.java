package com.erp.system.production.model.dto;

import com.erp.system.production.model.basic_information_management.factory.Factory;

/**
 * 공장 등록을 위한 데이터 전송 객체(DTO)
 */

public class FactoryDto {

    public enum Type {
        MANUFACTURING, ASSEMBLY, PACKAGING, HYBRID, DISTRIBUTION_CENTER, R_AND_D_CENTER
    }

    private String managerId; // 공장 관리자 ID (FK, 인사 Employee.id)
    private String managerDepartmentId; // 공장 관리자 부서 ID (FK, 인사 Department.id)
    private Factory.Type type; // 공장 구분( 제조 공장, 조립 공장, 포장 공장, 분배 센터, 연구 개발 센터 )
    private String name; // 공장 이름 (not null)
    private String location; // 공장 위치 (not null)
    private String description; // 공장 설명
    private String contactNumber; // 공장 연락처

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerDepartmentId() {
        return managerDepartmentId;
    }

    public void setManagerDepartmentId(String managerDepartmentId) {
        this.managerDepartmentId = managerDepartmentId;
    }

    public Factory.Type getType() {
        return type;
    }

    public void setType(Factory.Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
