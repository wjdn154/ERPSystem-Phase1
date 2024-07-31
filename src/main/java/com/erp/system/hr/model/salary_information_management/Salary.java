package com.erp.system.hr.model.salary_information_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

// 급여 등록 테이블

public class Salary {
    @Unique
    @NotNull
    private final String id; // 급여 고유 식별 ID
    @NotNull
    private String salaryTypeId; // 급여 유형 ID 참조

    @NotNull
    private BigDecimal baseSalary; // 기본 급여
    @NotNull
    private BigDecimal bonus; // 보너스
    @NotNull
    private LocalDate payDate; // 지급일

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String salaryTypeId;

        private BigDecimal baseSalary;
        private BigDecimal bonus;
        private LocalDate payDate;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder salaryTypeId(String salaryTypeId){
            this.salaryTypeId = salaryTypeId;
            return this;
        }

        public Builder baseSalary(BigDecimal baseSalary){
            this.baseSalary = baseSalary;
            return this;
        }

        public Builder bonus(BigDecimal bonus){
            this.bonus = bonus;
            return this;
        }

        public Builder payDate(LocalDate payDate){
            this.payDate = payDate;
            return this;
        }
    }//end of Builder
        private Salary(Builder builder){
            this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
            this.salaryTypeId = builder.salaryTypeId;
            this.baseSalary = builder.baseSalary;
            this.bonus = builder.bonus;
            this.payDate = builder.payDate;
            NotNullValidator.validateFields(this);
        }
        public Builder tobuild(){
            return new Builder()
                .id(this.id)
                .salaryTypeId(this.salaryTypeId)
                .baseSalary(this.baseSalary)
                .bonus(this.bonus)
                .payDate(this.payDate);
    }
    public String getId() {return id;}

    public String getSalaryTypeId() { return salaryTypeId;}

    public BigDecimal geBaseSalary() {return baseSalary;}

    public BigDecimal getBonus() {return bonus;}

    public LocalDate getPayDate() {return payDate;}

    @Override
    public String toString() {
        return "Salary{" +
                "id='" + id + '\'' +
                ", salaryTypeId='" + salaryTypeId + '\'' +
                ", baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                ", payDate=" + payDate +
                '}';
    }
}
