package com.erp.system.logistics.model.basic_information_registration.warehouse_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

/**
 * 창고 테이블
 * 창고에 대한 정보가 있는 테이블 - 창고 등록 시 사용
 */
public class Warehouse {
    public enum WarehouseType {WAREHOUSE, FACTORY}

    @NotNull
    private final String id; // 창고 고유 식별자

    @NotNull
    private String name; // 창고명
    @NotNull
    private WarehouseType type; // 창고유형
    @NotNull
    private boolean isActive; // 창고 사용 여부 (YES or NO)
    private String description;

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;
        private WarehouseType type;
        private boolean isActive;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String warehouseName) {
            this.name = name;
            return this;
        }

        public Builder type(WarehouseType type) {
            this.type = type;
            return this;
        }


        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Warehouse build() {
            return new Warehouse(this);
        }
    }// end of Builder

    private Warehouse(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.type = builder.type;
        this.isActive = builder.isActive;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .type(this.type)
                .isActive(this.isActive)
                .description(this.description);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public WarehouseType getType() {
        return type;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", isActive=" + isActive +
                ", description='" + description + '\'' +
                '}';
    }
}