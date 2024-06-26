package com.erp.system.financial.model.basic_information_management.account_information;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 은행 거래 테이블
 * 은행 거래에 대한 정보가 있는 테이블
 */
public class BankTransaction {
    @NotNull
    private final String id; // 은행 거래의 고유식별자
    @NotNull
    private final String accountId; // 계좌 코드 참조

    @NotNull
    private String bankName; // 거래 은행명
    @NotNull
    private String type; // 거래 유형
    @NotNull
    private BigDecimal amount; // 거래 금액
    @NotNull
    private LocalDate date; // 거래 날짜
    @NotNull
    private BigDecimal currentBalance; // 현재 잔액

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String accountId;

        private String bankName;
        private String type;
        private BigDecimal amount;
        private LocalDate date;
        private BigDecimal currentBalance;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
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
        this.accountId = builder.accountId;
        this.bankName = builder.bankName;
        this.type = builder.type;
        this.amount = builder.amount;
        this.date = builder.date;
        this.currentBalance = builder.currentBalance;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .accountId(this.accountId)
                .bankName(this.bankName)
                .type(this.type)
                .amount(this.amount)
                .date(this.date)
                .currentBalance(this.currentBalance);
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
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
