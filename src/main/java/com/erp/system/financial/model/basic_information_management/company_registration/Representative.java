package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 회사 대표자 정보 테이블
 * 회사 등록시 필요한 대표자 데이터 테이블
 */
public class Representative {
    private final String id; // 고유 식별자
    private final String code; // 회사 대표자 코드
    private final String companyId; // 연결된 회사 ID

    private String name; // 대표자명
    private String idNumber; // 대표자 주민번호
    private boolean foreign; // 대표자 외국인여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;
        private String companyId;

        private String name;
        private String idNumber;
        private boolean foreign;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder companyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder idNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Builder foreign(boolean foreign) {
            this.foreign = foreign;
            return this;
        }

        public Representative build() {
            return new Representative(this);
        }
    } // end of Builder

    private Representative(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.companyId = builder.companyId;
        this.name = builder.name;
        this.idNumber = builder.idNumber;
        this.foreign = builder.foreign;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .companyId(this.companyId)
                .name(this.name)
                .idNumber(this.idNumber)
                .foreign(this.foreign);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public boolean isForeign() {
        return foreign;
    }
}
