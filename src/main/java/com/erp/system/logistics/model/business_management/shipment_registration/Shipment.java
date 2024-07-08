package com.erp.system.logistics.model.business_management.shipment_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

import java.time.LocalDate;

/**
 * 출하 테이블
 * 출하에 대한 정보가 있는 테이블
 */
public class Shipment {
    @NotNull
    private final String id; // 출하 코드 (Primary Key)
    @NotNull
    private final String shipmentOrderId; // 출하 지시서 코드 참조

    @NotNull
    private LocalDate date; // 일자
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String shipmentOrderId;
        private LocalDate date;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder shipmentOrderId(String shipmentOrderId) {
            this.shipmentOrderId = shipmentOrderId;
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

        public Shipment build() {
            return new Shipment(this);
        }
    }

    private Shipment(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.shipmentOrderId = builder.shipmentOrderId;
        this.date = builder.date;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .shipmentOrderId(this.shipmentOrderId)
                .date(this.date)
                .remarks(this.remarks);
    }

    public String getId() {
        return id;
    }

    public String getShipmentOrderId() {
        return shipmentOrderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id='" + id + '\'' +
                ", shipmentOrderId='" + shipmentOrderId + '\'' +
                ", date=" + date +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}