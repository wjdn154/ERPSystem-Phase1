package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 매입매출전표
 * 매입매출전표 등록 할때 필요한 정보들이 있는 테이블
 */
public class PurchaseSalesSlip {
    private final String id; // 고유 식별자
    private final String code; // 매입매출전표 코드
    private final String vat_type_code; // 부가세유형 참조 코드
    private final String supplier_code; // 공급처 코드 (거래처 테이블 참조)
    private final String entry_code; // 분개 코드 (분개 관련 정보 참조)

    private Date date; // 전표 날짜
    private String item_name; // 품목명
    private BigDecimal quantity; // 수량
    private BigDecimal unit_price; // 단가
    private BigDecimal supply_value; // 공급가액
    private BigDecimal vat; // 부가세
    private Boolean electronic_tax_invoice_issued; // 전자세금계산서 발행여부

    public static class Builder {
        private final String id;
        private final String code;
        private final String vat_type_code;
        private final String supplier_code;
        private final String entry_code;

        private Date date;
        private String item_name;
        private BigDecimal quantity;
        private BigDecimal unit_price;
        private BigDecimal supply_value;
        private BigDecimal vat;
        private Boolean electronic_tax_invoice_issued;

        public Builder(String code, String vat_type_code, String supplier_code, String entry_code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.vat_type_code = vat_type_code;
            this.supplier_code = supplier_code;
            this.entry_code = entry_code;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder item_name(String item_name) {
            this.item_name = item_name;
            return this;
        }

        public Builder quantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder unit_price(BigDecimal unit_price) {
            this.unit_price = unit_price;
            return this;
        }

        public Builder supply_value(BigDecimal supply_value) {
            this.supply_value = supply_value;
            return this;
        }

        public Builder vat(BigDecimal vat) {
            this.vat = vat;
            return this;
        }

        public Builder electronic_tax_invoice_issued(Boolean electronic_tax_invoice_issued) {
            this.electronic_tax_invoice_issued = electronic_tax_invoice_issued;
            return this;
        }

        public PurchaseSalesSlip build() {
            return new PurchaseSalesSlip(this);
        }
    } // end of Builder

    public PurchaseSalesSlip(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.vat_type_code = builder.vat_type_code;
        this.supplier_code = builder.supplier_code;
        this.entry_code = builder.entry_code;
        this.date = builder.date;
        this.item_name = builder.item_name;
        this.quantity = builder.quantity;
        this.unit_price = builder.unit_price;
        this.supply_value = builder.supply_value;
        this.vat = builder.vat;
        this.electronic_tax_invoice_issued = builder.electronic_tax_invoice_issued;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getVat_type_code() {
        return vat_type_code;
    }

    public String getSupplier_code() {
        return supplier_code;
    }

    public String getEntry_code() {
        return entry_code;
    }

    public Date getDate() {
        return date;
    }

    public String getItem_name() {
        return item_name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public BigDecimal getSupply_value() {
        return supply_value;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public Boolean getElectronic_tax_invoice_issued() {
        return electronic_tax_invoice_issued;
    }
}