package com.erp.system.production.model.process_management;

import java.time.LocalDate;
import java.util.UUID;

// 생산입고 관리: 제품 생산 후, 완제품이 창고나 지정 저장 장소에 입고 과정 관리 (제품 실제 재고 관리 시작 시점)
public class ProductionStock {

    private final String id; // 생산입고 ID
    private final String productionRecordId; // 생산실적 ID
    private final String productId; // 제품 ID

    private int quantity; // 입고 수량
    private LocalDate date; // 입고 일자

    private ProductionStock(Builder builder) {
        this.id = builder.id;
        this.productionRecordId = builder.productionRecordId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.date = builder.date;
    }

    public static class Builder {
        private final String id; // 생산입고 ID
        private final String productionRecordId; // 생산실적 ID
        private final String productId; // 제품 ID

        private int quantity; // 입고 수량
        private LocalDate date; // 입고 일자

        public Builder(String productionRecordId, String productId) {
            this.id = UUID.randomUUID().toString();
            this.productionRecordId = productionRecordId;
            this.productId = productId;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public ProductionStock build() {
            return new ProductionStock(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getProductionRecordId() {
        return productionRecordId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }
}
