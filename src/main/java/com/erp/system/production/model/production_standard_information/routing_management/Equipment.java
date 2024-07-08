package com.erp.system.production.model.production_standard_information.routing_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.time.LocalDate;

public class Equipment {
    @NotNull
    @Unique
    private final String id;
    @NotNull
    private final String equipmentStandardId; // FK, 설비기준ID
    @NotNull
    private final String workcenterId; // FK, 작업장ID
    @NotNull
    private String name; // 설비명(모델명, not unique - 추후 설비 유지보수관리에서 이름 및 구분 등으로 그룹화해서 id로 수량체크)
    @NotNull
    private LocalDate last_maintenance_date; // 마지막 유지보수 일자

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String equipmentStandardId;
        private String workcenterId;
        private String name;
        private LocalDate last_maintenance_date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder equipmentStandardId(String equipmentStandardId) {
            this.equipmentStandardId = equipmentStandardId;
            return this;
        }

        public Builder workcenterId(String workcenterId) {
            this.workcenterId = workcenterId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder last_maintenance_date(LocalDate last_maintenance_date) {
            this.last_maintenance_date = last_maintenance_date;
            return this;
        }

        public Equipment build() { return new Equipment(this); }

    }

    // private Builder
    private Equipment(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.equipmentStandardId = builder.equipmentStandardId;
        this.workcenterId = builder.workcenterId;
        this.name = builder.name;
        this.last_maintenance_date = builder.last_maintenance_date;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .equipmentStandardId(this.equipmentStandardId)
                .workcenterId(this.workcenterId)
                .name(this.name)
                .last_maintenance_date(this.last_maintenance_date);
    }



    // Getters
    public String getId() { return id;}

    public String getEquipmentStandardId() {
        return equipmentStandardId;
    }

    public String getWorkcenterId() {
        return workcenterId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getLast_maintenance_date() {
        return last_maintenance_date;
    }

    public static int getIdIndex() { return idIndex;}

    @Override
    public String toString() {
        return "Equipment{" +
                "id='" + id + '\'' +
                ", equipmentStandardId'" + equipmentStandardId + '\'' +
                ", workcenterId'" + workcenterId + '\'' +
                ", name'" + name + '\'' +
                ", last_maintenance_date'" + last_maintenance_date + '\'' +
                '}';
    }
}
