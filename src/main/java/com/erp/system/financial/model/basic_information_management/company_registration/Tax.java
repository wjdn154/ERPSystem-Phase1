package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 세무 정보 테이블
 * 회사와 연결될 세무정보 데이터 테이블
 * 
 */
public class Tax {
    private final String id; // 고유식별자
    private final String code; // 세무 정보 코드
    private final String companyId; // 연결된 회사 ID
    private final String businessTaxOfficeId; // 사업장관할세무서 ID
    private final String headquartersTaxOfficeId; // 본점관할세무서 ID
    private final String localCorporateTaxCategoryId; // 지방세법인구분 ID

    private String localIncomeTaxOffice; // 지방소득세납세지

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;
        private String companyId;
        private String businessTaxOfficeId;
        private String headquartersTaxOfficeId;
        private String localCorporateTaxCategoryId;

        private String localIncomeTaxOffice;

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

        public Builder businessTaxOfficeId(String businessTaxOfficeId) {
            this.businessTaxOfficeId = businessTaxOfficeId;
            return this;
        }

        public Builder headquartersTaxOfficeId(String headquartersTaxOfficeId) {
            this.headquartersTaxOfficeId = headquartersTaxOfficeId;
            return this;
        }

        public Builder localCorporateTaxCategoryId(String localCorporateTaxCategoryId) {
            this.localCorporateTaxCategoryId = localCorporateTaxCategoryId;
            return this;
        }

        public Builder localIncomeTaxOffice(String localIncomeTaxOffice) {
            this.localIncomeTaxOffice = localIncomeTaxOffice;
            return this;
        }

        public Tax build() {
            return new Tax(this);
        }
    }// end of Builder

    private Tax(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.companyId = builder.companyId;
        this.businessTaxOfficeId = builder.businessTaxOfficeId;
        this.headquartersTaxOfficeId = builder.headquartersTaxOfficeId;
        this.localCorporateTaxCategoryId = builder.localCorporateTaxCategoryId;
        this.localIncomeTaxOffice = builder.localIncomeTaxOffice;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .companyId(this.companyId)
                .businessTaxOfficeId(this.businessTaxOfficeId)
                .headquartersTaxOfficeId(this.headquartersTaxOfficeId)
                .localCorporateTaxCategoryId(this.localCorporateTaxCategoryId)
                .localIncomeTaxOffice(this.localIncomeTaxOffice);
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

    public String getBusinessTaxOfficeId() {
        return businessTaxOfficeId;
    }

    public String getHeadquartersTaxOfficeId() {
        return headquartersTaxOfficeId;
    }

    public String getLocalCorporateTaxCategoryId() {
        return localCorporateTaxCategoryId;
    }

    public String getLocalIncomeTaxOffice() {
        return localIncomeTaxOffice;
    }
}
