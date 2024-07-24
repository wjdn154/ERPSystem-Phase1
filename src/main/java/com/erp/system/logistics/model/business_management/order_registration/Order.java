package com.erp.system.logistics.model.business_management.order_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

import java.time.LocalDate;

/**
 * 주문서 테이블
 * 주문서에 대한 정보가 있는 테이블
 */
public class Order {
    @NotNull
    private final String id; // 주문 고유 식별
    @NotNull
    private final String quotationId; // 견적서 코드 참조

    @NotNull
    private LocalDate date; // 일자
    @NotNull
    private LocalDate deliveryDate; // 납기일자
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String quotationId;
        private LocalDate date;
        private String remarks;
        private LocalDate deliveryDate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder quotationId(String quotationId) {
            this.quotationId = quotationId;
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

        public Builder deliveryDate(LocalDate deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    private Order(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.quotationId = builder.quotationId;
        this.date = builder.date;
        this.remarks = builder.remarks;
        this.deliveryDate = builder.deliveryDate;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .quotationId(this.quotationId)
                .date(this.date)
                .remarks(this.remarks)
                .deliveryDate(this.deliveryDate);
    }

    public String getId() {
        return id;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getRemarks() {
        return remarks;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", quotationId='" + quotationId + '\'' +
                ", date=" + date +
                ", deliveryDate=" + deliveryDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
      