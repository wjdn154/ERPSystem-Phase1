package com.erp.system.logistics.model.purchase_management.purchase_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

import java.time.LocalDate;

/**
 * 구매 테이블
 * 구매에 대한 정보가 있는 테이블
 */
public class PurchaseOrder {
    @NotNull
    private final String id; // 구매 고유 식별자 (Primary Key)
    @NotNull
    private final String purchaseRequestId; // 구매요청(발주) 코드 참조

    @NotNull
    private LocalDate date; // 일자
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String purchaseRequestId;
        private LocalDate date;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder purchaseRequestId(String purchaseRequestId) {
            this.purchaseRequestId = purchaseRequestId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public PurchaseOrder build() {
            return new PurchaseOrder(this);
        }
    }

    private PurchaseOrder(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.purchaseRequestId = builder.purchaseRequestId;
        this.date = builder.date;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .purchaseRequestId(this.purchaseRequestId)
                .date(this.date)
                .remarks(this.remarks);
    }

    public String getId() {
        return id;
    }

    public String getPurchaseRequestId() {
        return purchaseRequestId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "id='" + id + '\'' +
                ", purchaseRequestId='" + purchaseRequestId + '\'' +
                ", date=" + date +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
