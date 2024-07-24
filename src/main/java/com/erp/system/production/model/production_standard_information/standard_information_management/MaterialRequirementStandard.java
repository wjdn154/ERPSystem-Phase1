package com.erp.system.production.model.production_standard_information.standard_information_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
    자재소요량기준 테이블
* */

@EnumMapping
public class MaterialRequirementStandard {
    public enum Unit { KG, L, PCS, EA, SET }; // 단위 (예: kg, L, pcs)

    @NotNull
    @Unique
    private final String id; // PK
    @Unique
    @NotNull
    private final String materialId; // 자재 ID (FK, 생산 내 자재 테이블 참조)
    @NotNull
    private final String productId; // 제품 ID (FK, 물류 제품 테이블 참조)
    @NotNull
    private final String warehouseId; // 창고 ID (FK, 물류 창고 테이블 참조)
    @NotNull
    private final String supplierId; // 공급업체 ID (FK, 물류 거래처 테이블 참조)

    private Unit unit; // 자재 단위 (예: kg, L, pcs)
    @NotNull
    private final BigDecimal requiredQuantity; // 필요 수량
    private final String description; // 설명
    @NotNull
    private final LocalDate orderDate; // 주문 날짜
    @NotNull
    private final int leadTime; // 조달 소요 시간(분단위)
    @NotNull
    private final BigDecimal costPerUnit; // 단위당 비용

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String materialId;
        private String productId;
        private String warehouseId;
        private String supplierId;
        private Unit unit;
        private BigDecimal requiredQuantity;
        private String description;
        private LocalDate orderDate;
        private int leadTime;
        private BigDecimal costPerUnit;


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder materialId(String materialId) {
            this.materialId = materialId;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder warehouseId(String warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        public Builder unit(Unit unit) {
            this.unit = unit;
            return this;
        }

        public Builder requiredQuantity(BigDecimal requiredQuantity) {
            this.requiredQuantity = requiredQuantity;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder leadTime(int leadTime) {
            this.leadTime = leadTime;
            return this;
        }

        public Builder costPerUnit(BigDecimal costPerUnit) {
            this.costPerUnit = costPerUnit;
            return this;
        }

        public Builder supplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public MaterialRequirementStandard build() {
            return new MaterialRequirementStandard(this);
        }
    } // end of Builder

    // private Builder
    private MaterialRequirementStandard(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.materialId = builder.materialId;
        this.productId = builder.productId;
        this.warehouseId = builder.warehouseId;
        this.unit = builder.unit;
        this.requiredQuantity = builder.requiredQuantity;
        this.description = builder.description;
        this.orderDate = builder.orderDate;
        this.leadTime = builder.leadTime;
        this.costPerUnit = builder.costPerUnit;
        this.supplierId = builder.supplierId;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    // tobuild
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .materialId(this.materialId)
                .productId(this.productId)
                .warehouseId(this.warehouseId)
                .unit(this.unit)
                .requiredQuantity(this.requiredQuantity)
                .description(this.description)
                .orderDate(this.orderDate)
                .leadTime(this.leadTime)
                .costPerUnit(this.costPerUnit)
                .supplierId(this.supplierId);
    }

    // getters

    public String getId() {
        return id;
    }

    public String getMaterialId() {
        return materialId;
    }

    public String getProductId() {
        return productId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public Unit getUnit() {
        return unit;
    }

    public BigDecimal getRequiredQuantity() {
        return requiredQuantity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public int getLeadTime() {
        return leadTime;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    // toString()
    @Override
    public String toString() {
        return "MaterialRequirementStandard{" +
                "id='" + id + '\'' +
                ", materialId='" + materialId + '\'' +
                ", productId='" + productId + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                ", unit=" + unit +
                ", requiredQuantity=" + requiredQuantity +
                ", description='" + description + '\'' +
                ", orderDate=" + orderDate +
                ", leadTime=" + leadTime +
                ", costPerUnit=" + costPerUnit +
                ", supplierId='" + supplierId + '\'' +
                '}';
    }
}
