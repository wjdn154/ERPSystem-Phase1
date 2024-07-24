package com.erp.system.logistics.model.basic_information_registration.warehouse_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

/**
 * 위치 테이블
 * 위치에 대한 정보가 있는 테이블 - 창고 등록 시 사용
 */
public class Location {
    @NotNull
    private final String id; // 위치 코드
    @NotNull
    private final String areaId; // 구역 코드 참조
    @NotNull
    private String name; // 위치명
    private String description; // 위치 설명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String areaId;
        private String name;
        private String description;

        public Location.Builder id(String id) {
            this.id = id;
            return this;
        }

        public Location.Builder areaId(String areaId) {
            this.areaId = areaId;
            return this;
        }

        public Location.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Location.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }

    private Location(Location.Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.areaId = builder.areaId;
        this.name = builder.name;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }

    public Location.Builder tobuild() {
        return new Location.Builder()
                .id(this.id)
                .areaId(this.areaId)
                .name(this.name)
                .description(this.description);
    }

    public String getId() {
        return id;
    }

    public String getAreaId() {
        return areaId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", areaId='" + areaId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
