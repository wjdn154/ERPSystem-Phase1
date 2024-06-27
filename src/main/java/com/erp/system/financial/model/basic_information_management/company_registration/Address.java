package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 주소 정보 테이블
 * 회사등록 시 필요한 주소 데이터 테이블
 */
public class Address {
    @NotNull
    private final String id; // 고유식별자

    @NotNull
    private String address; // 사업장주소
    @NotNull
    private String headquartersAddress; // 본점주소
    @NotNull
    private String businessPlace; // 사업장 동 코드 (동 ex 대연동)
    @NotNull
    private String headquarters; // 본점 동 코드

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String address;
        private String headquartersAddress;
        private String businessPlace;
        private String headquarters;

        public Builder id(String id) {
            this.id = id;
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

        public Builder businessPlace(String businessPlace) {
            this.businessPlace = businessPlace;
            return this;
        }

        public Builder headquarters(String headquarters) {
            this.headquarters = headquarters;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    private Address(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.address = builder.address;
        this.headquartersAddress = builder.headquartersAddress;
        this.businessPlace = builder.businessPlace;
        this.headquarters = builder.headquarters;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .address(this.address)
                .headquartersAddress(this.headquartersAddress)
                .businessPlace(this.businessPlace)
                .headquarters(this.headquarters);
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getHeadquartersAddress() {
        return headquartersAddress;
    }

    public String getBusinessPlace() {
        return businessPlace;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", headquartersAddress='" + headquartersAddress + '\'' +
                ", businessPlace='" + businessPlace + '\'' +
                ", headquarters='" + headquarters + '\'' +
                '}';
    }
}
