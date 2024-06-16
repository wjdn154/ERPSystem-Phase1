package com.erp.system.financial.model.book_keeping.accounting_ledger;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * 총계정원장 테이블
 * 장부관리 탭에서 총계정원장 데이터 테이블
 */
public class GeneralLedger {
    private final String id; // 고유 식별자
    private final String account_code; // 계정과목 코드

    private Date date; // 거래 날짜
    private BigDecimal opening_balance; // 개시 잔액
    private BigDecimal debits; // 차변 금액
    private BigDecimal credits; // 대변 금액
    private BigDecimal closing_balance; // 마감 잔액
    private Timestamp updated_at; // 최종 업데이트 시각

    public static class Builder {
        private final String id;
        private final String account_code;

        private Date date;
        private BigDecimal opening_balance;
        private BigDecimal debits;
        private BigDecimal credits;
        private BigDecimal closing_balance;
        private Timestamp updated_at;

        public Builder(String account_code) {
            this.id = UUID.randomUUID().toString();
            this.account_code = account_code;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder opening_balance(BigDecimal opening_balance) {
            this.opening_balance = opening_balance;
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

        public Builder closing_balance(BigDecimal closing_balance) {
            this.closing_balance = closing_balance;
            return this;
        }

        public Builder updated_at(Timestamp updated_at) {
            this.updated_at = updated_at;
            return this;
        }

        public GeneralLedger build() {
            return new GeneralLedger(this);
        }
    }

    private GeneralLedger(Builder builder) {
        this.id = builder.id;
        this.account_code = builder.account_code;
        this.date = builder.date;
        this.opening_balance = builder.opening_balance;
        this.debits = builder.debits;
        this.credits = builder.credits;
        this.closing_balance = builder.closing_balance;
        this.updated_at = builder.updated_at;
    }

    public String getId() {
        return id;
    }

    public String getAccount_code() {
        return account_code;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getOpening_balance() {
        return opening_balance;
    }

    public BigDecimal getDebits() {
        return debits;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public BigDecimal getClosing_balance() {
        return closing_balance;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }
}
