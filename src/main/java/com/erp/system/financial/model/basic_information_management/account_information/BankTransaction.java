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
    private String type; // 거래 유형
    @NotNull
    private LocalDate date; // 거래 날짜
    private String description; // 거래 내용
    @NotNull
    private BigDecimal debit; // 차변 금액
    @NotNull
    private BigDecimal carriedOverDebit; // 이월 차변금액
    @NotNull
    private BigDecimal credit; // 대변 금액
    @NotNull
    private BigDecimal carriedOverCredit; // 이월 대변금액
    @NotNull
    private BigDecimal currentBalance; // 현재 잔액

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String accountId;

        private String type;
        private String description;
        private LocalDate date;
        private BigDecimal debit;
        private BigDecimal carriedOverDebit;
        private BigDecimal credit;
        private BigDecimal carriedOverCredit;
        private BigDecimal currentBalance;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder carriedOverDebit(BigDecimal carriedOverDebit) {
            this.carriedOverDebit = carriedOverDebit;
            return this;
        }
        public Builder debit(BigDecimal debit) {
            this.debit = debit;
            return this;
        }

        public Builder credit(BigDecimal credit) {
            this.credit = credit;
            return this;
        }
        public Builder carriedOverCredit(BigDecimal carriedOverCredit) {
            this.carriedOverCredit = carriedOverCredit;
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
        this.type = builder.type;
        this.date = builder.date;
        this.description = builder.description;
        this.debit = builder.debit;
        this.carriedOverDebit = builder.carriedOverDebit;
        this.credit = builder.credit;
        this.carriedOverCredit = builder.carriedOverCredit;
        this.currentBalance = builder.currentBalance;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .accountId(this.accountId)
                .type(this.type)
                .date(this.date)
                .description(this.description)
                .debit(this.debit)
                .carriedOverDebit(this.carriedOverDebit)
                .credit(this.credit)
                .carriedOverCredit(this.carriedOverCredit)
                .currentBalance(this.currentBalance);
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public BigDecimal getCarriedOverDebit() {
        return carriedOverDebit;
    }

    public BigDecimal getCredit() {
        return credit;
    }
    public BigDecimal getCarriedOverCredit() {
        return carriedOverCredit;
    }


    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", debit=" + debit +
                ", carriedOverDebit=" + carriedOverDebit +
                ", credit=" + credit +
                ", carriedOverCredit=" + carriedOverCredit +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
