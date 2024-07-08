package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

/**
 * 회사 및 거래처 등록의 업종형태
 */
public class BusinessType {
    @NotNull
    private final String id; // 고유 식별자
    @NotNull
    private final String name; // 회사의 업종형태

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public BusinessType build() {
            return new BusinessType(this);
        }
    } // end of Builder

    private BusinessType(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BusinessType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
