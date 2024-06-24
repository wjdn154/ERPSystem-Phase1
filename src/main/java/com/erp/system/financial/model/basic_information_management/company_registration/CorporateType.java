package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.util.UUID;

/**
 * 법인구분 테이블
 * 법인구분 데이터 테이블
 */
public class CorporateType {
    @NotNull
    private final String id; // 고유 식별자

    @NotNull
    private String type; // 법인구분
    private String description; // 법인구분 설명

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String type;
        private String description;

        public Builder id(String id) {
            this.id = id;
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
        this.type = builder.type;
        this.description = builder.description;
        NotNullValidator.safeValidateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .type(this.type)
                .description(this.description);
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}



