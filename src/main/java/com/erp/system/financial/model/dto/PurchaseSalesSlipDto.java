package com.erp.system.financial.model.dto;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 매출매입전표 등록을 위한 데이터 전송 객체 (DTO).
 */
public class PurchaseSalesSlipDto {

    private String vatTypeId; // 부가세유형 참조 코드
    private String vendorId; // 거래처 코드 (거래처 테이블 참조)
    private String entryId; // 분개 코드 (분개 관련 정보 참조)
    private String departmentId; // 작성 부서 ID
    private LocalDate date; // 전표 날짜
    private String itemName; // 품목명
    private BigDecimal quantity; // 수량
    private BigDecimal unitPrice; // 단가
    private BigDecimal supplyValue; // 공급가액
    private BigDecimal vat; // 부가세
    private Boolean electronicTaxInvoiceIssued; // 전자세금계산서 발행여부
    private String userCompanyId; // ERP 사용자 계정 회사 ID


    public String getVatTypeId() {
        return vatTypeId;
    }

    public void setVatTypeId(String vatTypeId) {
        this.vatTypeId = vatTypeId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSupplyValue() {
        return supplyValue;
    }

    public void setSupplyValue(BigDecimal supplyValue) {
        this.supplyValue = supplyValue;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public Boolean getElectronicTaxInvoiceIssued() {
        return electronicTaxInvoiceIssued;
    }

    public void setElectronicTaxInvoiceIssued(Boolean electronicTaxInvoiceIssued) {
        this.electronicTaxInvoiceIssued = electronicTaxInvoiceIssued;
    }


    public String getUserCompanyId() {
        return userCompanyId;
    }

    public void setUserCompanyId(String userCompanyId) {
        this.userCompanyId = userCompanyId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
