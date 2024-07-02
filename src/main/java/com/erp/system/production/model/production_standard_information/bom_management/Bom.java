package com.erp.system.production.model.production_standard_information.bom_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

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
    private final String parentItemId; // 부모 품목 ID (FK, Item.id)
    @NotNull
    private final String childItemId; // 자식 품목 ID (FK, Item.id)
    @NotNull
    private final String materialId; // 자재 ID (FK, Material.id)
    @NotNull
    private BigDecimal quantity; // 자재 수량
    @NotNull
    private final String routingId; // 공정 경로 ID (FK, Routing.id)
    private String description; // 설명
    private double lossRate; // LOSS(%): 손실율
    private boolean subcontractingType; // 사급구분: 자재(0) 또는 사급(1)
    private boolean outsourcingType; // 외주구분: 무상 또는 유상
    @NotNull
    private LocalDate startDate; // Bom 유효시작일
    @NotNull
    private LocalDate expiredDate; // Bom 유효종료일
    private boolean isActive; // 사용 여부
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String parentItemId;
        private String childItemId;
        private String materialId;
        private BigDecimal quantity;
        private String routingId;
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

        public Builder parentItemId(String parentItemId) {
            this.parentItemId = parentItemId;
            return this;
        }

        public Builder childItemId(String childItemId) {
            this.childItemId = childItemId;
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

        public Builder routingId(String routingId) {
            this.routingId = routingId;
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
        this.parentItemId = builder.parentItemId;
        this.childItemId = builder.childItemId;
        this.materialId = builder.materialId;
        this.quantity = builder.quantity;
        this.routingId = builder.routingId;
        this.description = builder.description;
        this.lossRate = builder.lossRate;
        this.subcontractingType = builder.subcontractingType;
        this.outsourcingType = builder.outsourcingType;
        this.startDate = builder.startDate;
        this.expiredDate = builder.expiredDate;
        this.isActive = builder.isActive;
        this.remarks = builder.remarks;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .parentItemId(this.parentItemId)
                .childItemId(this.childItemId)
                .materialId(this.materialId)
                .quantity(this.quantity)
                .routingId(this.routingId)
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

    public String getParentItemId() {
        return parentItemId;
    }

    public String getChildItemId() {
        return childItemId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public String getRoutingId() {
        return routingId;
    }

    public String getDescription() {
        return description;
    }

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
                ", parentItemId='" + parentItemId + '\'' +
                ", childItemId='" + childItemId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", lossRate=" + lossRate +
                ", subcontractingType=" + subcontractingType +
                ", outsourcingType=" + outsourcingType +
                ", startDate=" + startDate +
                ", expiredDate=" + expiredDate +
                ", isActive=" + isActive +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
