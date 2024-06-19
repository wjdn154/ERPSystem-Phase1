package com.erp.system.financial.model.basic_information_management.voucher_registration;

import java.util.UUID;

/**
 * 전표 타입 테이블
 * 전표 타입 데이터를 저장하는 테이블
 */
public class VoucherType {
    private final String id; // 전표 타입의 고유 식별자
    private final String code; // 전표 타입 코드

    private String name; // 전표의 종류 (ex 출금, 입금, 차변, 대변)

    public static int idIndex = 1; // static 변수 추가

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

        public VoucherType build() {
            return new VoucherType(this);
        }
    }

    private VoucherType(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.name = builder.name;
    }

    // tobuild() 메서드 추가
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