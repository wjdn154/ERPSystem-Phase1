package com.erp.system.production.model.dto;

/**
 * 생산공정 등록을위한 데이터 전송 객체 (DTO)
 */

public class ProductionProcessDto {
    private String defaultInboundId;
    private String defaultOutboundId;

    private String processName;
    private String description;
    private boolean isActive;

    public String getDefaultInboundId() {
        return defaultInboundId;
    }

    public void setDefaultInboundId(String defaultInboundId) {
        this.defaultInboundId = defaultInboundId;
    }

    public String getDefaultOutboundId() {
        return defaultOutboundId;
    }

    public void setDefaultOutboundId(String defaultOutboundId) {
        this.defaultOutboundId = defaultOutboundId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
