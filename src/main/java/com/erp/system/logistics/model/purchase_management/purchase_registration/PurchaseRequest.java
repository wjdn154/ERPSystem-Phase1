package com.erp.system.logistics.model.purchase_management.purchase_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

import java.time.LocalDate;

/**
 * 구매(발주)요청 테이블
 * 구매(발주)요청에 대한 정보가 있는 테이블
 */
public class PurchaseRequest {
    @NotNull
    private final String id; // 구매요청 고유 식별자 (Primary Key)
    @NotNull
    private final String vendorId; // 거래처 - 거래처 코드 참조
    @NotNull
    private final String contactPersonId; // 담당자 - 사원 코드 참조
    @NotNull
    private final String warehouseId; // 입고될 창고 - 창고 코드 참조
    @NotNull
    private final String currencyId; // 통화 - 통화 코드 참조
    @NotNull
    private final String productId; // 제품 - 제품 코드 참조

    @NotNull
    private int quantity; // 수량
    @NotNull
    private double supplyPrice; // 공급가액 - 수량 * 단가
    @NotNull
    private double vat; // 부가세 - 공급가액의 10%
    @NotNull
    private LocalDate date; // 일자
    @NotNull
    private Boolean transactionType; // 거래유형 (부가세율 적용/미적용)
    @NotNull
    private LocalDate deliveryDate; // 납기일자
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
        private LocalDate deliveryDate;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
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

        public Builder currencyId(String currencyId) {
            this.currencyId = currencyId;
            return this;
        }

        public Builder productId(String productId) {
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

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder transactionType(Boolean transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder deliveryDate(LocalDate deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public PurchaseRequest build() {
            return new PurchaseRequest(this);
        }
    }

    private PurchaseRequest(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.vendorId = builder.vendorId;
        this.contactPersonId = builder.contactPersonId;
        this.warehouseId = builder.warehouseId;
        this.currencyId = builder.currencyId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.supplyPrice = builder.supplyPrice;
        this.vat = builder.vat;
        this.date = builder.date;
        this.transactionType = builder.transactionType;
        this.deliveryDate = builder.deliveryDate;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .vendorId(this.vendorId)
                .contactPersonId(this.contactPersonId)
                .warehouseId(this.warehouseId)
                .currencyId(this.currencyId)
                .productId(this.productId)
                .quantity(this.quantity)
                .supplyPrice(this.supplyPrice)
                .vat(this.vat)
                .date(this.date)
                .transactionType(this.transactionType)
                .deliveryDate(this.deliveryDate)
                .remarks(this.remarks);
    }

    public String getId() {
        return id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getContactPersonId() {
        return contactPersonId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public String getCurrencyId() {
        return currencyId;
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

    public LocalDate getDate() {
        return date;
    }

    public Boolean getTransactionType() {
        return transactionType;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "id='" + id + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", contactPersonId='" + contactPersonId + '\'' +
                ", warehouseId='" + warehouseId + '\'' +
                ", currencyId='" + currencyId + '\'' +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", supplyPrice=" + supplyPrice +
                ", vat=" + vat +
                ", date=" + date +
                ", transactionType=" + transactionType +
                ", deliveryDate=" + deliveryDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
