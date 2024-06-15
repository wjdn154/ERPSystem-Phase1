package com.erp.system.financial.model.basic_information_management.account_information;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 예적금 현황 테이블
 * 예적금 현황에 대한 정보가 있는 테이블
 */
public class Deposit {
    private final String id; // 고유 식별자
    private final String account_code; // 은행계좌 코드 참조
    private Date maturity_date ; // 적금 만기 날짜
    private BigDecimal interest_rate ; // 이자율

    public Deposit(String account_code) {
        this.id = UUID.randomUUID().toString();
        this.account_code = account_code;
    }

    public String getId() {
        return id;
    }

    public String getAccount_code() {
        return account_code;
    }

    public Date getMaturity_date() {
        return maturity_date;
    }

    public void setMaturity_date(Date maturity_date) {
        this.maturity_date = maturity_date;
    }

    public BigDecimal getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(BigDecimal interest_rate) {
        this.interest_rate = interest_rate;
    }
}
