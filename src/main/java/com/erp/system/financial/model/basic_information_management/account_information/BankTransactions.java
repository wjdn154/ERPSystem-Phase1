package com.erp.system.financial.model.basic_information_management.account_information;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 은행 거래 테이블
 * 은행 거래에 대한 정보가 있는 테이블
 */
public class BankTransactions {
    private final String id; // 은행 거래의 고유식별자
    private final String account_code; // 계좌 코드 참조
    private String bank_name; // 거래 은행명
    private String type; // 거래 유형
    private BigDecimal amount; // 거래 금액
    private Date date; // 거래 날짜
    private BigDecimal current_balance; // 현재 잔액

    public BankTransactions(String account_code) {
        this.id = UUID.randomUUID().toString();
        this.account_code = account_code;
    }

    public String getId() {
        return id;
    }

    public String getAccount_code() {
        return account_code;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(BigDecimal current_balance) {
        this.current_balance = current_balance;
    }
}
