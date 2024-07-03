package com.erp.system.financial.model.basic_information_management.account_information;

import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 예적금 현황 테이블
 * 예적금 현황에 대한 정보가 있는 테이블
 */
public class Deposit {
    @Unique
    @NotNull
    private final String id; // 고유 식별자
    @NotNull
    private final String accountId; // 은행계좌 코드 참조

    private LocalDate maturityDate; // 적금 만기 날짜
    private BigDecimal interestRate; // 이자율

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String accountId;

        private LocalDate maturityDate;
        private BigDecimal interestRate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
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
        this.accountId = builder.accountId;
        this.maturityDate = builder.maturityDate;
        this.interestRate = builder.interestRate;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .accountId(this.accountId)
                .maturityDate(this.maturityDate)
                .interestRate(this.interestRate);
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", maturityDate=" + maturityDate +
                ", interestRate=" + interestRate +
                '}';
    }
}
