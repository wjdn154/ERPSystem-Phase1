package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 주소 정보 테이블
 * 회사등록 시 필요한 주소 데이터 테이블
 *
 */
public class Address {
    private final String id; // 고유식별자
    private final String code; // 주소 코드번호
    private final String company_id; // 연결된 회사 ID

    private String address; // 사업장주소
    private String headquarters_address; // 본점주소
    private String business_place_code; // 사업장 동 코드 (동 ex 대연동)
    private String headquarters_code; // 본점 동 코드

    public static class Builder {
        private final String id; // 고유식별자
        private final String company_id; // 연결된 회사 ID
        private final String code; // 주소 코드번호

        private String address;
        private String headquarters_address;
        private String business_place_code;
        private String headquarters_code;

        public Builder(String code, String company_id) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.company_id = company_id;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder headquarters_address(String headquarters_address) {
            this.headquarters_address = headquarters_address;
            return this;
        }

        public Builder business_place_code(String business_place_code) {
            this.business_place_code = business_place_code;
            return this;
        }

        public Builder headquarters_code(String headquarters_code) {
            this.headquarters_code = headquarters_code;
            return this;
        }

        public Address build() {
            return new Address(this);
        }


    } // end of builder

    private Address(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.company_id = builder.company_id;
        this.address = builder.address;
        this.headquarters_address = builder.headquarters_address;
        this.business_place_code = builder.business_place_code;
        this.headquarters_code = builder.headquarters_code;
    }

    public String getId() {
        return id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public String getHeadquarters_address() {
        return headquarters_address;
    }

    public String getBusiness_place_code() {
        return business_place_code;
    }

    public String getHeadquarters_code() {
        return headquarters_code;
    }
}
