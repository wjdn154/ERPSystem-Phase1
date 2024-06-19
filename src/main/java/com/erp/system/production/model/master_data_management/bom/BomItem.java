package com.erp.system.production.model.master_data_management.bom;

import java.util.UUID;

/*
* 자재명세표(BOM)에 포함된 자재 항목
* */
public class BomItem {
    private final String id; // Bom 항목 ID
    private final String code; // Bom 항목 CODE
    private final String bomId; // FK, Bom ID
    private final String materialId; // FK, 자재 ID

    private int quantity; // 자재 수량

    // BomItem 생성자: Builder 객체를 받아서 초기화
    private BomItem(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.bomId = builder.bomId;
        this.materialId = builder.materialId;
        this.quantity = builder.quantity;
    }

    public static class Builder {
        private final String id; // Bom 항목 ID
        private final String code; // Bom 항목 CODE
        private final String bomId; // FK, Bom ID
        private final String materialId; // FK, 자재 ID

        private int quantity; // 자재 수량

        // Builder 생성자: 필수 속성 초기화
        public Builder(String code, String bomId, String materialId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.bomId = bomId;
            this.materialId = materialId;
        }

        // quantity 설정 메서드
        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        // BomItem 객체 생성 메서드
        public BomItem build() {
            return new BomItem(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getBomId() {
        return bomId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public int getQuantity() {
        return quantity;
    }
}
