package com.erp.system.financial.model.basic_information_management.vendor_registration;

import java.util.UUID;

/**
 * 거래처 유형 테이블
 * 거래처의 데이터 저장 테이블
 */

public class VendorType {
    private final String id; // 거래처 유형의 고유 식별자
    private final String code; // 거래처 유형 코드

    private String category; // 구분(매입,매출 동시)

    public static class Builder {
        private final String id;
        private final String code;

        private String category;

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public VendorType build() {
            return new VendorType(this);
        }
    }// end of Builder

    private VendorType(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.category = builder.category;
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
}


