package com.erp.system.financial.model.basic_information_management.voucher_registration;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 계정과목 테이블
 * 계정과목 데이터 테이블
 */
public class Account {
    @NotNull
    private final String id; // 계정 과목의 고유 식별자

    @NotNull
    private String name; // 계정과목명
    @NotNull
    private String reference; // 참고 사항

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;

        private String name;
        private String reference;

        public Builder id(String id) {
            this.id = id;
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
        this.name = builder.name;
        this.reference = builder.reference;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .reference(this.reference);
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }
}