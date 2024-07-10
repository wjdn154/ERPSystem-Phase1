package com.erp.system.logistics.model.dto;

public class WarehouseRegistrationDto {
    private String id; // 창고 고유 식별자
    private String name; // 창고명
    private String type; // 창고 유형
    private String description; // 창고 설명
    private String areaId; // 구역 코드 참조
    private String locationId; // 위치 코드 참조
    private boolean isActive; // 창고 사용 여부 (YES or NO)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
