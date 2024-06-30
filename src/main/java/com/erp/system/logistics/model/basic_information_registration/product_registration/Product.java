package com.erp.system.logistics.model.basic_information_registration.product_registration;

import com.erp.system.common.annotation.NotNull;

/**
 * 제품 테이블
 * 제품에 대한 정보가 있는 테이블 - 제품 등록 시 사용
 */
public class Product {
    public enum ProductType {RAW_MATERIAL, OTHER_MATERIAL, FINISHED_GOOD,
        SEMI_FINISHED_GOOD, MERCHANDISE, INTANGIBLE_MERCHANDISE}

    @NotNull
    private final String id; // 제품의 고유 식별자

    @NotNull
    private String groupId; // 제품 그룹 코드 참조
    @NotNull
    private String unitPriceId; // 단가 코드 참조
    @NotNull
    private String name; // 제품명
    @NotNull
    private String standard; // 규격
    @NotNull
    private ProductType productType; // 제품구분 (Enum)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String groupId;
        private String unitPriceId;
        private String name;
        private String standard;
        private ProductType productType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder unitPriceId(String unitPriceId) {
            this.unitPriceId = unitPriceId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder standard(String standard) {
            this.standard = standard;
            return this;
        }

        public Builder productType(ProductType productType) {
            this.productType = productType;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }// end of Builder

    private Product(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.groupId = builder.groupId;
        this.unitPriceId = builder.unitPriceId;
        this.name = builder.name;
        this.standard = builder.standard;
        this.productType = builder.productType;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .groupId(this.groupId)
                .unitPriceId(this.unitPriceId)
                .name(this.name)
                .standard(this.standard)
                .productType(this.productType);
    }

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getUnitPriceId() {
        return unitPriceId;
    }

    public String getName() {
        return name;
    }

    public String getStandard() {
        return standard;
    }

    public ProductType getProductType() {
        return productType;
    }
}
