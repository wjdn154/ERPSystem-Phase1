package com.erp.system.logistics.model.basic_information_registration.product_registration;

import com.erp.system.common.annotation.NotNull;

/**
 * 제품 그룹 테이블
 * 제품 그룹에 대한 정보가 있는 테이블
 */
public class ProductGroup {
    @NotNull
    private final String id; // 제품그룹 고유 식별자

    @NotNull
    private String name; // 제품 그룹 명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ProductGroup build() {
            return new ProductGroup(this);
        }
    }// end of Builder

    private ProductGroup(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}