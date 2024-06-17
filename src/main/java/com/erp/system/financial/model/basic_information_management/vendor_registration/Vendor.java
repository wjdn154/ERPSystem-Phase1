package com.erp.system.financial.model.basic_information_management.vendor_registration;

import java.util.UUID;

/**
 * 거래처 테이블
 * 거래처 정보 데이터 테이블
 */
public class Vendor {
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

    public static class Builder {
        private final String id;
        private final String code;
        private final String department_id;
        private final String manager_id;

        private String name;
        private String registration_number;
        private String personal_identification_number;
        private String business_type;
        private String business_item;
        private String address;

        public Builder( String code, String manager_id, String department_id) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.manager_id = manager_id;
            this.department_id = department_id;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder registration_number(String registration_number) {
            this.registration_number = registration_number;
            return this;
        }

        public Builder personal_identification_number(String personal_identification_number) {
            this.personal_identification_number = personal_identification_number;
            return this;
        }

        public Builder business_type(String business_type) {
            this.business_type = business_type;
            return this;
        }

        public Builder business_item(String business_item) {
            this.business_item = business_item;
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
        this.id = builder.id;
        this.code = builder.code;
        this.department_id =  builder.department_id;
        this.manager_id =  builder.manager_id;
        this.name =  builder.name;
        this.registration_number =  builder.registration_number;
        this.personal_identification_number =  builder.personal_identification_number;
        this.business_type =  builder.business_type;
        this.business_item =  builder.business_item;
        this.address =  builder.address;
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

    public String getRegistration_number() {
        return registration_number;
    }

    public String getPersonal_identification_number() {
        return personal_identification_number;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public String getBusiness_item() {
        return business_item;
    }

    public String getAddress() {
        return address;
    }
}
