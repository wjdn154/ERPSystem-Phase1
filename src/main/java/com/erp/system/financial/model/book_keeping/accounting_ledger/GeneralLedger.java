package com.erp.system.financial.model.book_keeping.accounting_ledger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 총계정원장 테이블
 * 장부관리 탭에서 총계정원장 데이터 테이블
 */
public class GeneralLedger {
    private final String id; // 고유 식별자
    private final String code; // 총계정원장 코드
    private final String accountCode; // 계정과목 코드

    private LocalDate date; // 거래 날짜
    private BigDecimal openingBalance; // 개시 잔액
    private BigDecimal debits; // 차변 금액
    private BigDecimal credits; // 대변 금액
    private BigDecimal closingBalance; // 마감 잔액
    private Timestamp updatedAt; // 최종 업데이트 시각

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String code;
        private String accountCode;

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

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder accountCode(String accountCode) {
            this.accountCode = accountCode;
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
        this.code = builder.code;
        this.accountCode = builder.accountCode;
        this.date = builder.date;
        this.openingBalance = builder.openingBalance;
        this.debits = builder.debits;
        this.credits = builder.credits;
        this.closingBalance = builder.closingBalance;
        this.updatedAt = builder.updatedAt;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .accountCode(this.accountCode)
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

    public String getCode() {
        return code;
    }

    public String getAccountCode() {
        return accountCode;
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
