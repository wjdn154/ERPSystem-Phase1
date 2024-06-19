package com.erp.system.financial.model.book_keeping.accounting_ledger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 현금출납장 테이블
 * 장부관리 탭 현급출납장 데이터 테이블
 */
public class CashBook {
    private final String id; // 고유 식별자
    private final String code;
    private final String transactionCode; // 거래코드 참조키
    private final String memosCode; // 적요 코드 참조키
    private final String vendorCode; // 거래처 코드 참조키

    private BigDecimal debit; // 입금 금액
    private BigDecimal credit; // 출금 금액
    private BigDecimal balanceForward; // 이월 금액
    private LocalDate date; // 거래 날짜

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String code;
        private String transactionCode;
        private String memosCode;
        private String vendorCode;

        private BigDecimal debit;
        private BigDecimal credit;
        private BigDecimal balanceForward;
        private LocalDate date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder transactionCode(String transactionCode) {
            this.transactionCode = transactionCode;
            return this;
        }

        public Builder memosCode(String memosCode) {
            this.memosCode = memosCode;
            return this;
        }

        public Builder vendorCode(String vendorCode) {
            this.vendorCode = vendorCode;
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

        public Builder balanceForward(BigDecimal balanceForward) {
            this.balanceForward = balanceForward;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public CashBook build() {
            return new CashBook(this);
        }
    }

    private CashBook(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.transactionCode = builder.transactionCode;
        this.memosCode = builder.memosCode;
        this.vendorCode = builder.vendorCode;
        this.debit = builder.debit;
        this.credit = builder.credit;
        this.balanceForward = builder.balanceForward;
        this.date = builder.date;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .transactionCode(this.transactionCode)
                .memosCode(this.memosCode)
                .vendorCode(this.vendorCode)
                .debit(this.debit)
                .credit(this.credit)
                .balanceForward(this.balanceForward)
                .date(this.date);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public String getMemosCode() {
        return memosCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public BigDecimal getBalanceForward() {
        return balanceForward;
    }

    public LocalDate getDate() {
        return date;
    }
}
