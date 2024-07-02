package com.erp.system.financial.model.basic_information_management.vendor_registration;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

/**
 * 거래처 테이블
 * 거래처 정보 데이터 테이블
 */
public class Vendor {
    @Unique
    @NotNull
    private final String id; // 거래처의 고유 식별자
    @NotNull
    private final String departmentId; // 자사 거래 담당 부서 ID
    @NotNull
    private final String managerId; // 자사 거래 담당자 ID
    @NotNull
    private String name; // 거래처명
    @Unique
    @NotNull
    private String registrationNumber; // 사업자 등록번호
    @Unique
    @NotNull
    private String personalIdentificationNumber; // 주민등록번호
    @NotNull
    private String businessType; // 업종형태
    private String businessItem; // 종목
    @NotNull
    private String address; // 주소
    @NotNull
    private String representativeName; // 대표자명
    @NotNull
    private String concat; // 연락처
    private String fax; // 팩스
    @NotNull
    private String postalCode; // 주소 우편번호
    private String website; // 홈페이지 주소
    @NotNull
    private String contactPerson; // 거래처 담당자
    @NotNull
    private String email; // 거래처 담당자 이메일



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
        private String representativeName;
        private String concat;
        private String fax;
        private String postalCode;
        private String website;
        private String contactPerson;
        private String email;

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

        public Builder representativeName(String representativeName) {
            this.address = representativeName;
            return this;
        }

        public Builder concat(String concat) {
            this.concat = concat;
            return this;
        }

        public Builder fax(String fax) {
            this.fax = fax;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder website(String website) {
            this.website = website;
            return this;
        }

        public Builder contactPerson(String contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
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
        this.representativeName = builder.representativeName;
        this.concat = builder.concat;
        this.fax = builder.fax;
        this.postalCode = builder.postalCode;
        this.website = builder.website;
        this.contactPerson = builder.contactPerson;
        this.email = builder.email;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
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
                .address(this.address)
                .representativeName(this.representativeName)
                .concat(this.concat)
                .fax(this.fax)
                .postalCode(this.postalCode)
                .website(this.website)
                .contactPerson(this.contactPerson)
                .email(this.email);
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

    public String getRepresentativeName() {
        return representativeName;
    }

    public String getConcat() {
        return concat;
    }

    public String getFax() {
        return fax;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getWebsite() {
        return website;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getEmail() {
        return email;
    }
}