package com.erp.system.logistics.model.warehouse_management_system.stock_management;

import com.erp.system.common.annotation.NotNull;

import java.math.BigInteger;
import java.time.LocalDate;

/**
 * 재고 테이블
 * 재고에 대한 정보가 있는 테이블
 */
public class Stock {
    @NotNull
    private final String id; // 재고 코드
    @NotNull
    private final String productId; // 제품 코드 참조
    @NotNull
    private final String locationId; // 위치 코드 참조
    @NotNull
    private BigInteger quantity; // 재고 수량
    private LocalDate lastUpdated; // 업데이트 날짜

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String productId;
        private String locationId;
        private BigInteger quantity;
        private LocalDate lastUpdated;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }

        public Builder quantity(BigInteger quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder lastUpdated(LocalDate lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }
    }

    private Stock(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.productId = builder.productId;
        this.locationId = builder.locationId;
        this.quantity = builder.quantity;
        this.lastUpdated = builder.lastUpdated;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .productId(this.productId)
                .locationId(this.locationId)
                .quantity(this.quantity)
                .lastUpdated(this.lastUpdated);
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getLocationId() {
        return locationId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", locationId='" + locationId + '\'' +
                ", quantity=" + quantity +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
