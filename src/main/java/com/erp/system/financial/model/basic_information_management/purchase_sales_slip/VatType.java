package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 부가세유형 테이블
 * 매입매출전표 등록 할때 선택할 부가세 유형 테이블
 */
@EnumMapping
public class VatType {
    public enum Category {SALES,PURCHASE};

    @Unique
    @NotNull
    private final String id; // 고유 식별자

    @NotNull
    private Category category; // 매입 또는 매출 구분
    @NotNull
    private String name; // 항목명

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private Category category;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public VatType build() {
            return new VatType(this);
        }
    } // end of Builder

    private VatType(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.category = builder.category;
        this.name = builder.name;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .category(this.category)
                .name(this.name);
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "VatType{" +
                "id='" + id + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                '}';
    }
}