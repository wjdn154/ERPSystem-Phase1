package com.erp.system.production.model.production_plan_management.material_requirement_planning;

import java.time.LocalDate;
import java.util.UUID;

// 자재소요계획(MRP, Material Requirement Planning) : 생산계획에 따라 필요한 자재의 수량과 종류를 결정하고, 이를 바탕으로 자재 관리
public class Mrp {

    private final String id; // MRP ID
    private final String code; // MRP CODE
    private final String productionPlanId; // 생산계획 ID

    private String materialId; // 자재 ID
    private int requiredQuantity; // 소요 자재 수량
    private LocalDate date; // MRP 생성 일자

    private Mrp(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.productionPlanId = builder.productionPlanId;
        this.materialId = builder.materialId;
        this.requiredQuantity = builder.requiredQuantity;
        this.date = builder.date;
    }

    public static class Builder {
        private final String id; // MRP ID
        private final String code; // MRP CODE
        private final String productionPlanId; // 생산계획 ID

        private String materialId; // 자재 ID
        private int requiredQuantity; // 소요 자재 수량
        private LocalDate date; // MRP 생성 일자

        public Builder(String code, String productionPlanId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.productionPlanId = productionPlanId;
        }

        public Builder materialId(String materialId) {
            this.materialId = materialId;
            return this;
        }

        public Builder requiredQuantity(int requiredQuantity) {
            this.requiredQuantity = requiredQuantity;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Mrp build() {
            return new Mrp(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getProductionPlanId() {
        return productionPlanId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public LocalDate getDate() {
        return date;
    }
}
