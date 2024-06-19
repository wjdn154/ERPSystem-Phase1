package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 매입매출전표
 * 매입매출전표 등록 할때 필요한 정보들이 있는 테이블
 */
public class PurchaseSalesSlip {
    private final String id; // 고유 식별자
    private final String code; // 매입매출전표 코드
    private final String vatTypeCode; // 부가세유형 참조 코드
    private final String supplierCode; // 공급처 코드 (거래처 테이블 참조)
    private final String entryCode; // 분개 코드 (분개 관련 정보 참조)

    private LocalDate date; // 전표 날짜
    private String itemName; // 품목명
    private BigDecimal quantity; // 수량
    private BigDecimal unitPrice; // 단가
    private BigDecimal supplyValue; // 공급가액
    private BigDecimal vat; // 부가세
    private Boolean electronicTaxInvoiceIssued; // 전자세금계산서 발행여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String code;
        private String vatTypeCode;
        private String supplierCode;
        private String entryCode;

        private LocalDate date;
        private String itemName;
        private BigDecimal quantity;
        private BigDecimal unitPrice;
        private BigDecimal supplyValue;
        private BigDecimal vat;
        private Boolean electronicTaxInvoiceIssued;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder vatTypeCode(String vatTypeCode) {
            this.vatTypeCode = vatTypeCode;
            return this;
        }

        public Builder supplierCode(String supplierCode) {
            this.supplierCode = supplierCode;
            return this;
        }

        public Builder entryCode(String entryCode) {
            this.entryCode = entryCode;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder itemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder quantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder unitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            return this;
        }

        public Builder supplyValue(BigDecimal supplyValue) {
            this.supplyValue = supplyValue;
            return this;
        }

        public Builder vat(BigDecimal vat) {
            this.vat = vat;
            return this;
        }

        public Builder electronicTaxInvoiceIssued(Boolean electronicTaxInvoiceIssued) {
            this.electronicTaxInvoiceIssued = electronicTaxInvoiceIssued;
            return this;
        }

        public PurchaseSalesSlip build() {
            return new PurchaseSalesSlip(this);
        }
    } // end of Builder

    private PurchaseSalesSlip(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.vatTypeCode = builder.vatTypeCode;
        this.supplierCode = builder.supplierCode;
        this.entryCode = builder.entryCode;
        this.date = builder.date;
        this.itemName = builder.itemName;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.supplyValue = builder.supplyValue;
        this.vat = builder.vat;
        this.electronicTaxInvoiceIssued = builder.electronicTaxInvoiceIssued;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .vatTypeCode(this.vatTypeCode)
                .supplierCode(this.supplierCode)
                .entryCode(this.entryCode)
                .date(this.date)
                .itemName(this.itemName)
                .quantity(this.quantity)
                .unitPrice(this.unitPrice)
                .supplyValue(this.supplyValue)
                .vat(this.vat)
                .electronicTaxInvoiceIssued(this.electronicTaxInvoiceIssued);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getVatTypeCode() {
        return vatTypeCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getSupplyValue() {
        return supplyValue;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public Boolean getElectronicTaxInvoiceIssued() {
        return electronicTaxInvoiceIssued;
    }
}