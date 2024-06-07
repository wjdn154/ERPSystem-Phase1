package com.erp.system.financial.model.basic_information_management.vendor_registration;

import java.util.UUID;

/**
 * 거래처 테이블
 * 거래처 정보 데이터 테이블
 */
public class Vendors {
    private final String id; // 거래처의 고유 식별자
    private final String code; // 거래처의 고유 코드
    private final String department_id; // 거래 담당 부서 ID
    private final String manager_id; // 거래 담당자 ID
    private String name; // 거래처명
    private String registration_number; // 사업자 등록번호
    private String personal_identification_number; // 주민등록번호
    private String business_type; // 업종형태
    private String business_item; // 종목
    private String address; // 주소

    public Vendors(String manager_id, String department_id, String code) {
        this.id = UUID.randomUUID().toString();
        this.manager_id = manager_id;
        this.department_id = department_id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public String getManager_id() {
        return manager_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getPersonal_identification_number() {
        return personal_identification_number;
    }

    public void setPersonal_identification_number(String personal_identification_number) {
        this.personal_identification_number = personal_identification_number;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getBusiness_item() {
        return business_item;
    }

    public void setBusiness_item(String business_item) {
        this.business_item = business_item;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
