package com.erp.system.financial.model.basic_information_management.vendor_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

public class VendorCategory {
    @Unique
    @NotNull
    private final String id; // 거래처 업태종류 고유 식별자
    @NotNull
    private String category; // 업종형태

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

        public VendorCategory build() {
            return new VendorCategory(this);
        }
    } // end of Builder

    private VendorCategory(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.category = builder.category;
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

    @Override
    public String toString() {
        return "VendorCategory{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
