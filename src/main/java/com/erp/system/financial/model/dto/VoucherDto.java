package com.erp.system.financial.model.dto;

import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VoucherDto {
    private String userCompanyId; // ERP 사용자 계정 회사 ID
    private Voucher.VoucherType voucherType; // 전표타입 코드
    private String accountId; // 계정과목 코드
    private String vendorId; // 거래처 코드
    private String memoId; // 적요 코드
    private String departmentId; // 작성 부서 ID

    private String description; // 거래 설명
    private BigDecimal debit; // 차변 금액
    private BigDecimal credit; // 대변 금액
    private LocalDate date; // 전표 날짜

    public String getUserCompanyId() {
        return userCompanyId;
    }

    public void setUserCompanyId(String userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    public Voucher.VoucherType getVoucherType() {
        return voucherType;
    }
    public void setVoucherType(Voucher.VoucherType voucherType) {
        this.voucherType = voucherType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getMemoId() {
        return memoId;
    }

    public void setMemoId(String memoId) {
        this.memoId = memoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
