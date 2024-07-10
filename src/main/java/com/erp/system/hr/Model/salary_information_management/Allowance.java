package com.erp.system.hr.Model.salary_information_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

// 수당 정보 테이블

public class Allowance {
    @Unique
    @NotNull
    private final String id; // 수당 id

    @NotNull
    private String allowanceType; // 수당 종류
    @NotNull
    private BigDecimal amount; // 수당 금액
    @NotNull
    private LocalDate issueDate; // 수당 지급 날짜
    private String description; // 수당 설명
    private String approvalStatus; // 수당 상태

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String allowanceType;
        private BigDecimal amount;
        private LocalDate issueDate;
        private String description;
        private String approvalStatus;

        public Builder id(String id){
            this.id = id;
            return this;
        }

        public Builder allowanceType(String allowanceType){
            this.allowanceType = allowanceType;
            return this;
        }

        public Builder amount(BigDecimal amount){
            this.amount = amount;
            return this;
        }

        public Builder issueDate(LocalDate issueDate){
            this.issueDate = issueDate;
            return this;
        }

        public Builder description(String description){
            this.description = description;
            return this;
        }

        public Builder approvalStatus(String approvalStatus){
            this.approvalStatus = approvalStatus;
            return this;
        }
    }//end of Builder
        private Allowance(Builder builder){
            this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
            this.allowanceType = builder.allowanceType;
            this.amount = builder.amount;
            this.issueDate = builder.issueDate;
            this.description = builder.description;
            this.approvalStatus = builder.approvalStatus;
            NotNullValidator.validateFields(this);
        }
        public Builder tobuild(){
            return new Builder()
                .id(this.id)
                .allowanceType(this.allowanceType)
                .amount(this.amount)
                .issueDate(this.issueDate)
                .description(this.description)
                .approvalStatus(this.approvalStatus);
        }
    public String getId() {return id;}
    public String getAllowanceType() {return allowanceType;}
    public BigDecimal getAmount() {return amount;}
    public LocalDate getIssueDate() {return issueDate;}
    public String getDescription() {return description;}
    public String getApprovalStatus() {return approvalStatus;}


    @Override
    public String toString() {
        return "Allowance{" +
                "id='" + id + '\'' +
                ", allowanceType='" + allowanceType + '\'' +
                ", amount=" + amount +
                ", issueDate=" + issueDate +
                ", description='" + description + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
