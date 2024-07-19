package com.erp.system.logistics.model.dto;

import com.erp.system.logistics.model.basic_information_registration.warehouse_registration.Warehouse;

public class WarehouseRegistrationDto {
    private String name; // 창고명
    private Warehouse.WarehouseType type; // 창고유형
    private String areaId; // 구역 코드 참조
    private String areaName; // 구역명
    private String areaDescription; // 구역 설명
    private String locationId; // 위치 코드 참조
    private String locationName; // 위치명
    private String locationDescription; // 위치 설명
    private String description; // 창고 설명
    private boolean isActive; // 창고 사용 여부 (YES or NO)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warehouse.WarehouseType getType() {
        return type;
    }

    public void setType(Warehouse.WarehouseType type) {
        this.type = type;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "WarehouseRegistrationDto{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaDescription='" + areaDescription + '\'' +
                ", locationId='" + locationId + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
