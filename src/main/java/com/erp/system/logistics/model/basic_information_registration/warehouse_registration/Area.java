package com.erp.system.logistics.model.basic_information_registration.warehouse_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

/**
 * 구역 테이블
 * 구역에 대한 정보가 있는 테이블 - 창고 등록 시 사용
 */
public class Area {
    @NotNull
    private final String id; // 구역 코드
    @NotNull
    private final String warehouseId; // 창고 코드 참조
    @NotNull
    private String name; // 구역명
    private String description; // 구역 설명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String warehouseId;
        private String name;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder warehouseId(String warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Area build() {
            return new Area(this);
        }
    }

    private Area(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.warehouseId = builder.warehouseId;
        this.name = builder.name;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .warehouseId(this.warehouseId)
                .name(this.name)
                .description(this.description);
    }

    public String getId() {
        return id;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id='" + id + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
