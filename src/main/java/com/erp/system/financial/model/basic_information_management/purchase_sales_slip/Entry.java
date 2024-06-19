package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import java.util.UUID;

/**
 * 분개 테이블
 * 매입매출전표 등록 할때 선택할 분개 정보 테이블
 */
public class Entry {
    private final String id; // 고유 식별자
    private final String code; // 분개 코드

    private String name; // 분개 이름

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Entry build() {
            return new Entry(this);
        }
    }// end of Builder

    private Entry(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.name = builder.name;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .name(this.name);
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
}