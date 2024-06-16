package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 법인종류 테이블
 * 법인종류 데이터 테이블
 * 
 */
public class CorporateKind {
    private final String id; // 고유 실벽자
    private final String code; // 법인종류 코드

    private String kind; // 법인종류
    private String description; // 법인종류 설명

    public static class Builder {
        private final String id;
        private final String code;

        private String kind;
        private String description;

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        public Builder kind(String kind) {
            this.kind = kind;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public CorporateKind build() {
            return new CorporateKind(this);
        }
    } // end of Builder

    private CorporateKind(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.kind = builder.kind;
        this.description = builder.description;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getKind() {
        return kind;
    }

    public String getDescription() {
        return description;
    }
}
