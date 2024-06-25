package com.erp.system.financial.model.basic_information_management.voucher_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 전표 테이블
 * 전표 작성시 전표 데이터 저장 테이블
 */
public class Voucher {
    @NotNull
    private final String id; // 전표의 고유 식별자
    @NotNull
    private final String companyId; // 회사 코드
    @NotNull
    private final String voucherTypeId; // 전표타입 코드
    @NotNull
    private final String accountId; // 계정과목 코드
    @NotNull
    private final String vendorId; // 거래처 코드
    @NotNull
    private final String memoId; // 적요 코드

    @NotNull
    private String description; // 거래 설명
    @NotNull
    private BigDecimal debit; // 차변 금액
    @NotNull
    private BigDecimal credit; // 대변 금액
    @NotNull
    private LocalDate date; // 전표 날짜

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String companyId;
        private String voucherTypeId;
        private String accountId;
        private String vendorId;
        private String memoId;

        private String description;
        private BigDecimal debit;
        private BigDecimal credit;
        private LocalDate date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder companyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder voucherTypeId(String voucherTypeId) {
            this.voucherTypeId = voucherTypeId;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder vendorId(String vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public Builder memoId(String memoId) {
            this.memoId = memoId;
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
        this.companyId = builder.companyId;
        this.voucherTypeId = builder.voucherTypeId;
        this.accountId = builder.accountId;
        this.vendorId = builder.vendorId;
        this.memoId = builder.memoId;
        this.description = builder.description;
        this.debit = builder.debit;
        this.credit = builder.credit;
        this.date = builder.date;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .companyId(this.companyId)
                .voucherTypeId(this.voucherTypeId)
                .accountId(this.accountId)
                .vendorId(this.vendorId)
                .memoId(this.memoId)
                .description(this.description)
                .debit(this.debit)
                .credit(this.credit)
                .date(this.date);
    }

    public String getId() {
        return id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getVoucherTypeId() {
        return voucherTypeId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getMemoId() {
        return memoId;
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