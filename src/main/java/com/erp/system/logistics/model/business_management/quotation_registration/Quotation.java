package com.erp.system.logistics.model.business_management.quotation_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.logistics.model.purchase_management.purchase_registration.PurchaseRequest;

import java.time.LocalDate;

/**
 * 견적서 테이블
 * 견적서에 대한 정보가 있는 테이블
 */
public class Quotation {
    @NotNull
    private final String id; // 견적 코드 (Primary Key)
    @NotNull
    private final String vendorId; // 거래처 - Vendors 참조
    @NotNull
    private final String warehouseId; // 출하창고 - Warehouses 참조
    @NotNull
    private final String currencyId; // 통화 (내자, 달러, 엔화 등) - 참조
    @NotNull
    private final String contactPersonId; // 담당자 - 사원 참조
    @NotNull
    private final String productId; // 제품 - 제품 참조

    @NotNull
    private LocalDate date; // 일자
    @NotNull
    private Boolean transactionType; // 거래유형 (부가세율 적용, 미적용)
    @NotNull
    private int quantity; // 수량
    @NotNull
    private double supplyPrice; // 공급가액 - 수량 * 단가
    @NotNull
    private double vat; // 부가세 - 공급가액의 10%
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String vendorId;
        private String contactPersonId;
        private String warehouseId;
        private String currencyId;
        private String productId;
        private int quantity;
        private double supplyPrice;
        private double vat;
        private LocalDate date;
        private Boolean transactionType;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder vendorId(String vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public Builder contactPersonId(String contactPersonId) {
            this.contactPersonId = contactPersonId;
            return this;
        }

        public Builder warehouseId(String warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        public Builder transactionType(Boolean transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder currencyId(String currencyId) {
            this.currencyId = currencyId;
            return this;
        }

        public Builder productId(String productId){
            this.productId = productId;
            return this;
        }
        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder supplyPrice(double supplyPrice) {
            this.supplyPrice = supplyPrice;
            return this;
        }

        public Builder vat(double vat) {
            this.vat = vat;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Quotation build() {
            return new Quotation(this);
        }
    }

    private Quotation(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.date = builder.date;
        this.vendorId = builder.vendorId;
        this.contactPersonId = builder.contactPersonId;
        this.warehouseId = builder.warehouseId;
        this.transactionType = builder.transactionType;
        this.currencyId = builder.currencyId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.supplyPrice = builder.supplyPrice;
        this.vat = builder.vat;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .date(this.date)
                .vendorId(this.vendorId)
                .contactPersonId(this.contactPersonId)
                .warehouseId(this.warehouseId)
                .transactionType(this.transactionType)
                .currencyId(this.currencyId)
                .productId(this.productId)
                .quantity(this.quantity)
                .supplyPrice(this.supplyPrice)
                .vat(this.vat)
                .remarks(this.remarks);
    }

    public String getId() {
        return id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public String getContactPersonId() {
        return contactPersonId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Boolean getTransactionType() {
        return transactionType;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSupplyPrice() {
        return supplyPrice;
    }

    public double getVat() {
        return vat;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "id='" + id + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", contactPersonId='" + contactPersonId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", supplyPrice=" + supplyPrice +
                ", vat=" + vat +
                ", date=" + date +
                ", transactionType=" + transactionType +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}