package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.Date;
import java.util.UUID;

/**
 * 회사 기본 정보 테이블
 * 회사 기본 정보 등록시 사용하는 테이블
 */
public class Company {
    private final String id; // 고유식별자
    private final String code; // 회사코드
    private final String corporate_type; // 법인구분 테이블 참조코드
    private final String corporate_kinds; // 법인종류 테이블 참조코드
    private final String representative_id; // 대표자 정보 테이블 참조코드
    private final String address_id; // 주소 정보 테이블 참조코드
    private final String contact_id; // 연락처 정보 테이블 참조코드
    private final String tax_id; // 세무 정보 테이블 참조코드

    private boolean is_sme; // 중소기업여부
    private String business_registration_number; // 사업자등록번호
    private String corporate_registration_number; // 법인등록번호
    private Date establishment_data; // 설립연월일
    private String name; // 회사명
    private String type; // 구분 (법인, 개인)
    private boolean active; // 사용여부(사용, 미사용)
    private Date fiscal_year_start; // 회계연도 시작일
    private Date fiscal_year_end; // 회계연도 마지막일
    private int fiscal_cardinal_number; // 회계연도 기수
    private String main_industry_code; // 주업종코드

    public static class Builder {
        private final String id;
        private final String code;
        private final String corporate_type;
        private final String corporate_kinds;
        private final String representative_id;
        private final String address_id;
        private final String contact_id;
        private final String tax_id;

        private boolean is_sme;
        private String business_registration_number;
        private String corporate_registration_number;
        private Date establishment_data;
        private String name;
        private String type;
        private boolean active;
        private Date fiscal_year_start;
        private Date fiscal_year_end;
        private int fiscal_cardinal_number;
        private String main_industry_code;

        // 테이블 생성 빌더 내부 정적 클래스
        public Builder(String code, String corporate_type, String corporate_kinds, String representative_id,
                       String address_id, String contact_id, String tax_id) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.corporate_type = corporate_type;
            this.corporate_kinds = corporate_kinds;
            this.representative_id = representative_id;
            this.address_id = address_id;
            this.contact_id = contact_id;
            this.tax_id = tax_id;
        }

        public Builder is_sme(boolean is_sme) {
            this.is_sme = is_sme;
            return this;
        }

        public Builder business_registration_number(String business_registration_number) {
            this.business_registration_number = business_registration_number;
            return this;
        }

        public Builder corporate_registration_number(String corporate_registration_number) {
            this.corporate_registration_number = corporate_registration_number;
            return this;
        }

        public Builder establishment_data(Date establishment_data) {
            this.establishment_data = establishment_data;
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

        public Builder fiscal_year_start(Date fiscal_year_start) {
            this.fiscal_year_start = fiscal_year_start;
            return this;
        }

        public Builder fiscal_year_end(Date fiscal_year_end) {
            this.fiscal_year_end = fiscal_year_end;
            return this;
        }

        public Builder fiscal_cardinal_number(int fiscal_cardinal_number) {
            this.fiscal_cardinal_number = fiscal_cardinal_number;
            return this;
        }

        public Builder main_industry_code(String main_industry_code) {
            this.main_industry_code = main_industry_code;
            return this;
        }

        public Company build() {
            return new Company(this);
        }


    } // end of builder

    private Company(Builder builder) {
        this.id = builder.id;
        this.corporate_type = builder.corporate_type;
        this.corporate_kinds = builder.corporate_kinds;
        this.representative_id = builder.representative_id;
        this.address_id = builder.address_id;
        this.contact_id = builder.contact_id;
        this.tax_id = builder.tax_id;
        this.code = builder.code;
        this.is_sme = builder.is_sme;
        this.business_registration_number = builder.business_registration_number;
        this.corporate_registration_number = builder.corporate_registration_number;
        this.establishment_data = builder.establishment_data;
        this.name = builder.name;
        this.type = builder.type;
        this.active = builder.active;
        this.fiscal_year_start = builder.fiscal_year_start;
        this.fiscal_year_end = builder.fiscal_year_end;
        this.fiscal_cardinal_number = builder.fiscal_cardinal_number;
        this.main_industry_code = builder.main_industry_code;
    }

    public String getId() {
        return id;
    }

    public String getCorporate_type() {
        return corporate_type;
    }

    public String getCorporate_kinds() {
        return corporate_kinds;
    }

    public String getRepresentative_id() {
        return representative_id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public String getContact_id() {
        return contact_id;
    }

    public String getTax_id() {
        return tax_id;
    }

    public String getCode() {
        return code;
    }

    public boolean isIs_sme() {
        return is_sme;
    }

    public String getBusiness_registration_number() {
        return business_registration_number;
    }

    public String getCorporate_registration_number() {
        return corporate_registration_number;
    }

    public Date getEstablishment_data() {
        return establishment_data;
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

    public Date getFiscal_year_start() {
        return fiscal_year_start;
    }

    public Date getFiscal_year_end() {
        return fiscal_year_end;
    }

    public int getFiscal_cardinal_number() {
        return fiscal_cardinal_number;
    }

    public String getMain_industry_code() {
        return main_industry_code;
    }
}
