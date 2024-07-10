package com.erp.system.financial.model.basic_information_management.vendor_registration;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

/**
 * 거래처 테이블
 * 거래처 정보 데이터 테이블
 */
@EnumMapping
public class Vendor {
    public enum BusinessStatus {BUSINESS, NONBUSINESS}; // 사업자여부 (사업자 , 비사업자)
    public enum Relationship {SUPPLIER, MANUFACTURER, WHOLESALER, RETAILER,
        DISTRIBUTOR, SERVICEPROVIDER, CUSTOMER, PARTNER};
    // 거래처의 유형 (공급업체, 제조업체, 도매업체, 소매업체, 유통업체, 서비스제공업체, 고객사, 파트너사)


    @Unique
    @NotNull
    private final String id; // 거래처의 고유 식별자
    @NotNull
    private final String departmentId; // 자사 거래 담당 부서 ID
    @NotNull
    private final String managerId; // 자사 거래 담당자 ID
    @NotNull
    private final String representativeId; // 대표자 정보 테이블 id
    @NotNull
    private final String contactId; // 연락처 정보 테이블 id
    @NotNull
    private final String addressId; // 주소 정보 테이블 id
    @NotNull
    private final String businessItemId; // 업태 종목 테이블 id
    @NotNull
    private final String businessTypeId; // 업종형태 테이블 id

    @NotNull
    private String name; // 거래처명
    @Unique
    @NotNull
    private String registrationNumber; // 사업자 등록번호
    private String website; // 홈페이지 주소
    @NotNull
    private String contactPerson; // 거래처 담당자
    @NotNull
    private String email; // 거래처 담당자 이메일
    @NotNull
    private BusinessStatus businessStatus; // 사업자 비사업자 여부
    @NotNull
    private Relationship relationship; // 거래처 유형



    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String departmentId;
        private String managerId;
        private String representativeId;
        private String contactId;
        private String addressId;
        private String businessItemId;
        private String businessTypeId;

        private String name;
        private String registrationNumber;
        private String website;
        private String contactPerson;
        private String email;
        private BusinessStatus businessStatus;
        private Relationship relationship;

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

        public Builder representativeId(String representativeId) {
            this.representativeId = representativeId;
            return this;
        }

        public Builder contactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder businessItemId(String businessItemId) {
            this.businessItemId = businessItemId;
            return this;
        }

        public Builder businessTypeId(String businessTypeId) {
            this.businessTypeId = businessTypeId;
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

        public Builder businessStatus(BusinessStatus businessStatus) {
            this.businessStatus = businessStatus;
            return this;
        }

        public Builder relationship(Relationship relationship) {
            this.relationship = relationship;
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
        this.representativeId = builder.representativeId;
        this.contactId = builder.contactId;
        this.addressId = builder.addressId;
        this.businessItemId = builder.businessItemId;
        this.businessTypeId = builder.businessTypeId;
        this.name = builder.name;
        this.registrationNumber = builder.registrationNumber;
        this.website = builder.website;
        this.contactPerson = builder.contactPerson;
        this.email = builder.email;
        this.businessStatus = builder.businessStatus;
        this.relationship = builder.relationship;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .departmentId(this.departmentId)
                .managerId(this.managerId)
                .representativeId(this.representativeId)
                .contactId(this.contactId)
                .addressId(this.addressId)
                .businessItemId(this.businessItemId)
                .businessTypeId(this.businessTypeId)
                .name(this.name)
                .registrationNumber(this.registrationNumber)
                .website(this.website)
                .contactPerson(this.contactPerson)
                .email(this.email)
                .businessStatus(this.businessStatus)
                .relationship(this.relationship);
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

    public String getRepresentativeId() {
        return representativeId;
    }

    public String getContactId() {
        return contactId;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
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

    public BusinessStatus getBusinessStatus() {
        return businessStatus;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", managerId='" + managerId + '\'' +
                ", representativeId='" + representativeId + '\'' +
                ", contactId='" + contactId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", businessItemId='" + businessItemId + '\'' +
                ", businessTypeId='" + businessTypeId + '\'' +
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", website='" + website + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", email='" + email + '\'' +
                ", businessStatus=" + businessStatus +
                ", relationship=" + relationship +
                '}';
    }
}