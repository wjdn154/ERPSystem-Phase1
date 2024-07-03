package com.erp.system.financial.model.dto;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 회사 등록을 위한 데이터 전송 객체 (DTO).
 */
public class AccountInformationDto {
    private String id; // 계좌의 고유 식별자
    private LocalDate openingDate; // 개설일
    private String bankName; // 은행명
    private String branchLocation; // 계좌계설지점
    private String number; // 계좌번호
    private String owner; // 계좌 소유자
    private String depositType; // 예금종류
    private String BankTransactionBankName; // 거래 은행명
    private String type; // 거래 유형
    private String description; // 적요
    private BigDecimal debit; // 차변 금액
    private BigDecimal carriedOverDebit; // 차변 이월 금액
    private BigDecimal credit; // 대변 금액
    private BigDecimal carriedOverCredit; // 대변 이월 금액
    private LocalDate date; // 거래 날짜
    private BigDecimal currentBalance; // 현재 잔액
    private LocalDate maturityDate; // 적금 만기 날짜
    private BigDecimal interestRate; // 이자율

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getBankTransactionBankName() {
        return BankTransactionBankName;
    }

    public void setBankTransactionBankName(String bankTransactionBankName) {
        BankTransactionBankName = bankTransactionBankName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public BigDecimal getCarriedOverDebit() {
        return carriedOverDebit;
    }

    public void setCarriedOverDebit(BigDecimal carriedOverDebit) {
        this.carriedOverDebit = carriedOverDebit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getCarriedOverCredit() {
        return carriedOverCredit;
    }

    public void setCarriedOverCredit(BigDecimal carriedOverCredit) {
        this.carriedOverCredit = carriedOverCredit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
