package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 회사 대표자 정보 테이블
 * 회사 등록시 필요한 대표자 데이터 테이블
 */
public class Representative {
    private final String id; // 고유 식별자
    private final String code; // 회사 대표자 코드
    private final String company_id; // 연결된 회사 ID

    private String name; // 대표자명
    private String id_number; // 대표자 주민번호
    private boolean foreign; // 대표자 외국인여부

    public static class Builder {
        private final String id;
        private final String company_id;
        private final String code;

        private String name;
        private String id_number;
        private boolean foreign;

        public Builder(String code, String company_id) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.company_id = company_id;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id_number(String id_number) {
            this.id_number = id_number;
            return this;
        }

        public Builder foreign(boolean foreign) {
            this.foreign = foreign;
            return this;
        }

        public Representative build() {
            return new Representative(this);
        }
    }// end of Builder

    public Representative(Builder builder) {
        this.id = builder.id;
        this.company_id = builder.company_id;
        this.code = builder.code;
        this.name = builder.name;
        this.id_number = builder.id_number;
        this.foreign = builder.foreign;
    }

    public String getId() {
        return id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getId_number() {
        return id_number;
    }

    public boolean isForeign() {
        return foreign;
    }
}
