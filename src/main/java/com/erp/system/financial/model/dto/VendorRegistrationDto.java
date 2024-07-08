package com.erp.system.financial.model.dto;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;

/**
 * 거래처 등록시 필요한 전송 객체
 * */
public class VendorRegistrationDto {
    private String departmentId; // 자사 거래 담당 부서 ID
    private String managerId; // 자사 거래 담당자 ID
    private String businessItemId; // 업태 종목 테이블 id
    private String businessTypeId; // 업종형태 테이블 id
    private String name; // 거래처명
    private String registrationNumber; // 사업자 등록번호
    private String representativeName; // 대표자명
    private String personalIdentificationNumber; // 주민등록번호
    private boolean foreign; // 대표자 외국인 여부
    private String businessAddress; // 사업장주소
    private String businessPostalCode; // 사업장 우편번호
    private String businessPlace; // 사업장 동 (동 ex 대연동)
    private String headquarterPostalCode; // 본점 우편 번호
    private String headquarterAddress; // 본점주소
    private String headquarterPlace; // 본점 동
    private String businessPhone; // 거래처 연락처
    private String fax; // 팩스
    private String postalCode; // 주소 우편번호
    private String website; // 홈페이지 주소
    private String contactPerson; // 거래처 담당자
    private String email; // 거래처 담당자 이메일
    private Vendor.BusinessStatus businessStatus; // 사업자 비사업자 여부
    private Vendor.Relationship relationship; // 거래처 유형

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getBusinessItemId() {
        return businessItemId;
    }

    public void setBusinessItemId(String businessItemId) {
        this.businessItemId = businessItemId;
    }

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(String businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public boolean isForeign() {
        return foreign;
    }

    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }

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

    public String getHeadquarterPostalCode() {
        return headquarterPostalCode;
    }

    public void setHeadquarterPostalCode(String headquarterPostalCode) {
        this.headquarterPostalCode = headquarterPostalCode;
    }

    public String getHeadquarterAddress() {
        return headquarterAddress;
    }

    public void setHeadquarterAddress(String headquarterAddress) {
        this.headquarterAddress = headquarterAddress;
    }

    public String getHeadquarterPlace() {
        return headquarterPlace;
    }

    public void setHeadquarterPlace(String headquarterPlace) {
        this.headquarterPlace = headquarterPlace;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vendor.BusinessStatus getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(Vendor.BusinessStatus businessStatus) {
        this.businessStatus = businessStatus;
    }

    public Vendor.Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Vendor.Relationship relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "VendorRegistrationDto{" +
                "departmentId='" + departmentId + '\'' +
                ", managerId='" + managerId + '\'' +
                ", businessItemId='" + businessItemId + '\'' +
                ", businessTypeId='" + businessTypeId + '\'' +
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", personalIdentificationNumber='" + personalIdentificationNumber + '\'' +
                ", foreign=" + foreign +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessPostalCode='" + businessPostalCode + '\'' +
                ", businessPlace='" + businessPlace + '\'' +
                ", headquarterPostalCode='" + headquarterPostalCode + '\'' +
                ", headquarterAddress='" + headquarterAddress + '\'' +
                ", headquarterPlace='" + headquarterPlace + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", fax='" + fax + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", website='" + website + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", email='" + email + '\'' +
                ", businessStatus=" + businessStatus +
                ", relationship=" + relationship +
                '}';
    }
}
