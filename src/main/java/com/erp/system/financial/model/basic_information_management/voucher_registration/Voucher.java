package com.erp.system.financial.model.basic_information_management.voucher_registration;

import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 전표 테이블
 * 전표 작성시 전표 데이터 저장 테이블
 */
public class Voucher {
    public enum VoucherType {DISBURSEMENT,DEPOSIT,DEBIT,CREDIT};

    @Unique
    @NotNull
    private final String id; // 전표의 고유 식별자
    @NotNull
    private final String userCompanyId; // ERP 사용자 계정 회사 ID
    @NotNull
    private final VoucherType voucherType; // 전표타입
    @NotNull
    private final String accountId; // 계정과목 코드
    @NotNull
    private final String vendorId; // 거래처 코드
    @NotNull
    private final String memoId; // 적요 코드
    @NotNull
    private final String departmentId; // 작성 부서 ID

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
        private String userCompanyId;
        private VoucherType voucherType;
        private String accountId;
        private String vendorId;
        private String memoId;
        private String departmentId;

        private String description;
        private BigDecimal debit;
        private BigDecimal credit;
        private LocalDate date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder userCompanyId(String userCompanyId) {
            this.userCompanyId = userCompanyId;
            return this;
        }

        public Builder voucherType(VoucherType voucherType) {
            this.voucherType = voucherType;
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

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
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
        this.userCompanyId = builder.userCompanyId;
        this.voucherType = builder.voucherType;
        this.accountId = builder.accountId;
        this.vendorId = builder.vendorId;
        this.memoId = builder.memoId;
        this.departmentId = builder.departmentId;
        this.description = builder.description;
        this.debit = builder.debit;
        this.credit = builder.credit;
        this.date = builder.date;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .userCompanyId(this.userCompanyId)
                .voucherType(this.voucherType)
                .accountId(this.accountId)
                .vendorId(this.vendorId)
                .memoId(this.memoId)
                .departmentId(this.departmentId)
                .description(this.description)
                .debit(this.debit)
                .credit(this.credit)
                .date(this.date);
    }

    public String getId() {
        return id;
    }

    public String getUserCompanyId() {
        return userCompanyId;
    }

    public VoucherType getVoucherType() {
        return voucherType;
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

    public String getDepartmentId() {
        return departmentId;
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

    @Override
    public String toString() {
        return "Voucher{" +
                "id='" + id + '\'' +
                ", userCompanyId='" + userCompanyId + '\'' +
                ", voucherType=" + voucherType +
                ", accountId='" + accountId + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", memoId='" + memoId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", description='" + description + '\'' +
                ", debit=" + debit +
                ", credit=" + credit +
                ", date=" + date +
                '}';
    }
}