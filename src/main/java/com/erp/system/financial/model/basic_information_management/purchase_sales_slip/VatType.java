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
    private String name ; // 항목명

    public static class Builder {
        private final String id;
        private final String code;

        private String category;
        private String name ;

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
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
    }// end of Builder

    public VatType(Builder builder) {
        this.code = builder.code;
        this.id = builder.id;
        this.category = builder.category;
        this.name = builder.name;
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