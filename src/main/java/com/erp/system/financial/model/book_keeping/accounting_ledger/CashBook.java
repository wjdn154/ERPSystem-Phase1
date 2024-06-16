package com.erp.system.financial.model.book_keeping.accounting_ledger;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 현금출납장 테이블
 * 장부관리 탭 현급출납장 데이터 테이블
 */
public class CashBook {
    private final String id; // 고유 식별자
    private final String code;
    private final String transaction_code; // 거래코드 참조키
    private final String memos_code; // 적요 코드 참조키
    private final String vendor_code; // 거래처 코드 참조키

    private BigDecimal debit; // 입금 금액
    private BigDecimal credit; // 출금 금액
    private BigDecimal balance_forward; // 이월 금액
    private Date date; // 거래 날짜

    public static class Builder {
        private final String id;
        private final String code;
        private final String transaction_code;
        private final String memos_code;
        private final String vendor_code;

        private BigDecimal debit;
        private BigDecimal credit;
        private BigDecimal balance_forward;
        private Date date;

        public Builder(String code, String transaction_code, String memos_code, String vendor_code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.transaction_code = transaction_code;
            this.memos_code = memos_code;
            this.vendor_code = vendor_code;
        }

        public Builder debit(BigDecimal debit) {
            this.debit = debit;
            return this;
        }

        public Builder credit(BigDecimal credit) {
            this.credit = credit;
            return this;
        }

        public Builder balance_forward(BigDecimal balance_forward) {
            this.balance_forward = balance_forward;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public CashBook build() {
            return new CashBook(this);
        }
    }

    private CashBook(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.transaction_code = builder.transaction_code;
        this.memos_code = builder.memos_code;
        this.vendor_code = builder.vendor_code;
        this.debit = builder.debit;
        this.credit = builder.credit;
        this.balance_forward = builder.balance_forward;
        this.date = builder.date;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTransaction_code() {
        return transaction_code;
    }

    public String getMemos_code() {
        return memos_code;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public BigDecimal getBalance_forward() {
        return balance_forward;
    }

    public Date getDate() {
        return date;
    }
}
