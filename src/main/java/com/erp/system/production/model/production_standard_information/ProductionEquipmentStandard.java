package com.erp.system.production.model.production_standard_information;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.time.Year;

public class ProductionEquipmentStandard {
    @NotNull
    @Unique
    private final String id; // PK
    @Unique
    @NotNull
    private final String equipmentName; // 설비 이름
    @NotNull
    private String equipmentType; // 설비 종류
    @NotNull
    private String supplierId; // 공급업체 ID (FK, 거래처 테이블)
    @NotNull
    private String manufacturerId; // 제조업체 ID (FK, 거래처 테이블)
    @NotNull
    @Unique
    private final String modelNumber; // 모델 번호
    @NotNull
    private Year purchaseYear; // 구입 연도
    private String description; // 설명
    private boolean isOperational; // 작동 여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String equipmentName;
        private String equipmentType;
        private String supplierId;
        private String manufacturerId;
        private String modelNumber;
        private Year purchaseYear;
        private String description;
        private boolean isOperational;

        public Builder id(String id) {
            this.id = id;
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

        public Builder supplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Builder manufacturerId(String manufacturerId) {
            this.manufacturerId = manufacturerId;
            return this;
        }

        public Builder modelNumber(String modelNumber) {
            this.modelNumber = modelNumber;
            return this;
        }

        public Builder purchaseYear(Year purchaseYear) {
            this.purchaseYear = purchaseYear;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder isOperational(boolean isOperational) {
            this.isOperational = isOperational;
            return this;
        }

        public ProductionEquipmentStandard build() {
            return new ProductionEquipmentStandard(this);
        }
    }



    // private Builder
    private ProductionEquipmentStandard(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.equipmentName = builder.equipmentName;
        this.equipmentType = builder.equipmentType;
        this.supplierId = builder.supplierId;
        this.manufacturerId = builder.manufacturerId;
        this.modelNumber = builder.modelNumber;
        this.purchaseYear = builder.purchaseYear;
        this.description = builder.description;
        this.isOperational = builder.isOperational;
    }

    // tobuild()
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .equipmentName(this.equipmentName)
                .equipmentType(this.equipmentType)
                .supplierId(this.supplierId)
                .manufacturerId(this.manufacturerId)
                .modelNumber(this.modelNumber)
                .purchaseYear(this.purchaseYear)
                .description(this.description)
                .isOperational(this.isOperational);
    }

    // getters


    public String getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public Year getPurchaseYear() {
        return purchaseYear;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOperational() {
        return isOperational;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    // toString 메서드
    @Override
    public String toString() {
        return "ProductionEquipmentStandard{" +
                "id='" + id + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentType='" + equipmentType + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", manufacturer='" + manufacturerId + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", purchaseYear=" + purchaseYear +
                ", description='" + description + '\'' +
                ", isOperational=" + isOperational +
                '}';
    }
}
