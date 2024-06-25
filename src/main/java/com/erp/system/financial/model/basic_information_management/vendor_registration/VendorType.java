package com.erp.system.financial.model.basic_information_management.vendor_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.util.UUID;

/**
 * 거래처 유형 테이블
 * 거래처의 데이터 저장 테이블
 */

public class VendorType {
    @NotNull
    private final String id; // 거래처 유형의 고유 식별자

    @NotNull
    private String category; // 구분(매입,매출 동시)

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String category;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public VendorType build() {
            return new VendorType(this);
        }
    }// end of Builder

    private VendorType(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.category = builder.category;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .category(this.category);
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}


