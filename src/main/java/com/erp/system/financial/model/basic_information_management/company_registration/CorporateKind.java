package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.util.UUID;

/**
 * 법인종류별 구분 테이블
 * 법인종류별 구분 데이터 테이블
 * 
 */
public class CorporateKind {
    @NotNull
    private final String id; // 고유 식별자

    @NotNull
    private String kind; // 법인종류
    private String description; // 법인종류 설명

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String kind;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
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
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.kind = builder.kind;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .kind(this.kind)
                .description(this.description);
    }

    public String getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getDescription() {
        return description;
    }
}