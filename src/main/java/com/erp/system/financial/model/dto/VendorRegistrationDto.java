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
    private String name; // 거래처명
    private String registrationNumber; // 사업자 등록번호
    private String personalIdentificationNumber; // 주민등록번호
    private String businessType; // 업종형태
    private String businessItem; // 종목
    private String address; // 주소
    private String representativeName; // 대표자명
    private String concat; // 연락처
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

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessItem() {
        return businessItem;
    }

    public void setBusinessItem(String businessItem) {
        this.businessItem = businessItem;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getConcat() {
        return concat;
    }

    public void setConcat(String concat) {
        this.concat = concat;
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
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", personalIdentificationNumber='" + personalIdentificationNumber + '\'' +
                ", businessType='" + businessType + '\'' +
                ", businessItem='" + businessItem + '\'' +
                ", address='" + address + '\'' +
                ", representativeName='" + representativeName + '\'' +
                ", concat='" + concat + '\'' +
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
