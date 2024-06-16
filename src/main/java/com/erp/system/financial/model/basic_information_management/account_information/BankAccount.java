package com.erp.system.financial.model.basic_information_management.account_information;

import java.util.Date;
import java.util.UUID;

/**
 * 은행 계좌 테이블
 * 은행 계좌에대한 정보가 있는 테이블
 */
public class BankAccount {
    private final String id; // 계좌의 고유 식별자
    private final String code; // 계좌 코드

    private Date opening_date; // 개설일
    private String bank_name; // 은행명
    private String branch_location; // 계좌계설지점
    private String number; // 계좌번호
    private String owner; // 계좌 소유자
    private String deposit_type; // 예금종류

    public static class Builder {
        private final String id;
        private final String code;

        private Date opening_date;
        private String bank_name;
        private String branch_location;
        private String number;
        private String owner;
        private String deposit_type;

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        public Builder opening_date(Date opening_date) {
            this.opening_date = opening_date;
            return this;
        }

        public Builder bank_name(String bank_name) {
            this.bank_name = bank_name;
            return this;
        }

        public Builder branch_location(String branch_location) {
            this.branch_location = branch_location;
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

        public Builder deposit_type(String deposit_type) {
            this.deposit_type = deposit_type;
            return this;
        }

        public BankAccount build() {
            return new BankAccount(this);
        }
    }// end of Builder

    private BankAccount(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.opening_date = builder.opening_date;
        this.bank_name = builder.bank_name;
        this.branch_location = builder.branch_location;
        this.number = builder.number;
        this.owner = builder.owner;
        this.deposit_type = builder.deposit_type;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Date getOpening_date() {
        return opening_date;
    }

    public String getBank_name() {
        return bank_name;
    }

    public String getBranch_location() {
        return branch_location;
    }

    public String getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }

    public String getDeposit_type() {
        return deposit_type;
    }
}
