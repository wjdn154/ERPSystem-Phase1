package com.erp.system.logistics.model.basic_information_registration.vendor_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 거래처 테이블
 * 거래처에 대한 정보가 있는 테이블 - 거래처 등록 시 사용
 */
public class Vendors {
    @NotNull
    private final String id; // 거래처의 고유 식별자

    @NotNull
    private String vendorName; // 거래처명
    @NotNull
    private String vendorTypeId; // 거래처유형
    @NotNull
    private String representative; // 대표자명
    @NotNull
    private String businessType; // 업태
    @NotNull
    private String businessCategory; // 종목
    @NotNull
    private String contact; // 연락처
    private String fax; // Fax
    @NotNull
    private String postalCode; // 주소 우편번호
    @NotNull
    private String address; // 주소
    private String website; // 홈페이지
    @NotNull
    private String contactPerson; // 담당자
    @NotNull
    private String email; // 이메일

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String vendorName;
        private String vendorTypeId;
        private String representative;
        private String businessType;
        private String businessCategory;
        private String contact;
        private String fax;
        private String postalCode;
        private String address;
        private String website;
        private String contactPerson;
        private String email;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder vendorName(String vendorName) {
            this.vendorName = vendorName;
            return this;
        }

        public Builder vendorTypeId(String vendorTypeId) {
            this.vendorTypeId = vendorTypeId;
            return this;
        }

        public Builder representative(String representative) {
            this.representative = representative;
            return this;
        }

        public Builder businessType(String businessType) {
            this.businessType = businessType;
            return this;
        }

        public Builder businessCategory(String businessCategory) {
            this.businessCategory = businessCategory;
            return this;
        }

        public Builder contact(String contact) {
            this.contact = contact;
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

        public Builder address(String address) {
            this.address = address;
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

        public Vendors build() {
            return new Vendors(this);
        }
    }// end of Builder

    private Vendors(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.vendorName = builder.vendorName;
        this.vendorTypeId = builder.vendorTypeId;
        this.representative = builder.representative;
        this.businessType = builder.businessType;
        this.businessCategory = builder.businessCategory;
        this.contact = builder.contact;
        this.fax = builder.fax;
        this.postalCode = builder.postalCode;
        this.address = builder.address;
        this.website = builder.website;
        this.contactPerson = builder.contactPerson;
        this.email = builder.email;
        NotNullValidator.safeValidateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .vendorName(this.vendorName)
                .vendorTypeId(this.vendorTypeId)
                .representative(this.representative)
                .businessType(this.businessType)
                .businessCategory(this.businessCategory)
                .contact(this.contact)
                .fax(this.fax)
                .postalCode(this.postalCode)
                .address(this.address)
                .website(this.website)
                .contactPerson(this.contactPerson)
                .email(this.email);
    }

    public String getId() {
        return id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVendorTypeId() {
        return vendorTypeId;
    }

    public String getRepresentative() {
        return representative;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public String getContact() {
        return contact;
    }

    public String getFax() {
        return fax;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
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
