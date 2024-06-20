package com.erp.system.production.model.material_inventory;

import java.time.LocalDateTime;
import java.util.UUID;

// 자재 재고 관리

import java.time.LocalDateTime;

public class MaterialInventory {

    private final String id; // 재고 ID
    private final String code; // 재고 CODE
    private final String materialId; // FK, 자재 ID

    private int quantity; // 재고 수량
    private LocalDateTime updated; // 마지막 업데이트 시간

    public MaterialInventory(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.materialId = builder.materialId;
        this.quantity = builder.quantity;
        this.updated = builder.updated;
    }

    public static class Builder {
        private final String id; // 재고 ID
        private final String code; // 재고 CODE
        private final String materialId; // 자재 ID

        private int quantity; // 재고 수량
        private LocalDateTime updated; // 마지막 업데이트 시간

        public Builder(String code, String materialId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.materialId = materialId;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder updated(LocalDateTime updated) {
            this.updated = updated;
            return this;
        }

        public MaterialInventory build() {
            return new MaterialInventory(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getMaterialId() {
        return materialId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}