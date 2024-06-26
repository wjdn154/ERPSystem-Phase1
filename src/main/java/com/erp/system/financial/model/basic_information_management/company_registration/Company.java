package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.time.LocalDate;

/**
 * 회사 기본 정보 테이블
 * 회사 기본 정보 등록시 사용하는 테이블
 */
public class Company {
    @NotNull
    private final String id; // 고유식별자
    @NotNull
    private final String corporateTypeId; // 법인구분 테이블 참조코드
    @NotNull
    private final String corporateKindsId; // 법인종류 테이블 참조코드
    @NotNull
    private final String representativeId; // 대표자 정보 테이블 참조코드
    @NotNull
    private final String addressId; // 주소 정보 테이블 참조코드
    @NotNull
    private final String contactId; // 연락처 정보 테이블 참조코드
    @NotNull
    private final String taxId; // 세무 정보 테이블 참조코드

    @NotNull
    private boolean isSme; // 중소기업여부
    @NotNull
    private String businessRegistrationNumber; // 사업자등록번호
    @NotNull
    private String corporateRegistrationNumber; // 법인등록번호
    @NotNull
    private LocalDate establishmentDate; // 설립연월일
    @NotNull
    private String name; // 회사명
    @NotNull
    private String type; // 구분 (법인, 개인)
    @NotNull
    private boolean active; // 사용여부(사용, 미사용)
    @NotNull
    private LocalDate fiscalYearStart; // 회계연도 시작일
    @NotNull
    private LocalDate fiscalYearEnd; // 회계연도 마지막일
    @NotNull
    private int fiscalCardinalNumber; // 회계연도 기수
    @NotNull
    private String mainIndustryId; // 주업종코드

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String corporateTypeId;
        private String corporateKindsId;
        private String representativeId;
        private String addressId;
        private String contactId;
        private String taxId;

        private boolean isSme;
        private String businessRegistrationNumber;
        private String corporateRegistrationNumber;
        private LocalDate establishmentDate;
        private String name;
        private String type;
        private boolean active;
        private LocalDate fiscalYearStart;
        private LocalDate fiscalYearEnd;
        private int fiscalCardinalNumber;
        private String mainIndustryId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder corporateTypeId(String corporateTypeId) {
            this.corporateTypeId = corporateTypeId;
            return this;
        }

        public Builder corporateKindsId(String corporateKindsId) {
            this.corporateKindsId = corporateKindsId;
            return this;
        }

        public Builder representativeId(String representativeId) {
            this.representativeId = representativeId;
            return this;
        }

        public Builder addressId(String addressId) {
            this.addressId = addressId;
            return this;
        }

        public Builder contactId(String contactId) {
            this.contactId = contactId;
            return this;
        }

        public Builder taxId(String taxId) {
            this.taxId = taxId;
            return this;
        }

        public Builder isSme(boolean isSme) {
            this.isSme = isSme;
            return this;
        }

        public Builder businessRegistrationNumber(String businessRegistrationNumber) {
            this.businessRegistrationNumber = businessRegistrationNumber;
            return this;
        }

        public Builder corporateRegistrationNumber(String corporateRegistrationNumber) {
            this.corporateRegistrationNumber = corporateRegistrationNumber;
            return this;
        }

        public Builder establishmentDate(LocalDate establishmentDate) {
            this.establishmentDate = establishmentDate;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Builder fiscalYearStart(LocalDate fiscalYearStart) {
            this.fiscalYearStart = fiscalYearStart;
            return this;
        }

        public Builder fiscalYearEnd(LocalDate fiscalYearEnd) {
            this.fiscalYearEnd = fiscalYearEnd;
            return this;
        }

        public Builder fiscalCardinalNumber(int fiscalCardinalNumber) {
            this.fiscalCardinalNumber = fiscalCardinalNumber;
            return this;
        }

        public Builder mainIndustryId(String mainIndustryId) {
            this.mainIndustryId = mainIndustryId;
            return this;
        }

        public Company build() {
            return new Company(this);
        }
    }

    private Company(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.corporateTypeId = builder.corporateTypeId;
        this.corporateKindsId = builder.corporateKindsId;
        this.representativeId = builder.representativeId;
        this.addressId = builder.addressId;
        this.contactId = builder.contactId;
        this.taxId = builder.taxId;
        this.isSme = builder.isSme;
        this.businessRegistrationNumber = builder.businessRegistrationNumber;
        this.corporateRegistrationNumber = builder.corporateRegistrationNumber;
        this.establishmentDate = builder.establishmentDate;
        this.name = builder.name;
        this.type = builder.type;
        this.active = builder.active;
        this.fiscalYearStart = builder.fiscalYearStart;
        this.fiscalYearEnd = builder.fiscalYearEnd;
        this.fiscalCardinalNumber = builder.fiscalCardinalNumber;
        this.mainIndustryId = builder.mainIndustryId;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .isSme(this.isSme)
                .businessRegistrationNumber(this.businessRegistrationNumber)
                .corporateRegistrationNumber(this.corporateRegistrationNumber)
                .establishmentDate(this.establishmentDate)
                .name(this.name)
                .type(this.type)
                .active(this.active)
                .fiscalYearStart(this.fiscalYearStart)
                .fiscalYearEnd(this.fiscalYearEnd)
                .fiscalCardinalNumber(this.fiscalCardinalNumber)
                .mainIndustryId(this.mainIndustryId);
    }

    public String getId() {
        return id;
    }

    public String getCorporateTypeId() {
        return corporateTypeId;
    }

    public String getCorporateKindsId() {
        return corporateKindsId;
    }

    public String getRepresentativeId() {
        return representativeId;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getContactId() {
        return contactId;
    }

    public String getTaxId() {
        return taxId;
    }

    public boolean isSme() {
        return isSme;
    }

    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    public String getCorporateRegistrationNumber() {
        return corporateRegistrationNumber;
    }

    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDate getFiscalYearStart() {
        return fiscalYearStart;
    }

    public LocalDate getFiscalYearEnd() {
        return fiscalYearEnd;
    }

    public int getFiscalCardinalNumber() {
        return fiscalCardinalNumber;
    }

    public String getMainIndustryId() {
        return mainIndustryId;
    }
}
