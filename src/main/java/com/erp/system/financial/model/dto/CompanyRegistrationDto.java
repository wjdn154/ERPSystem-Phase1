package com.erp.system.financial.model.dto;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;

import java.time.LocalDate;

/**
 * 회사 등록을 위한 데이터 전송 객체 (DTO).
 */
public class CompanyRegistrationDto {
    private String businessAddress; // 사업장주소
    private String businessPostalCode; // 사업장 우편번호
    private String businessPlace; // 사업장 동 (동 ex 대연동)
    private String headquarterAddress; // 본점주소
    private String headquarterPostalCode; // 본점 우편 번호
    private String headquarterPlace; // 본점 동
    private boolean isSme; // 중소기업여부
    private String businessRegistrationNumber; // 사업자등록번호
    private String corporateRegistrationNumber; // 법인등록번호
    private LocalDate establishmentDate; // 설립연월일
    private String name; // 회사명
    private Company.EntityType entityType; // 구분 (법인, 개인)
    private boolean active; // 사용여부(사용, 미사용)
    private LocalDate fiscalYearStart; // 회계연도 시작일
    private LocalDate fiscalYearEnd; // 회계연도 마지막일
    private int fiscalCardinalNumber; // 회계연도 기수
    private String mainIndustryId; // 주업종코드
    private String businessPhone; // 사업장 전화번호
    private String fax; // 팩스번호
    private String corporateKindId; // 법인종류 Id
    private String corporateTypeId; // 법인구분 Id
    private String RepresentativeName; // 대표자명
    private String idNumber; // 대표자 주민번호
    private boolean foreign; // 대표자 외국인여부
    private String businessTaxOfficeId; // 사업장관할 세무서 id
    private String headquartersTaxOfficeId; // 본점관할 세무서 id
    private String localIncomeTaxOffice; // 지방소득세납세지
    private String businessTypeId; // 업종 형태 id
    private String businessItemId; // 업체 종목 id

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getBusinessPostalCode() {
        return businessPostalCode;
    }

    public void setBusinessPostalCode(String businessPostalCode) {
        this.businessPostalCode = businessPostalCode;
    }

    public String getBusinessPlace() {
        return businessPlace;
    }

    public void setBusinessPlace(String businessPlace) {
        this.businessPlace = businessPlace;
    }

    public String getHeadquarterAddress() {
        return headquarterAddress;
    }

    public void setHeadquarterAddress(String headquarterAddress) {
        this.headquarterAddress = headquarterAddress;
    }

    public String getHeadquarterPostalCode() {
        return headquarterPostalCode;
    }

    public void setHeadquarterPostalCode(String headquarterPostalCode) {
        this.headquarterPostalCode = headquarterPostalCode;
    }

    public String getHeadquarterPlace() {
        return headquarterPlace;
    }

    public void setHeadquarterPlace(String headquarterPlace) {
        this.headquarterPlace = headquarterPlace;
    }

    public boolean isSme() {
        return isSme;
    }

    public void setSme(boolean sme) {
        isSme = sme;
    }

    public String getBusinessRegistrationNumber() {
        return businessRegistrationNumber;
    }

    public void setBusinessRegistrationNumber(String businessRegistrationNumber) {
        this.businessRegistrationNumber = businessRegistrationNumber;
    }

    public String getCorporateRegistrationNumber() {
        return corporateRegistrationNumber;
    }

    public void setCorporateRegistrationNumber(String corporateRegistrationNumber) {
        this.corporateRegistrationNumber = corporateRegistrationNumber;
    }

    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(LocalDate establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company.EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(Company.EntityType entityType) {
        this.entityType = entityType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getFiscalYearStart() {
        return fiscalYearStart;
    }

    public void setFiscalYearStart(LocalDate fiscalYearStart) {
        this.fiscalYearStart = fiscalYearStart;
    }

    public LocalDate getFiscalYearEnd() {
        return fiscalYearEnd;
    }

    public void setFiscalYearEnd(LocalDate fiscalYearEnd) {
        this.fiscalYearEnd = fiscalYearEnd;
    }

    public int getFiscalCardinalNumber() {
        return fiscalCardinalNumber;
    }

    public void setFiscalCardinalNumber(int fiscalCardinalNumber) {
        this.fiscalCardinalNumber = fiscalCardinalNumber;
    }

    public String getMainIndustryId() {
        return mainIndustryId;
    }

    public void setMainIndustryId(String mainIndustryId) {
        this.mainIndustryId = mainIndustryId;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCorporateKindId() {
        return corporateKindId;
    }

    public void setCorporateKindId(String corporateKindId) {
        this.corporateKindId = corporateKindId;
    }

    public String getCorporateTypeId() {
        return corporateTypeId;
    }

    public void setCorporateTypeId(String corporateTypeId) {
        this.corporateTypeId = corporateTypeId;
    }

    public String getRepresentativeName() {
        return RepresentativeName;
    }

    public void setRepresentativeName(String representativeName) {
        RepresentativeName = representativeName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public boolean isForeign() {
        return foreign;
    }

    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }

    public String getBusinessTaxOfficeId() {
        return businessTaxOfficeId;
    }

    public void setBusinessTaxOfficeId(String businessTaxOfficeId) {
        this.businessTaxOfficeId = businessTaxOfficeId;
    }

    public String getHeadquartersTaxOfficeId() {
        return headquartersTaxOfficeId;
    }

    public void setHeadquartersTaxOfficeId(String headquartersTaxOfficeId) {
        this.headquartersTaxOfficeId = headquartersTaxOfficeId;
    }

    public String getLocalIncomeTaxOffice() {
        return localIncomeTaxOffice;
    }

    public void setLocalIncomeTaxOffice(String localIncomeTaxOffice) {
        this.localIncomeTaxOffice = localIncomeTaxOffice;
    }

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(String businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    @Override
    public String toString() {
        return "CompanyRegistrationDto{" +
                "businessAddress='" + businessAddress + '\'' +
                ", businessPostalCode='" + businessPostalCode + '\'' +
                ", businessPlace='" + businessPlace + '\'' +
                ", headquarterAddress='" + headquarterAddress + '\'' +
                ", headquarterPostalCode='" + headquarterPostalCode + '\'' +
                ", headquarterPlace='" + headquarterPlace + '\'' +
                ", isSme=" + isSme +
                ", businessRegistrationNumber='" + businessRegistrationNumber + '\'' +
                ", corporateRegistrationNumber='" + corporateRegistrationNumber + '\'' +
                ", establishmentDate=" + establishmentDate +
                ", name='" + name + '\'' +
                ", entityType='" + entityType + '\'' +
                ", active=" + active +
                ", fiscalYearStart=" + fiscalYearStart +
                ", fiscalYearEnd=" + fiscalYearEnd +
                ", fiscalCardinalNumber=" + fiscalCardinalNumber +
                ", mainIndustryId='" + mainIndustryId + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", fax='" + fax + '\'' +
                ", corporateKindId='" + corporateKindId + '\'' +
                ", corporateTypeId='" + corporateTypeId + '\'' +
                ", RepresentativeName='" + RepresentativeName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", foreign=" + foreign +
                ", businessTaxOfficeId='" + businessTaxOfficeId + '\'' +
                ", headquartersTaxOfficeId='" + headquartersTaxOfficeId + '\'' +
                ", localIncomeTaxOffice='" + localIncomeTaxOffice + '\'' +
                ", businessTypeId='" + businessTypeId + '\'' +
                ", businessItemId='" + businessItemId + '\'' +
                '}';
    }
}
