package com.erp.system.financial.model.basic_information_management.voucher_registration;

import java.util.UUID;

/**
 * 계정과목 테이블
 * 계정과목 데이터 테이블
 */
public class Account {
    private final String id; // 계정 과목의 고유 식별자
    private final String code; // 계정과목 코드

    private String name; // 계정과목명
    private String reference; // 참고 사항

    public static class Builder {
        private final String id;
        private final String code;

        private String name;
        private String reference;

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }//end of Builder

    private Account(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
        this.reference = builder.reference;
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

    public String getReference() {
        return reference;
    }
}
