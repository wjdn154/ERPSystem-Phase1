package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 연락처 정보 테이블
 * 회사 등록 시 필요한 연락처 데이터 테이블
 *
 */
public class Contact {
    private final String id; // 고유식별자
    private final String company_id; // 연결된 회사 ID
    private String Business_phone; // 사업장 전화번호
    private String fax; // 팩스번호

    public Contact(String company_id) {
        this.id = UUID.randomUUID().toString();
        this.company_id = company_id;
    }

    public String getId() {
        return id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getBusiness_phone() {
        return Business_phone;
    }

    public void setBusiness_phone(String business_phone) {
        Business_phone = business_phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
