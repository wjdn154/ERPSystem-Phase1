package com.erp.system.hr.Model.salary_information_management;


import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

// 급여 명세서 테이블

public class PayrollStatement {
    @Unique
    @NotNull
    private final String id; // 급여 명세서 식별자

    @NotNull
    private LocalDate payDate; // 급여 지급 일자
    @NotNull
    private BigDecimal baseSalary; // 기본 급여
    @NotNull
    private BigDecimal bonus; // 보너스 금액
    @NotNull
    private BigDecimal deductions; // 공제 금액
    @NotNull
    private BigDecimal netSalary; // 공제 후 순수 급여
    private String remarks; // 기타 비고 사항

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private LocalDate payDate;
        private BigDecimal baseSalary;
        private BigDecimal bonus;
        private BigDecimal deductions;
        private BigDecimal netSalary;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder payDate(LocalDate payDate){
            this.payDate = payDate;
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

        public Builder deductions(BigDecimal deductions){
            this.deductions = deductions;
            return this;
        }

        public Builder netSalary(BigDecimal netSalary){
            this.netSalary = netSalary;
            return this;
        }

        public Builder remarks(String remarks){
            this.remarks = remarks;
            return this;
        }
    }//end of Builder

    private PayrollStatement(Builder builder){
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.payDate = builder.payDate;
        this.baseSalary = builder.baseSalary;
        this.bonus = builder.bonus;
        this.deductions = builder.deductions;
        this.netSalary = builder.netSalary;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild(){
        return new Builder()
                .id(this.id)
                .payDate(this.payDate)
                .baseSalary(this.baseSalary)
                .bonus(this.bonus)
                .deductions(this.deductions)
                .netSalary(this.netSalary)
                .remarks(this.remarks);

    }
    public String getId() {return id;}
    public LocalDate getPayDate() {return payDate;}
    public BigDecimal getBaseSalary() {return baseSalary;}
    public BigDecimal getBonus() {return bonus;}
    public BigDecimal getDeductions() {return deductions;}
    public BigDecimal getNetSalary() {return netSalary;}
    public String getRemarks() {return remarks;}

    @Override
    public String toString() {
        return "PayrollStatement{" +
                "id='" + id + '\'' +
                ", payDate=" + payDate +
                ", baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                ", deductions=" + deductions +
                ", netSalary=" + netSalary +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
