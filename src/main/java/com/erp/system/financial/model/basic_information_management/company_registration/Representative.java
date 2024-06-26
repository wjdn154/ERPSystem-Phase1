package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 회사 대표자 정보 테이블
 * 회사 등록시 필요한 대표자 데이터 테이블
 */
public class Representative {
    @NotNull
    private final String id; // 고유 식별자
    @NotNull
    private final String companyId; // 연결된 회사 ID

    @NotNull
    private String name; // 대표자명
    @NotNull
    private String idNumber; // 대표자 주민번호
    @NotNull
    private boolean foreign; // 대표자 외국인여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String companyId;

        private String name;
        private String idNumber;
        private boolean foreign;

        public Builder id(String id) {
            this.id = id;
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
        this.companyId = builder.companyId;
        this.name = builder.name;
        this.idNumber = builder.idNumber;
        this.foreign = builder.foreign;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .companyId(this.companyId)
                .name(this.name)
                .idNumber(this.idNumber)
                .foreign(this.foreign);
    }

    public String getId() {
        return id;
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
