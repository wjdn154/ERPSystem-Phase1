package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import java.util.UUID;

/**
 * 분개 테이블
 * 매입매출전표 등록 할때 선택할 분개 정보 테이블
 */
public class Entry {
    private final String id; // 고유 식별자
    private final String code; // 분개 코드
    private final String name; // 분개 이름

    public static class Builder {
        private final String id;
        private final String code;
        private String name;

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        private Builder(String id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Entry build() {
            return new Entry(this);
        }

    } // end of Builder

    private Entry(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Builder toBuilder() {
        return new Builder(id, code, name);
    }
}