package com.erp.system.logistics.model.business_management.sale_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

import java.time.LocalDate;

/**
 * 판매 테이블
 * 판매에 대한 정보가 있는 테이블
 */
public class Sale {
    @NotNull
    private final String id; // 판매 코드 (Primary Key)
    @NotNull
    private final String orderId; // 주문 코드 참조

    @NotNull
    private LocalDate date; // 일자
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String orderId;
        private LocalDate date;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder orderId(String orderId) {
            this.orderId = orderId;
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

        public Sale build() {
            return new Sale(this);
        }
    }

    private Sale(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.orderId = builder.orderId;
        this.date = builder.date;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .orderId(this.orderId)
                .date(this.date)
                .remarks(this.remarks);
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", date=" + date +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}