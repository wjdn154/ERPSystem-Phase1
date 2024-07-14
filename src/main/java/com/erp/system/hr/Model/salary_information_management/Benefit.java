package com.erp.system.hr.Model.salary_information_management;

// 복리후생 등록 테이블

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.hr.Model.basic_information_management.Position;

import java.math.BigDecimal;

public class Benefit {
    @Unique
    @NotNull
    private final String id; // 복리후생 정보 고유 식별자
    @NotNull
    private String benefitTypeId; // 복리후생 종류 테이블 ID 참조

    @NotNull
    private BigDecimal amount; // 복리후생 금액
    private String description; // 복리후생에 대한 설명이나 비고 사항

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String benefitTypeId;

        private BigDecimal amount;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder benefitTypeId(String benefitTypeId) {
            this.benefitTypeId = benefitTypeId;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
    }//end of Builider
    private Benefit(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.benefitTypeId = builder.benefitTypeId;
        this.amount = builder.amount;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .benefitTypeId(this.benefitTypeId)
                .amount(this.amount)
                .description(this.description);

    }

    public String getId() {return id;}

    public String getBenefitType() {return benefitTypeId;}

    public BigDecimal getAmount() {return  amount;}

    public String getDescription() {return description;}

    @Override
    public String toString() {
        return "Benefit{" +
                "id='" + id + '\'' +
                ", benefitTypeId='" + benefitTypeId + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
