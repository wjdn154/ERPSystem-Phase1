package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.util.UUID;

/**
 * 주소 정보 테이블
 * 회사등록 시 필요한 주소 데이터 테이블
 *
 */
public class Address {
    @NotNull
    private final String id; // 고유식별자
    @NotNull
    private final String companyId; // 연결된 회사 ID

    @NotNull
    private String address; // 사업장주소
    @NotNull
    private String headquartersAddress; // 본점주소
    @NotNull
    private String businessPlaceId; // 사업장 동 코드 (동 ex 대연동)
    @NotNull
    private String headquartersId; // 본점 동 코드

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String companyId;

        private String address;
        private String headquartersAddress;
        private String businessPlaceId;
        private String headquartersId;

        public Builder id(String id) {
            this.id = id;
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

        public Builder businessPlaceId(String businessPlaceId) {
            this.businessPlaceId = businessPlaceId;
            return this;
        }

        public Builder headquartersId(String headquartersId) {
            this.headquartersId = headquartersId;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    private Address(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.companyId = builder.companyId;
        this.address = builder.address;
        this.headquartersAddress = builder.headquartersAddress;
        this.businessPlaceId = builder.businessPlaceId;
        this.headquartersId = builder.headquartersId;
        NotNullValidator.safeValidateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .companyId(this.companyId)
                .address(this.address)
                .headquartersAddress(this.headquartersAddress)
                .businessPlaceId(this.businessPlaceId)
                .headquartersId(this.headquartersId);
    }

    public String getId() {
        return id;
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

    public String getBusinessPlaceId() {
        return businessPlaceId;
    }

    public String getHeadquartersId() {
        return headquartersId;
    }
}
