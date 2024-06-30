package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 세무서 테이블
 * 회사와 연결될 세무서 정보 데이터 테이블
 * 
 */
public class TaxOffice {
    @NotNull
    private final String id; // 고유식별자
    @NotNull
    private final String name; // 세무서명
    @NotNull
    private final String region; // 세무서 지역

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;
        private String region;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public TaxOffice build() {
            return new TaxOffice(this);
        }

    }// end of Builder

    private TaxOffice(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.region = builder.region;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .region(this.region);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }


    @Override
    public String toString() {
        return "TaxOffice{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
