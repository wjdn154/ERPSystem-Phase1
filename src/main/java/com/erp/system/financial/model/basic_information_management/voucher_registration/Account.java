package com.erp.system.financial.model.basic_information_management.voucher_registration;

import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;

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

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String code;

        private String name;
        private String reference;

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

        public Builder reference(String reference) {
            this.reference = reference;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    } // end of Builder

    private Account(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.name = builder.name;
        this.reference = builder.reference;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .name(this.name)
                .reference(this.reference);
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