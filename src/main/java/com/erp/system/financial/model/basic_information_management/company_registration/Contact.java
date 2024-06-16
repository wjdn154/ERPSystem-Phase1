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
    private final String code; // 연락처 코드

    private String business_phone; // 사업장 전화번호
    private String fax; // 팩스번호

    public static class Builder {
        private final String id;
        private final String company_id;
        private final String code;

        private String business_phone;
        private String fax;

        public Builder(String company_id, String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.company_id = company_id;
        }

        public Builder business_phone(String business_phone) {
            this.business_phone = business_phone;
            return this;
        }

        public Builder fax(String fax) {
            this.fax = fax;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }// end of builder

    private Contact(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.company_id = builder.company_id;
        this.business_phone = builder.business_phone;
        this.fax = builder.fax;
    }

    public String getId() {
        return id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getBusiness_phone() {
        return business_phone;
    }

    public String getFax() {
        return fax;
    }
}
