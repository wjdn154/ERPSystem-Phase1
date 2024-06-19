package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 법인구분 테이블
 * 법인구분 데이터 테이블
 */
public class CorporateType {
    private final String id; // 고유 식별자
    private final String code; // 법인구분 코드

    private String type; // 법인구분
    private String description; // 법인구분 설명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;

        private String type;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public CorporateType build() {
            return new CorporateType(this);
        }
    } // end of Builder

    private CorporateType(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.type = builder.type;
        this.description = builder.description;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .type(this.type)
                .description(this.description);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}



