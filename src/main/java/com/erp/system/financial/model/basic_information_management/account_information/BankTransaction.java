package com.erp.system.financial.model.basic_information_management.account_information;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 은행 거래 테이블
 * 은행 거래에 대한 정보가 있는 테이블
 */
public class BankTransaction {
    private final String id; // 은행 거래의 고유식별자
    private final String code; // 코드번호
    private final String account_code; // 계좌 코드 참조

    private String bank_name; // 거래 은행명
    private String type; // 거래 유형
    private BigDecimal amount; // 거래 금액
    private Date date; // 거래 날짜
    private BigDecimal current_balance; // 현재 잔액

    public static class Builder {
        private final String id;
        private final String code;
        private final String account_code;

        private String bank_name;
        private String type;
        private BigDecimal amount;
        private Date date;
        private BigDecimal current_balance;

        public Builder(String code, String account_code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.account_code = account_code;
        }

        public Builder bank_name(String bank_name) {
            this.bank_name = bank_name;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder current_balance(BigDecimal current_balance) {
            this.current_balance = current_balance;
            return this;
        }

        public BankTransaction build() {
            return new BankTransaction(this);
        }
    }

    private BankTransaction(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.account_code = builder.account_code;
        this.bank_name = builder.bank_name;
        this.type = builder.type;
        this.amount = builder.amount;
        this.date = builder.date;
        this.current_balance = builder.current_balance;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getAccount_code() {
        return account_code;
    }

    public String getBank_name() {
        return bank_name;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getCurrent_balance() {
        return current_balance;
    }
}
