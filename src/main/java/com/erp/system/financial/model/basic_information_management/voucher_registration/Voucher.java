package com.erp.system.financial.model.basic_information_management.voucher_registration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 전표 테이블
 * 전표 작성시 전표 데이터 저장 테이블
 */
public class Voucher {
    private final String id; // 전표의 고유 식별자
    private final String code; // 전표 코드
    private final String companyCode; // 회사 코드
    private final String voucherTypeCode; // 전표타입 코드
    private final String accountCode; // 계정과목 코드
    private final String vendorCode; // 거래처 코드
    private final String memoCode; // 적요 코드

    private String description; // 거래 설명
    private BigDecimal debit; // 차변 금액
    private BigDecimal credit; // 대변 금액
    private LocalDate date; // 전표 날짜

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String code;
        private String companyCode;
        private String voucherTypeCode;
        private String accountCode;
        private String vendorCode;
        private String memoCode;

        private String description;
        private BigDecimal debit;
        private BigDecimal credit;
        private LocalDate date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder companyCode(String companyCode) {
            this.companyCode = companyCode;
            return this;
        }

        public Builder voucherTypeCode(String voucherTypeCode) {
            this.voucherTypeCode = voucherTypeCode;
            return this;
        }

        public Builder accountCode(String accountCode) {
            this.accountCode = accountCode;
            return this;
        }

        public Builder vendorCode(String vendorCode) {
            this.vendorCode = vendorCode;
            return this;
        }

        public Builder memoCode(String memoCode) {
            this.memoCode = memoCode;
            return this;
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

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Voucher build() {
            return new Voucher(this);
        }
    } // end of Builder

    private Voucher(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.companyCode = builder.companyCode;
        this.voucherTypeCode = builder.voucherTypeCode;
        this.accountCode = builder.accountCode;
        this.vendorCode = builder.vendorCode;
        this.memoCode = builder.memoCode;
        this.description = builder.description;
        this.debit = builder.debit;
        this.credit = builder.credit;
        this.date = builder.date;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .companyCode(this.companyCode)
                .voucherTypeCode(this.voucherTypeCode)
                .accountCode(this.accountCode)
                .vendorCode(this.vendorCode)
                .memoCode(this.memoCode)
                .description(this.description)
                .debit(this.debit)
                .credit(this.credit)
                .date(this.date);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getVoucherTypeCode() {
        return voucherTypeCode;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public String getMemoCode() {
        return memoCode;
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

    public LocalDate getDate() {
        return date;
    }
}