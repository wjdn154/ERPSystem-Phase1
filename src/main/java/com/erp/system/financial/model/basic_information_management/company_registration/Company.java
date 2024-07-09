package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.time.LocalDate;

/**
 * 회사 기본 정보 테이블
 * 회사 기본 정보 등록시 사용하는 테이블
 */
@EnumMapping
public class Company {
    public enum EntityType {INCORPORATED,INDIVIDUAL}
    @Unique
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
    private final String businessTaxOfficeId; // 사업장관할 세무서 id
    @NotNull
    private final String headquartersTaxOfficeId; // 본점관할 세무서 id
    @NotNull
    private final String businessTypeId; // 업종 형태 id
    @NotNull
    private final String businessItemId; // 업체 종목 id

    @NotNull
    private String localIncomeTaxOffice; // 지방소득세납세지
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
    private EntityType entityType; // 구분 (법인, 개인)
    @NotNull
    private boolean active; // 사용여부(사용, 미사용)
    @NotNull
    private LocalDate fiscalYearStart; // 회계연도 시작일
    @NotNull
    private LocalDate fiscalYearEnd; // 회계연도 마지막일
    @NotNull
    private int fiscalCardinalNumber; // 회계연도 기수

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String corporateTypeId;
        private String corporateKindsId;
        private String representativeId;
        private String addressId;
        private String contactId;
        private String businessTaxOfficeId;
        private String headquartersTaxOfficeId;
        private String businessTypeId; // << 테이블 id 참조
        private String businessItemId; // << 테이블 id 참조
        private String localIncomeTaxOffice;
        private boolean isSme;
        private String businessRegistrationNumber;
        private String corporateRegistrationNumber;
        private LocalDate establishmentDate;
        private String name;
        private EntityType entityType;
        private boolean active;
        private LocalDate fiscalYearStart;
        private LocalDate fiscalYearEnd;
        private int fiscalCardinalNumber;


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

        public Builder businessTaxOfficeId(String businessTaxOfficeId) {
            this.businessTaxOfficeId = businessTaxOfficeId;
            return this;
        }

        public Builder headquartersTaxOfficeId(String headquartersTaxOfficeId) {
            this.headquartersTaxOfficeId = headquartersTaxOfficeId;
            return this;
        }

        public Builder localIncomeTaxOffice(String localIncomeTaxOffice) {
            this.localIncomeTaxOffice = localIncomeTaxOffice;
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

        public Builder entityType(EntityType entityType) {
            this.entityType = entityType;
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

        public Builder businessTypeId(String businessTypeId) {
            this.businessTypeId = businessTypeId;
            return this;
        }

        public Builder businessItemId(String businessItemId) {
            this.businessItemId = businessItemId;
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
        this.businessTaxOfficeId = builder.businessTaxOfficeId;
        this.headquartersTaxOfficeId = builder.headquartersTaxOfficeId;
        this.localIncomeTaxOffice = builder.localIncomeTaxOffice;
        this.isSme = builder.isSme;
        this.businessRegistrationNumber = builder.businessRegistrationNumber;
        this.corporateRegistrationNumber = builder.corporateRegistrationNumber;
        this.establishmentDate = builder.establishmentDate;
        this.name = builder.name;
        this.entityType = builder.entityType;
        this.active = builder.active;
        this.fiscalYearStart = builder.fiscalYearStart;
        this.fiscalYearEnd = builder.fiscalYearEnd;
        this.fiscalCardinalNumber = builder.fiscalCardinalNumber;
        this.businessTypeId = builder.businessTypeId;
        this.businessItemId = builder.businessItemId;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .corporateTypeId(this.corporateTypeId)
                .corporateKindsId(this.corporateKindsId)
                .representativeId(this.representativeId)
                .addressId(this.addressId)
                .contactId(this.contactId)
                .businessTaxOfficeId(this.businessTaxOfficeId)
                .headquartersTaxOfficeId(this.headquartersTaxOfficeId)
                .localIncomeTaxOffice(this.localIncomeTaxOffice)
                .isSme(this.isSme)
                .businessRegistrationNumber(this.businessRegistrationNumber)
                .corporateRegistrationNumber(this.corporateRegistrationNumber)
                .establishmentDate(this.establishmentDate)
                .name(this.name)
                .entityType(this.entityType)
                .active(this.active)
                .fiscalYearStart(this.fiscalYearStart)
                .fiscalYearEnd(this.fiscalYearEnd)
                .fiscalCardinalNumber(this.fiscalCardinalNumber)
                .businessTypeId(this.businessTypeId)
                .businessItemId(this.businessItemId);
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

    public String getBusinessTaxOfficeId() {
        return businessTaxOfficeId;
    }

    public String getHeadquartersTaxOfficeId() {
        return headquartersTaxOfficeId;
    }

    public String getLocalIncomeTaxOffice() {
        return localIncomeTaxOffice;
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

    public EntityType getEntityType() {
        return entityType;
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

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", corporateTypeId='" + corporateTypeId + '\'' +
                ", corporateKindsId='" + corporateKindsId + '\'' +
                ", representativeId='" + representativeId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", contactId='" + contactId + '\'' +
                ", businessTaxOfficeId='" + businessTaxOfficeId + '\'' +
                ", headquartersTaxOfficeId='" + headquartersTaxOfficeId + '\'' +
                ", businessTypeId='" + businessTypeId + '\'' +
                ", businessItemId='" + businessItemId + '\'' +
                ", localIncomeTaxOffice='" + localIncomeTaxOffice + '\'' +
                ", isSme=" + isSme +
                ", businessRegistrationNumber='" + businessRegistrationNumber + '\'' +
                ", corporateRegistrationNumber='" + corporateRegistrationNumber + '\'' +
                ", establishmentDate=" + establishmentDate +
                ", name='" + name + '\'' +
                ", entityType=" + entityType +
                ", active=" + active +
                ", fiscalYearStart=" + fiscalYearStart +
                ", fiscalYearEnd=" + fiscalYearEnd +
                ", fiscalCardinalNumber=" + fiscalCardinalNumber +
                '}';
    }
}
