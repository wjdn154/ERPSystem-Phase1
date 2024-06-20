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
    private final String companyId; // 연결된 회사 ID

    private String address; // 사업장주소
    private String headquartersAddress; // 본점주소
    private String businessPlaceCode; // 사업장 동 코드 (동 ex 대연동)
    private String headquartersCode; // 본점 동 코드

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;
        private String companyId;

        private String address;
        private String headquartersAddress;
        private String businessPlaceCode;
        private String headquartersCode;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder companyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder headquartersAddress(String headquartersAddress) {
            this.headquartersAddress = headquartersAddress;
            return this;
        }

        public Builder businessPlaceCode(String businessPlaceCode) {
            this.businessPlaceCode = businessPlaceCode;
            return this;
        }

        public Builder headquartersCode(String headquartersCode) {
            this.headquartersCode = headquartersCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    private Address(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.companyId = builder.companyId;
        this.address = builder.address;
        this.headquartersAddress = builder.headquartersAddress;
        this.businessPlaceCode = builder.businessPlaceCode;
        this.headquartersCode = builder.headquartersCode;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .companyId(this.companyId)
                .address(this.address)
                .headquartersAddress(this.headquartersAddress)
                .businessPlaceCode(this.businessPlaceCode)
                .headquartersCode(this.headquartersCode);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getAddress() {
        return address;
    }

    public String getHeadquartersAddress() {
        return headquartersAddress;
    }

    public String getBusinessPlaceCode() {
        return businessPlaceCode;
    }

    public String getHeadquartersCode() {
        return headquartersCode;
    }
}
