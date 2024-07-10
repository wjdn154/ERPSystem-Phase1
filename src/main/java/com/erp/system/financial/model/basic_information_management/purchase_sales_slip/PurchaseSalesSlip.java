package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 매입매출전표
 * 매입매출전표 등록 할때 필요한 정보들이 있는 테이블
 */
public class PurchaseSalesSlip {
    @Unique
    @NotNull
    private final String id; // 고유 식별자
    @NotNull
    private final String userCompanyId; // ERP 사용자 계정 회사 ID
    @NotNull
    private final String vatTypeId; // 부가세유형 참조 코드
    @NotNull
    private final String vendorId; // 거래처 코드 (거래처 테이블 참조)
    @NotNull
    private final String entryId; // 분개 코드 (분개 관련 정보 참조)
    @NotNull
    private final String managerId; // 담장자 ID
    @NotNull
    private final String adminId; // 승인 관리자 ID

    @NotNull
    private LocalDate date; // 전표 날짜
    @Unique
    @NotNull
    private String itemName; // 품목명
    @NotNull
    private BigDecimal quantity; // 수량
    @NotNull
    private BigDecimal unitPrice; // 단가
    @NotNull
    private BigDecimal supplyValue; // 공급가액
    @NotNull
    private BigDecimal vat; // 부가세
    @NotNull
    private Boolean electronicTaxInvoiceIssued; // 전자세금계산서 발행여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String userCompanyId;
        private String vatTypeId;
        private String vendorId;
        private String entryId;
        private String managerId;
        private String adminId;
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

        public Builder userCompanyId(String userCompanyId) {
            this.userCompanyId = userCompanyId;
            return this;
        }

        public Builder vatTypeId(String vatTypeId) {
            this.vatTypeId = vatTypeId;
            return this;
        }

        public Builder vendorId(String vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public Builder entryId(String entryId) {
            this.entryId = entryId;
            return this;
        }

        public Builder managerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder adminId(String adminId) {
            this.adminId = adminId;
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
        this.userCompanyId = builder.userCompanyId;
        this.vatTypeId = builder.vatTypeId;
        this.vendorId = builder.vendorId;
        this.entryId = builder.entryId;
        this.managerId = builder.managerId;
        this.adminId = builder.adminId;
        this.date = builder.date;
        this.itemName = builder.itemName;
        this.quantity = builder.quantity;
        this.unitPrice = builder.unitPrice;
        this.supplyValue = builder.supplyValue;
        this.vat = builder.vat;
        this.electronicTaxInvoiceIssued = builder.electronicTaxInvoiceIssued;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .userCompanyId(this.userCompanyId)
                .vatTypeId(this.vatTypeId)
                .vendorId(this.vendorId)
                .entryId(this.entryId)
                .managerId(this.managerId)
                .adminId(this.adminId)
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

    public String getUserCompanyId() {
        return userCompanyId;
    }

    public String getVatTypeId() {
        return vatTypeId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getEntryId() {
        return entryId;
    }

    public String getManagerId() {
        return managerId;
    }

    public String getAdminId() {
        return adminId;
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

    public boolean getElectronicTaxInvoiceIssued() {
        return electronicTaxInvoiceIssued;
    }

    @Override
    public String toString() {
        return "PurchaseSalesSlip{" +
                "id='" + id + '\'' +
                ", userCompanyId='" + userCompanyId + '\'' +
                ", vatTypeId='" + vatTypeId + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", entryId='" + entryId + '\'' +
                ", managerId='" + managerId + '\'' +
                ", adminId='" + adminId + '\'' +
                ", date=" + date +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", supplyValue=" + supplyValue +
                ", vat=" + vat +
                ", electronicTaxInvoiceIssued=" + electronicTaxInvoiceIssued +
                '}';
    }
}