package com.erp.system.logistics.model.basic_information_registration.product_registration;

import com.erp.system.common.annotation.NotNull;

/**
 * 단가 테이블
 * 단가에 대한 정보가 있는 테이블
 */
public class UnitPrice {
    @NotNull
    private final String id; // 단가 고유 식별자

    @NotNull
    private double purchasePrice; // 입고 단가
    @NotNull
    private double salesPrice; // 출고 단가

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private double purchasePrice;
        private double salesPrice;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder purchasePrice(double purchasePrice) {
            this.purchasePrice = purchasePrice;
            return this;
        }

        public Builder salesPrice(double salesPrice) {
            this.salesPrice = salesPrice;
            return this;
        }

        public UnitPrice build() {
            return new UnitPrice(this);
        }
    }// end of Builder

    private UnitPrice(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.purchasePrice = builder.purchasePrice;
        this.salesPrice = builder.salesPrice;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .purchasePrice(this.purchasePrice)
                .salesPrice(this.salesPrice);
    }

    public String getId() {
        return id;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSalesPrice() {
        return salesPrice;
    }
}
