package com.erp.system.production.model.production_standard_information.standard_information_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.time.Year;

public class ProductionEquipmentStandard {
    @NotNull
    @Unique
    private final String id; // PK
    @NotNull
    private String supplierId; // 공급업체 ID (FK, 거래처 테이블)
    @NotNull
    private String manufacturerId; // 제조업체 ID (FK, 거래처 테이블)
    @Unique
    @NotNull
    private final String equipmentName; // 설비 이름
    @NotNull
    private String equipmentType; // 설비 종류

    private String description; // 설명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String supplierId;
        private String manufacturerId;
        private String equipmentType;
        private String equipmentName;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder supplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Builder manufacturerId(String manufacturerId) {
            this.manufacturerId = manufacturerId;
            return this;
        }

        public Builder equipmentName(String equipmentName) {
            this.equipmentName = equipmentName;
            return this;
        }

        public Builder equipmentType(String equipmentType) {
            this.equipmentType = equipmentType;
            return this;
        }


        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ProductionEquipmentStandard build() {
            return new ProductionEquipmentStandard(this);
        }
    }



    // private Builder
    private ProductionEquipmentStandard(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.supplierId = builder.supplierId;
        this.manufacturerId = builder.manufacturerId;
        this.equipmentName = builder.equipmentName;
        this.equipmentType = builder.equipmentType;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    // tobuild()
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .supplierId(this.supplierId)
                .manufacturerId(this.manufacturerId)
                .equipmentName(this.equipmentName)
                .equipmentType(this.equipmentType)
                .description(this.description);
    }

    // getters


    public String getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public String getDescription() {
        return description;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "ProductionEquipmentStandard{" +
                "id='" + id + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", manufacturer='" + manufacturerId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
