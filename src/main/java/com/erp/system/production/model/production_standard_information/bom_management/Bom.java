package com.erp.system.production.model.production_standard_information.bom_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
    제품과 부품 간의 관계를 관리하며, 각 부품의 수량, 손실율, 유효기간 등을 포함한
    BOM(Bill of Materials) 정보를 저장하는 테이블.

    BOM 정전개(Forward Explosion)와 역전개(Backward Explosion) 모두 수행 (별도 테이블X)
    - BOM 정전개 (Forward Explosion)
      특정 품목을 기준으로 그 하위 품목들(부품들)을 조회하는 방법
    - BOM 역전개 (Backward Explosion)
      특정 부품이 어느 상위 품목들(제품들)에 포함되는지를 조회하는 방법
 */

public class Bom {
    @NotNull
    @Unique
    private final String id; // PK
    @NotNull
    private final String parentProductId; // 부모 품목 ID (FK, Product.id)
    @NotNull
    private final String childProductId; // 자식 품목 ID (FK, Product.id)
    @NotNull
    private final String materialId; // 자재 ID (FK, Material.id)
    @NotNull
    private BigDecimal quantity; // 자재 수량
    @NotNull
    private final String priceId; // 단가 ID (FK, Price.id) - 추가된 필드
    private String description; // 설명
    private double lossRate; // LOSS(%): 손실율
    private boolean subcontractingType; // 사급구분: 자재(0) 또는 사급(1)
    private boolean outsourcingType; // 외주구분: 무상(0) 또는 유상(1)
    @NotNull
    private LocalDate startDate; // Bom 유효시작일
    @NotNull
    private LocalDate expiredDate; // Bom 유효종료일
    private boolean isActive; // 사용 여부
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String parentProductId;
        private String childProductId;
        private String materialId;
        private BigDecimal quantity;
        private String priceId;
        private String description;
        private double lossRate;
        private boolean subcontractingType;
        private boolean outsourcingType;
        private LocalDate startDate;
        private LocalDate expiredDate;
        private boolean isActive;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder parentProductId(String parentProductId) {
            this.parentProductId = parentProductId;
            return this;
        }

        public Builder childProductId(String childProductId) {
            this.childProductId = childProductId;
            return this;
        }

        public Builder materialId(String materialId) {
            this.materialId = materialId;
            return this;
        }

        public Builder quantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder priceId(String priceId) {
            this.priceId = priceId;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder lossRate(double lossRate) {
            this.lossRate = lossRate;
            return this;
        }

        public Builder subcontractingType(boolean subcontractingType) {
            this.subcontractingType = subcontractingType;
            return this;
        }

        public Builder outsourcingType(boolean outsourcingType) {
            this.outsourcingType = outsourcingType;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder expiredDate(LocalDate expiredDate) {
            this.expiredDate = expiredDate;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Bom build() {
            return new Bom(this);
        }
    }

    private Bom(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.parentProductId = builder.parentProductId;
        this.childProductId = builder.childProductId;
        this.materialId = builder.materialId;
        this.quantity = builder.quantity;
        this.priceId = builder.priceId;
        this.description = builder.description;
        this.lossRate = builder.lossRate;
        this.subcontractingType = builder.subcontractingType;
        this.outsourcingType = builder.outsourcingType;
        this.startDate = builder.startDate;
        this.expiredDate = builder.expiredDate;
        this.isActive = builder.isActive;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .parentProductId(this.parentProductId)
                .childProductId(this.childProductId)
                .materialId(this.materialId)
                .quantity(this.quantity)
                .priceId(this.priceId)
                .description(this.description)
                .lossRate(this.lossRate)
                .subcontractingType(this.subcontractingType)
                .outsourcingType(this.outsourcingType)
                .startDate(this.startDate)
                .expiredDate(this.expiredDate)
                .isActive(this.isActive)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getParentProductId() {
        return parentProductId;
    }

    public String getChildProductId() {
        return childProductId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getPriceId() { return priceId; }

    public double getLossRate() {
        return lossRate;
    }

    public boolean isSubcontractingType() {
        return subcontractingType;
    }

    public boolean isOutsourcingType() {
        return outsourcingType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getRemarks() {
        return remarks;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "Bom{" +
                "id='" + id + '\'' +
                ", parentProductId='" + parentProductId + '\'' +
                ", childProductId='" + childProductId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", quantity=" + quantity + '\'' +
                ", priceId=" + priceId + '\'' +
                ", description='" + description + '\'' +
                ", lossRate=" + lossRate + '\'' +
                ", subcontractingType=" + subcontractingType +
                ", outsourcingType=" + outsourcingType +
                ", startDate=" + startDate + '\'' +
                ", expiredDate=" + expiredDate + '\'' +
                ", isActive=" + isActive + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
