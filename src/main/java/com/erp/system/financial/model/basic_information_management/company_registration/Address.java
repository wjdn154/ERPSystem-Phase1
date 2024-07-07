package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 주소 정보 테이블
 * 회사등록 시 필요한 주소 데이터 테이블
 */
public class Address {
    @Unique
    @NotNull
    private final String id; // 고유식별자

    @NotNull
    private String businessAddress; // 사업장주소
    @NotNull
    private String businessPostalCode; // 사업장 우편번호
    @NotNull
    private String businessPlace; // 사업장 동 (동 ex 대연동)
    @NotNull
    private String headquarterAddress; // 본점주소
    @NotNull
    private String headquarterPostalCode; // 본점 우편 번호
    @NotNull
    private String headquarterPlace; // 본점 동

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String businessAddress;
        private String businessPostalCode;
        private String businessPlace;
        private String headquarterAddress;
        private String headquarterPostalCode;
        private String headquarterPlace;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder businessAddress(String businessAddress) {
            this.businessAddress = businessAddress;
            return this;
        }
        public Builder businessPostalCode(String businessPostalCode) {
            this.businessPostalCode = businessPostalCode;
            return this;
        }

        public Builder businessPlace(String businessPlace) {
            this.businessPlace = businessPlace;
            return this;
        }

        public Builder headquarterAddress(String headquarterAddress) {
            this.headquarterAddress = headquarterAddress;
            return this;
        }

        public Builder headquarterPostalCode(String headquarterPostalCode) {
            this.headquarterPostalCode = headquarterPostalCode;
            return this;
        }


        public Builder headquarterPlace(String headquarterPlace) {
            this.headquarterPlace = headquarterPlace;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    private Address(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.businessAddress = builder.businessAddress;
        this.businessPostalCode = builder.businessPostalCode;
        this.businessPlace = builder.businessPlace;
        this.headquarterAddress = builder.headquarterAddress;
        this.headquarterPostalCode = builder.headquarterPostalCode;
        this.headquarterPlace = builder.headquarterPlace;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .businessAddress(this.businessAddress)
                .businessPostalCode(this.businessPostalCode)
                .businessPlace(this.businessPlace)
                .headquarterAddress(this.headquarterAddress)
                .headquarterPostalCode(this.headquarterPostalCode)
                .headquarterPlace(this.headquarterPlace);
    }

    public String getId() {
        return id;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public String getBusinessPostalCode() {
        return businessPostalCode;
    }

    public String getBusinessPlace() {
        return businessPlace;
    }

    public String getHeadquarterAddress() {
        return headquarterAddress;
    }

    public String getHeadquarterPostalCode() {
        return headquarterPostalCode;
    }

    public String getHeadquarterPlace() {
        return headquarterPlace;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessPostalCode='" + businessPostalCode + '\'' +
                ", businessPlace='" + businessPlace + '\'' +
                ", headquarterAddress='" + headquarterAddress + '\'' +
                ", headquarterPostalCode='" + headquarterPostalCode + '\'' +
                ", headquarterPlace='" + headquarterPlace + '\'' +
                '}';
    }

}
