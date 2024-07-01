package com.erp.system.financial.model.dto;

import com.erp.system.common.annotation.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VoucherDto {
    private String ERPCompanyId; // ERP 사용자 계정 회사 ID
    private String voucherTypeId; // 전표타입 코드
    private String accountId; // 계정과목 코드
    private String vendorId; // 거래처 코드
    private String memoId; // 적요 코드

    private String description; // 거래 설명
    private BigDecimal debit; // 차변 금액
    private BigDecimal credit; // 대변 금액
    private LocalDate date; // 전표 날짜

    public String getERPCompanyId() {
        return ERPCompanyId;
    }

    public void setERPCompanyId(String ERPCompanyId) {
        this.ERPCompanyId = ERPCompanyId;
    }

    public String getVoucherTypeId() {
        return voucherTypeId;
    }

    public void setVoucherTypeId(String voucherTypeId) {
        this.voucherTypeId = voucherTypeId;
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
}
