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
    public enum ProductionType { MASS, JOB, CUSTOM };

    @Unique
    @NotNull
    private final String id; // 오더코드
    @NotNull
    private String name; // 오더명
    @NotNull
    private ProductionType productionType; // 생산유형
    private boolean isActive; // 사용 여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String name;
        private ProductionType productionType;
        private boolean isActive;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder productionType(ProductionType productionType) {
            this.productionType = productionType;
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
        this.productionType = builder.productionType;
        this.isActive = builder.isActive;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);

    }

    // tobuild()
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .productionType(this.productionType)
                .isActive(this.isActive);
    }

    // getters

    public String getId() {
        return id;
    }

    public String getOrderTypeName() {
        return name;
    }

    public ProductionType getProductionType() {
        return productionType;
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
                ", productionType='" + productionType +
                ", isActive=" + isActive +
                '}';
    }
}
