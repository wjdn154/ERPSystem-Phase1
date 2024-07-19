package com.erp.system.production.model.dto;

import com.erp.system.production.model.basic_information_management.workcenter_process.Workcenter;

/**
 * 작업장 등록을 위한 데이터 전송 객체 (DTO)
 */

public class WorkcenterDto {
    public enum WorkcenterType { PRODUCTION, ASSEMBLY, QUALITY_CONTROL, PACKAGING, MAINTENANCE, R_AND_D, TEST, LOGISTICS };

    private String factoryId; // 공장코드 (FK)
    private String primaryProcessId; // 주생산공정 (FK, 생산공정코드)
    private String primaryResourceId; // 주작업자원 (FK, 생산자원코드)
    private String name; // 작업장명
    private Workcenter.WorkcenterType type;  // 작업장구분 (예: 생산, 조립, 품질 관리 등)
    private String description; // 작업장에 대한 설명
    private int inputPersonnel;  // 투입인원수 ( 변동 잦을 수 있는 값이라 nullable )

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getPrimaryProcessId() {
        return primaryProcessId;
    }

    public void setPrimaryProcessId(String primaryProcessId) {
        this.primaryProcessId = primaryProcessId;
    }

    public String getPrimaryResourceId() {
        return primaryResourceId;
    }

    public void setPrimaryResourceId(String primaryResourceId) {
        this.primaryResourceId = primaryResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Workcenter.WorkcenterType getType() {
        return type;
    }

    public void setType(Workcenter.WorkcenterType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInputPersonnel() {
        return inputPersonnel;
    }

    public void setInputPersonnel(int inputPersonnel) {
        this.inputPersonnel = inputPersonnel;
    }
}
