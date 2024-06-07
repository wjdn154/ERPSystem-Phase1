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

    public GeneralLedger(String account_code) {
        this.id = UUID.randomUUID().toString();
        this.account_code = account_code;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpening_balance() {
        return opening_balance;
    }

    public void setOpening_balance(BigDecimal opening_balance) {
        this.opening_balance = opening_balance;
    }

    public BigDecimal getDebits() {
        return debits;
    }

    public void setDebits(BigDecimal debits) {
        this.debits = debits;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(BigDecimal credits) {
        this.credits = credits;
    }

    public BigDecimal getClosing_balance() {
        return closing_balance;
    }

    public void setClosing_balance(BigDecimal closing_balance) {
        this.closing_balance = closing_balance;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
