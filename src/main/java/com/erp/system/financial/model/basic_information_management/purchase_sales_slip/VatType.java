package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import java.util.UUID;

/**
 * 부가세유형 테이블
 * 매입매출전표 등록 할때 선택할 부가세 유형 테이블
 */
public class VatType {
    private final String id; // 고유 식별자
    private final String code; // 부가세유형 코드

    private String category; // 매입 또는 매출 구분
    private String name; // 항목명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;

        private String category;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public VatType build() {
            return new VatType(this);
        }
    } // end of Builder

    private VatType(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.category = builder.category;
        this.name = builder.name;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .category(this.category)
                .name(this.name);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}