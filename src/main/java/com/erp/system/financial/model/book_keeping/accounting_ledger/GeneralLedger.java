package com.erp.system.financial.model.book_keeping.accounting_ledger;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * 총계정원장 테이블
 * 장부관리 탭에서 총계정원장 데이터 테이블
 */
public class GeneralLedger {
    @NotNull
    private final String id; // 고유 식별자
    @NotNull
    private final String accountId; // 계정과목 코드

    @NotNull
    private LocalDate date; // 거래 날짜
    @NotNull
    private BigDecimal openingBalance; // 개시 잔액
    @NotNull
    private BigDecimal debits; // 차변 금액
    @NotNull
    private BigDecimal credits; // 대변 금액
    @NotNull
    private BigDecimal closingBalance; // 마감 잔액
    @NotNull
    private Timestamp updatedAt; // 최종 업데이트 시각

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String accountId;

        private LocalDate date;
        private BigDecimal openingBalance;
        private BigDecimal debits;
        private BigDecimal credits;
        private BigDecimal closingBalance;
        private Timestamp updatedAt;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder openingBalance(BigDecimal openingBalance) {
            this.openingBalance = openingBalance;
            return this;
        }

        public Builder debits(BigDecimal debits) {
            this.debits = debits;
            return this;
        }

        public Builder credits(BigDecimal credits) {
            this.credits = credits;
            return this;
        }

        public Builder closingBalance(BigDecimal closingBalance) {
            this.closingBalance = closingBalance;
            return this;
        }

        public Builder updatedAt(Timestamp updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public GeneralLedger build() {
            return new GeneralLedger(this);
        }
    }

    private GeneralLedger(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.accountId = builder.accountId;
        this.date = builder.date;
        this.openingBalance = builder.openingBalance;
        this.debits = builder.debits;
        this.credits = builder.credits;
        this.closingBalance = builder.closingBalance;
        this.updatedAt = builder.updatedAt;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .accountId(this.accountId)
                .date(this.date)
                .openingBalance(this.openingBalance)
                .debits(this.debits)
                .credits(this.credits)
                .closingBalance(this.closingBalance)
                .updatedAt(this.updatedAt);
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getOpeningBalance() {
        return openingBalance;
    }

    public BigDecimal getDebits() {
        return debits;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public BigDecimal getClosingBalance() {
        return closingBalance;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}
