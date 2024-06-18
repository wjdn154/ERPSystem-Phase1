package com.erp.system.financial.model.basic_information_management.account_information;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 은행 계좌 테이블
 * 은행 계좌에대한 정보가 있는 테이블
 */
public class BankAccount {
    private final String id; // 계좌의 고유 식별자
    private final String code; // 계좌 코드

    private  LocalDate openingDate; // 개설일
    private  String bankName; // 은행명
    private  String branchLocation; // 계좌계설지점
    private  String number; // 계좌번호
    private  String owner; // 계좌 소유자
    private  String depositType; // 예금종류

    public static int id_index = 1;

    public static class Builder {
        private String id;
        private String code;

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

        public Builder code(String code) {
            this.code = code;
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

        public BankAccount.Builder update(BankAccount test) {
            return this;
        }
    }// end of Builder

    private BankAccount(Builder builder) {
        if(builder.id != null) {
            this.id = builder.id;
        }
        else {
            this.id = Integer.toString(id_index++);
        }
        this.code = builder.code;
        this.openingDate = builder.openingDate;
        this.bankName = builder.bankName;
        this.branchLocation = builder.branchLocation;
        this.number = builder.number;
        this.owner = builder.owner;
        this.depositType = builder.depositType;
    }

    public Builder toBuilder() {
        return new Builder()
                .id(this.id)
                .code(this.code)
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

    public String getCode() {
        return code;
    }

    public LocalDate getOpening_date() {
        return openingDate;
    }

    public String getBank_name() {
        return bankName;
    }

    public String getBranch_location() {
        return branchLocation;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public String getDeposit_type() {
        return depositType;
    }
}