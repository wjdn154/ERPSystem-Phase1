package com.erp.system.financial.model.book_keeping.accounting_ledger;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 현금출납장 테이블
 * 장부관리 탭 현급출납장 데이터 테이블
 */
public class CashBook {
    private final String id; // 고유 식별자
    private final String transaction_code; // 거래코드 참조키
    private final String memos_code; // 적요 코드 참조키
    private final String vendor_code; // 거래처 코드 참조키
    private BigDecimal debit; // 입금 금액
    private BigDecimal credit; // 출금 금액
    private BigDecimal balance_forward; // 이월 금액
    private Date date; // 거래 날짜

    public CashBook(String vendor_code, String memos_code, String transaction_code) {
        this.id = UUID.randomUUID().toString();
        this.vendor_code = vendor_code;
        this.memos_code = memos_code;
        this.transaction_code = transaction_code;
    }

    public String getId() {
        return id;
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

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getBalance_forward() {
        return balance_forward;
    }

    public void setBalance_forward(BigDecimal balance_forward) {
        this.balance_forward = balance_forward;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
