package com.erp.system.production.model.production_standard_information.bom_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;

/**
 * Bom과 Material 매핑 테이블
 */

public class BomMaterial {
    @Unique
    @NotNull
    private final String id; // BomMaterial PK
    @NotNull
    private final String bomId; // FK, BOM 코드 Bom.id
    @NotNull
    private final String materialId; // FK, 자재 코드 Material.id
    @NotNull
    private BigDecimal quantity; // 자재 수량

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String bomId;
        private String materialId;
        private BigDecimal quantity;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder bomId(String bomId) {
            this.bomId = bomId;
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

        public BomMaterial build() {
            return new BomMaterial(this);
        }
    }

    private BomMaterial(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.bomId = builder.bomId;
        this.materialId = builder.materialId;
        this.quantity = builder.quantity;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);

    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .bomId(this.bomId)
                .materialId(this.materialId)
                .quantity(this.quantity);
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getBomId() {
        return bomId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "BomMaterial{" +
                "id='" + id + '\'' +
                ", bomId='" + bomId + '\'' +
                ", materialId='" + materialId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
