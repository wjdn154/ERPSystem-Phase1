package com.erp.system.hr.model.salary_information_management;

//연금 정보 테이블
// 연금 관련 정보를 저장

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

import java.math.BigDecimal;
@EnumMapping
public class Pension {
    public enum PensionType{NATIONAL_PENSION, RETIREMENT_PENSION, PERSONAL_PENSION}

    @Unique
    @NotNull
    private final String id; // 연금 정보 고유 식별자 ID

    @NotNull
    private PensionType pensionType; // 연금 종류 ( 예 : 국민연금, 퇴직연금, 개인 연금)
    @NotNull
    private BigDecimal contribution; // 연금 기여 금액
    private String description; // 연금에 대한 설명, 비고 사항

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private PensionType pensionType;
        private BigDecimal contribution;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder pensionType(PensionType pensionType) {
            this.pensionType = pensionType;
            return this;
        }

        public Builder contribution(BigDecimal contribution) {
            this.contribution = contribution;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
    }//end of Builder

    private Pension(Builder builder){
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.pensionType = builder.pensionType;
        this.contribution = builder.contribution;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild(){
        return new Builder()
                .id(this.id)
                .pensionType(this.pensionType)
                .contribution(this.contribution)
                .description(this.description);
    }

    public String getId() {return id;}

    public PensionType getPensionType() {return pensionType;}

    public BigDecimal getContribution() {return contribution;}

    public String getDescription() {return description;}

    @Override
    public String toString() {
        return "Pension{" +
                "id='" + id + '\'' +
                ", pensionType='" + pensionType + '\'' +
                ", contribution=" + contribution +
                ", description='" + description + '\'' +
                '}';
    }
}
