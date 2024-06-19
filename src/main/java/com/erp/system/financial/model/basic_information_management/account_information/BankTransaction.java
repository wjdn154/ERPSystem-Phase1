package com.erp.system.financial.model.basic_information_management.account_information;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 은행 거래 테이블
 * 은행 거래에 대한 정보가 있는 테이블
 */
public class BankTransaction {
    private final String id; // 은행 거래의 고유식별자
    private final String code; // 코드번호
    private final String accountCode; // 계좌 코드 참조

    private String bankName; // 거래 은행명
    private String type; // 거래 유형
    private BigDecimal amount; // 거래 금액
    private LocalDate date; // 거래 날짜
    private BigDecimal currentBalance; // 현재 잔액

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;
        private String accountCode;

        private String bankName;
        private String type;
        private BigDecimal amount;
        private LocalDate date;
        private BigDecimal currentBalance;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder accountCode(String accountCode) {
            this.accountCode = accountCode;
            return this;
        }


        public Builder bankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder currentBalance(BigDecimal currentBalance) {
            this.currentBalance = currentBalance;
            return this;
        }

        public BankTransaction build() {
            return new BankTransaction(this);
        }
    }

    private BankTransaction(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.accountCode = builder.accountCode;
        this.bankName = builder.bankName;
        this.type = builder.type;
        this.amount = builder.amount;
        this.date = builder.date;
        this.currentBalance = builder.currentBalance;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .accountCode(this.accountCode)
                .bankName(this.bankName)
                .type(this.type)
                .amount(this.amount)
                .date(this.date)
                .currentBalance(this.currentBalance);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public String getBankName() {
        return bankName;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }
}
