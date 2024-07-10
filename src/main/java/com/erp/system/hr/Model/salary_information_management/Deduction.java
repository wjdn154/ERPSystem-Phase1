package com.erp.system.hr.Model.salary_information_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

import java.math.BigDecimal;
import java.util.Date;

// 공제 정보 테이블

public class Deduction {
    @Unique
    @NotNull
    private final String id; // 공제 정보 고유 식별자

    @NotNull
    private String deductionType; // 공제 항목 종류
    @NotNull
    private BigDecimal amount; // 공제 금액
    @NotNull
    private String description; // 공제 항목 설명
    @NotNull
    private Date deductionDate; // 공제 날짜

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String deductionType;
        private BigDecimal amount;
        private String description;
        private Date deductionDate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }


        public Builder deductionType(String deductionType) {
            this.deductionType = deductionType;
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

        public Builder deductionDate(Date deductionDate) {
            this.deductionDate = deductionDate;
            return this;
        }
    }//end of Builder
    private Deduction(Builder builder){
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.deductionType = builder.deductionType;
        this.amount = builder.amount;
        this.description = builder.description;
        this.deductionDate = builder.deductionDate;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild(){
        return new Builder()
                .id(this.id)
                .deductionType(this.deductionType)
                .amount(this.amount)
                .description(this.description)
                .deductionDate(this.deductionDate);
    }

    public String getId() {return id;}

    public String getDeductionType() {return deductionType;}

    public BigDecimal getAmount() {return amount;}

    public String getDescription() {return description;}

    public Date getDeductionDate() {return deductionDate;}

    @Override
    public String toString() {
        return "Deduction{" +
                "id='" + id + '\'' +
                ", deductionType='" + deductionType + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", deductionDate=" + deductionDate +
                '}';
    }
}
