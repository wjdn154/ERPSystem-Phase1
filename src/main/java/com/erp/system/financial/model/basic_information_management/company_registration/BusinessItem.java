package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;

/**
 * 회사 및 거래처 등록의 업체종목
 */
public class BusinessItem {
    @NotNull
    private final String id; // 고유 식별자
    @NotNull
    private final String businessTypeId; // 해당 회사의 업종형태 id (종목의 상위 카테고리)
    @NotNull
    private final String name; // 종목이름

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String businessTypeId;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder businessTypeId(String businessTypeId) {
            this.businessTypeId = businessTypeId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public BusinessItem build(){
            return new BusinessItem(this);
        }
    } // end of Builder

    private BusinessItem(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.businessTypeId = builder.businessTypeId;
        this.name = builder.name;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .businessTypeId(this.businessTypeId)
                .name(this.name);
    }

    public String getId() {
        return id;
    }

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BusinessItem{" +
                "id='" + id + '\'' +
                ", businessTypeId='" + businessTypeId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
