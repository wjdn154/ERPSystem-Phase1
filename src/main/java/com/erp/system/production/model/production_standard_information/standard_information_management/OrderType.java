package com.erp.system.production.model.production_standard_information.standard_information_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

/*
    오더형태 타입구분 테이블
* */

@EnumMapping
public class OrderType {
    public enum InboundType { RAW_MATERIAL, SEMI_FINISHED_PRODUCT, FINISHED_PRODUCT, REWORKED_PRODUCT };
    public enum OutsourcingPurchaseType { FULL_SERVICE, PARTIAL_SERVICE, LABOR_ONLY, MATERIAL_ONLY };
    public enum ProductionType { MASS, JOB, CUSTOM };
    public enum WorkType { DAY_SHIFT, NIGHT_SHIFT, ROTATING_SHIFT };

    @Unique
    @NotNull
    private final String id; // 오더형태코드
    @NotNull
    private String name; // 오더형태명
    @NotNull
    private InboundType inboundType; // // 입고 형태: 원자재 입고, 반제품 입고, 완제품 입고, 반품 입고, 재작업 입고
    @NotNull
    private OutsourcingPurchaseType outsourcingPurchaseType; // 공정외주매입 타입
    @NotNull
    private ProductionType productionType; // 생산유형
    @NotNull
    private WorkType workType; // 작업형태(교대)
    private boolean isActive; // 사용 여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String name;
        private InboundType inboundType;
        private OutsourcingPurchaseType outsourcingPurchaseType;
        private ProductionType productionType;
        private WorkType workType;
        private boolean isActive;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder inboundType(InboundType inboundType) {
            this.inboundType = inboundType;
            return this;
        }
        public Builder outsourcingPurchaseType(OutsourcingPurchaseType outsourcingPurchaseType) {
            this.outsourcingPurchaseType = outsourcingPurchaseType;
            return this;
        }
        public Builder productionType(ProductionType productionType) {
            this.productionType = productionType;
            return this;
        }
        public Builder workType(WorkType workType) {
            this.workType = workType;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public OrderType build() {
            return new OrderType(this);
        }
    } // end of Builder

    // private Builder
    private OrderType(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.inboundType = builder.inboundType;
        this.outsourcingPurchaseType = builder.outsourcingPurchaseType;
        this.productionType = builder.productionType;
        this.workType = builder.workType;
        this.isActive = builder.isActive;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);

    }

    // tobuild()
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .inboundType(this.inboundType)
                .outsourcingPurchaseType(this.outsourcingPurchaseType)
                .productionType(this.productionType)
                .workType(this.workType)
                .isActive(this.isActive);
    }

    // getters

    public String getId() {
        return id;
    }

    public String getOrderTypeName() {
        return name;
    }

    public InboundType getInboundType() {
        return inboundType;
    }

    public OutsourcingPurchaseType getOutsourcingPurchaseType() {
        return outsourcingPurchaseType;
    }

    public ProductionType getProductionType() {
        return productionType;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public boolean isActive() {
        return isActive;
    }

    public static int getIdIndex() {
        return idIndex;
    }


    @Override
    // toString()
    public String toString() {
        return "OrderType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", inboundType='" + inboundType +
                ", outsourcingPurchaseType='" + outsourcingPurchaseType +
                ", productionType='" + productionType +
                ", workType='" + workType +
                ", isActive=" + isActive +
                '}';
    }
}
