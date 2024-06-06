package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 세무 정보 테이블
 * 회사와 연결될 세무정보 데이터 테이블
 * 
 */
public class Taxes {
    private final String id; // 고유식별자
    private final String company_id; // 연결된 회사 ID
    private final String business_tax_office_id; // 사업장관할세무서 ID
    private final String headquarters_tax_office_id; // 본점관할세무서 ID
    private final String local_corporate_tax_category_id; // 지방세법인구분 ID
    private String local_income_tax_office; // 지방소득세납세지

    public Taxes(String local_corporate_tax_category_id, String headquarters_tax_office_id, String business_tax_office_id,
                 String company_id) {
        this.id = UUID.randomUUID().toString();
        this.local_corporate_tax_category_id = local_corporate_tax_category_id;
        this.headquarters_tax_office_id = headquarters_tax_office_id;
        this.business_tax_office_id = business_tax_office_id;
        this.company_id = company_id;
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

    public String getLocal_income_tax_office() {
        return local_income_tax_office;
    }

    public void setLocal_income_tax_office(String local_income_tax_office) {
        this.local_income_tax_office = local_income_tax_office;
    }
}
