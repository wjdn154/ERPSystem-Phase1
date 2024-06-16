package com.erp.system.financial.model.basic_information_management.voucher_registration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 전표 테이블
 * 전표 작성시 전표 데이터 저장 테이블
 */
public class Voucher {
    private final String id; // 전표의 고유 식별자
    private final String company_code; // 회사 코드
    private final String voucher_type_code; // 전표타입 코드
    private final String account_code; // 계정과목 코드
    private final String vendor_code; // 거래처 코드
    private final String memo_code; // 적요 코드
    private final String code; // 전표 코드

    private String description; // 거래 설명
    private BigDecimal debit; // 차변 금액
    private BigDecimal credit; // 대변 금액
    private Date date; // 전표 날짜

    public static class Builder {
        private final String id;
        private final String company_code;
        private final String voucher_type_code;
        private final String account_code;
        private final String vendor_code;
        private final String memo_code;
        private final String code;

        private String description;
        private BigDecimal debit;
        private BigDecimal credit;
        private Date date;

        public Builder(String memo_code, String code, String vendor_code, String account_code, String voucher_type_code, String company_code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.memo_code = memo_code;
            this.vendor_code = vendor_code;
            this.account_code = account_code;
            this.voucher_type_code = voucher_type_code;
            this.company_code = company_code;
        }

        public Builder description(String description) {
            this.description = description;
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

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Voucher build() {
            return new Voucher(this);
        }
    }

    private Voucher(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.company_code = builder.company_code;
        this.voucher_type_code = builder.voucher_type_code;
        this.account_code = builder.account_code;
        this.vendor_code = builder.vendor_code;
        this.memo_code = builder.memo_code;
        this.description = builder.description;
        this.debit = builder.debit;
        this.credit = builder.credit;
        this.date = builder.date;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCompany_code() {
        return company_code;
    }

    public String getVoucher_type_code() {
        return voucher_type_code;
    }

    public String getAccount_code() {
        return account_code;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public String getMemo_code() {
        return memo_code;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public Date getDate() {
        return date;
    }
}
