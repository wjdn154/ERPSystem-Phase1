package com.erp.system.financial.model.basic_information_management.account_information;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.time.LocalDate;

/**
 * 은행 계좌 테이블
 * 은행 계좌에대한 정보가 있는 테이블
 */
public class BankAccount {
    @NotNull
    private final String id; // 계좌의 고유 식별자
    @NotNull
    private final String ERPCompanyId; // ERP 사용자 계정 회사 ID

    @NotNull
    private LocalDate openingDate; // 개설일
    @NotNull
    private String bankName; // 은행명
    @NotNull
    private String branchLocation; // 계좌계설지점
    @Unique
    @NotNull
    private String number; // 계좌번호
    @NotNull
    private String owner; // 계좌 소유자
    @NotNull
    private String depositType; // 예금종류

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String ERPCompanyId;

        private LocalDate openingDate;
        private String bankName;
        private String branchLocation;
        private String number;
        private String owner;
        private String depositType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder ERPCompanyId(String erp_company_id) {
            this.ERPCompanyId = erp_company_id;
            return this;
        }

        public Builder openingDate(LocalDate opening_date) {
            this.openingDate = opening_date;
            return this;
        }

        public Builder bankName(String bank_name) {
            this.bankName = bank_name;
            return this;
        }

        public Builder branchLocation(String branch_location) {
            this.branchLocation = branch_location;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder owner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder depositType(String deposit_type) {
            this.depositType = deposit_type;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }// end of Builder

    private BankAccount(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.ERPCompanyId = builder.ERPCompanyId;
        this.openingDate = builder.openingDate;
        this.bankName = builder.bankName;
        this.branchLocation = builder.branchLocation;
        this.number = builder.number;
        this.owner = builder.owner;
        this.depositType = builder.depositType;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .bankName(this.bankName)
                .branchLocation(this.branchLocation)
                .openingDate(this.openingDate)
                .number(this.number)
                .owner(this.owner)
                .depositType(this.depositType);
    }

    public String getId() {
        return id;
    }

    public String getERPCompanyId() {
        return ERPCompanyId;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public String getDepositType() {
        return depositType;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id='" + id + '\'' +
                ", ERPCompanyId='" + ERPCompanyId + '\'' +
                ", openingDate=" + openingDate +
                ", bankName='" + bankName + '\'' +
                ", branchLocation='" + branchLocation + '\'' +
                ", number='" + number + '\'' +
                ", owner='" + owner + '\'' +
                ", depositType='" + depositType + '\'' +
                '}';
    }
}
