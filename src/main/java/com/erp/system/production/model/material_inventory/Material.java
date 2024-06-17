package com.erp.system.production.model.material_inventory;

import java.time.LocalDateTime;
import java.util.UUID;

// 자재 정보
public class Material {

    private final String id; // 자재 ID
    private final String code; // 자재 CODE

    private String name; // 자재명
    private String description; // 자재 설명
    private String unit; // 단위 (kg, g, m, cm, pcs 등)
    private int quantity; // 재고량
    private LocalDateTime lastUpdated; // 마지막 업데이트 시간

    public Material(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
        this.description = builder.description;
        this.unit = builder.unit;
        this.quantity = builder.quantity;
        this.lastUpdated = builder.lastUpdated;
    }

    public static class Builder {
        private final String id; // 자재 ID
        private final String code; // 자재 CODE

        private String name; // 자재명
        private String description; // 자재 설명
        private String unit; // 단위 (kg, g, m, cm, pcs 등)
        private int quantity; // 재고량
        private LocalDateTime lastUpdated; // 마지막 업데이트 시간

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder lastUpdated(LocalDateTime lastUpdated) {
            this.lastUpdated = lastUpdated;
            return this;
        }

        public Material build() {
            return new Material(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
