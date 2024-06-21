package com.erp.system.financial.model.basic_information_management.vendor_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.util.UUID;

/**
 * 거래처 테이블
 * 거래처 정보 데이터 테이블
 */
public class Vendor {
    @NotNull
    private final String id; // 거래처의 고유 식별자
    @NotNull
    private final String departmentId; // 거래 담당 부서 ID
    @NotNull
    private final String managerId; // 거래 담당자 ID

    @NotNull
    private String name; // 거래처명
    @NotNull
    private String registrationNumber; // 사업자 등록번호
    private String personalIdentificationNumber; // 주민등록번호
    private String businessType; // 업종형태
    private String businessItem; // 종목
    private String address; // 주소

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String departmentId;
        private String managerId;

        private String name;
        private String registrationNumber;
        private String personalIdentificationNumber;
        private String businessType;
        private String businessItem;
        private String address;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder managerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder registrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder personalIdentificationNumber(String personalIdentificationNumber) {
            this.personalIdentificationNumber = personalIdentificationNumber;
            return this;
        }

        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }

        public Builder businessItem(String businessItem) {
            this.businessItem = businessItem;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Vendor build() {
            return new Vendor(this);
        }
    }

    private Vendor(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.departmentId = builder.departmentId;
        this.managerId = builder.managerId;
        this.name = builder.name;
        this.registrationNumber = builder.registrationNumber;
        this.personalIdentificationNumber = builder.personalIdentificationNumber;
        this.businessType = builder.businessType;
        this.businessItem = builder.businessItem;
        this.address = builder.address;
        NotNullValidator.safeValidateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .departmentId(this.departmentId)
                .managerId(this.managerId)
                .name(this.name)
                .registrationNumber(this.registrationNumber)
                .personalIdentificationNumber(this.personalIdentificationNumber)
                .businessType(this.businessType)
                .businessItem(this.businessItem)
                .address(this.address);
    }

    public String getId() {
        return id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getBusinessItem() {
        return businessItem;
    }

    public String getAddress() {
        return address;
    }
}