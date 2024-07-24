package com.erp.system.hr.Model.salary_information_management;

// 보험 정보 테이블
// 직원이 가입한 보험에 관한 정보를 저장

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

import java.math.BigDecimal;

@EnumMapping
public class Insurance {
    public enum InsuranceType{Health_Insurance, Supplementary_Health_Insurance, Life_Insurance,Auto_Insurance,Home_Insurance}

    @Unique
    @NotNull
    private final String id; // 보험 정보 ID

    @NotNull
    private InsuranceType insuranceType; // 보험 종류 ( 예 : 건강보험, 실손보험 등)
    @NotNull
    private BigDecimal preminum; // 보험료
    private String coverage; // 보장 내용 설명 ( 예 : 보험 가입자가 보장받는 손해나 손실의 범위와 종류 내용)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private InsuranceType insuranceType;
        private BigDecimal preminum;
        private String coverage;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder insuranceType(InsuranceType insuranceType) {
            this.insuranceType = insuranceType;
            return this;
        }

        public Builder preminum(BigDecimal preminum) {
            this.preminum = preminum;
            return this;
        }

        public Builder coverage(String coverage) {
            this.coverage = coverage;
            return this;
        }
        public Insurance build() {
            return new Insurance(this);
        }
    }//end of Builder

    private Insurance(Builder builder){
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.insuranceType = builder.insuranceType;
        this.preminum = builder.preminum;
        this.coverage = builder.coverage;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild(){
        return new Builder()
                .id(this.id)
                .insuranceType(this.insuranceType)
                .preminum(this.preminum)
                .coverage(this.coverage);
    }

    public String getId() {return id;}

    public InsuranceType getInsuranceType() {return insuranceType;}

    public BigDecimal getPreminum() {return preminum;}

    public String getCoverage() {return coverage;}

    @Override
    public String toString() {
        return "Insurance{" +
                "id='" + id + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", preminum=" + preminum +
                ", coverage='" + coverage + '\'' +
                '}';
    }
}
