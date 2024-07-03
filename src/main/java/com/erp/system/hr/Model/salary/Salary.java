package com.erp.system.hr.Model.salary;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
import java.util.Date;

// 급여 테이블

public class Salary {
    @NotNull
    private final String id; // 급여 고유 식별 ID

    @NotNull
    private String baseSalary; // 기본 급여
    @NotNull
    private BigDecimal bonus; // 보너스
    @NotNull
    private String payDate; // 지급일

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String baseSalary;
        private BigDecimal bonus;
        private String payDate;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder baseSalary(String baseSalary){
            this.baseSalary = baseSalary;
            return this;
        }

        public Builder bonus(BigDecimal bonus){
            this.bonus = bonus;
            return this;
        }

        public Builder payDate(String payDate){
            this.payDate = payDate;
            return this;
        }
    }//end of Builder
        private Salary(Builder builder){
            this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
            this.baseSalary = builder.baseSalary;
            this.bonus = builder.bonus;
            this.payDate = builder.payDate;
            NotNullValidator.safeValidateFields(this);
        }
        public Builder tobuild(){
            return new Builder()
                .id(this.id)
                .baseSalary(this.baseSalary)
                .bonus(this.bonus)
                .payDate(this.payDate);
    }
    public String getId() {return id;}
    public String geBaseSalary() {return baseSalary;}
    public BigDecimal getBonus() {return bonus;}
    public String getPayDate() {return payDate;}
}
