package com.erp.system.financial.model.basic_information_management.account_information;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 예적금 현황 테이블
 * 예적금 현황에 대한 정보가 있는 테이블
 */
public class Deposit {
    private final String id; // 고유 식별자
    private final String code;
    private final String accountCode; // 은행계좌 코드 참조

    private LocalDate maturityDate; // 적금 만기 날짜
    private BigDecimal interestRate; // 이자율

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;
        private String accountCode;

        private LocalDate maturityDate;
        private BigDecimal interestRate;

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

        public Builder maturityDate(LocalDate maturityDate) {
            this.maturityDate = maturityDate;
            return this;
        }

        public Builder interestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Deposit build() {
            return new Deposit(this);
        }
    }

    private Deposit(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.accountCode = builder.accountCode;
        this.maturityDate = builder.maturityDate;
        this.interestRate = builder.interestRate;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .accountCode(this.accountCode)
                .maturityDate(this.maturityDate)
                .interestRate(this.interestRate);
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

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }
}
