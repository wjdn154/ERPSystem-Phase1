package com.erp.system.logistics.model.basic_information_registration.vendor_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 거래처 유형 테이블
 * 거래처 유형에 대한 정보가 있는 테이블
 */
public class VendorTypes {
    @NotNull
    private final String id; // 거래처 유형 고유 식별자

    @NotNull
    private String vendorTypeName; // 거래처 유형명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String vendorTypeName;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder vendorTypeName(String vendorTypeName) {
            this.vendorTypeName = vendorTypeName;
            return this;
        }

        public VendorTypes build() {
            return new VendorTypes(this);
        }
    }// end of Builder

    private VendorTypes(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.vendorTypeName = builder.vendorTypeName;
        NotNullValidator.safeValidateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .vendorTypeName(this.vendorTypeName);
    }

    public String getId() {
        return id;
    }

    public String getVendorTypeName() {
        return vendorTypeName;
    }
}
