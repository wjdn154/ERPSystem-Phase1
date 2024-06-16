package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 세무 정보 테이블
 * 회사와 연결될 세무정보 데이터 테이블
 * 
 */
public class Tax {
    private final String id; // 고유식별자
    private final String company_id; // 연결된 회사 ID
    private final String business_tax_office_id; // 사업장관할세무서 ID
    private final String headquarters_tax_office_id; // 본점관할세무서 ID
    private final String local_corporate_tax_category_id; // 지방세법인구분 ID
    private final String code; // 세무 정보 코드

    private String local_income_tax_office; // 지방소득세납세지

    public static class Builder {
        private final String id;
        private final String company_id;
        private final String business_tax_office_id;
        private final String headquarters_tax_office_id;
        private final String local_corporate_tax_category_id;
        private final String code;

        private String local_income_tax_office;

        public Builder(String id, String company_id, String business_tax_office_id, String headquarters_tax_office_id,
                       String local_corporate_tax_category_id, String code) {
            this.id = UUID.randomUUID().toString();
            this.company_id = company_id;
            this.business_tax_office_id = business_tax_office_id;
            this.headquarters_tax_office_id = headquarters_tax_office_id;
            this.local_corporate_tax_category_id = local_corporate_tax_category_id;
            this.code = code;
        }

        public Builder local_income_tax_office(String local_income_tax_office) {
            this.local_income_tax_office = local_income_tax_office;
            return this;
        }

        public Tax build() {
            return new Tax(this);
        }
    }// end of Builder

    private Tax(Builder builder) {
        this.id = builder.id;
        this.company_id = builder.company_id;
        this.business_tax_office_id = builder.business_tax_office_id;
        this.headquarters_tax_office_id = builder.headquarters_tax_office_id;
        this.local_corporate_tax_category_id = builder.local_corporate_tax_category_id;
        this.code = builder.code;
        this.local_income_tax_office = builder.local_income_tax_office;
    }

    public String getId() {
        return id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getBusiness_tax_office_id() {
        return business_tax_office_id;
    }

    public String getHeadquarters_tax_office_id() {
        return headquarters_tax_office_id;
    }

    public String getLocal_corporate_tax_category_id() {
        return local_corporate_tax_category_id;
    }

    public String getCode() {
        return code;
    }

    public String getLocal_income_tax_office() {
        return local_income_tax_office;
    }
}
