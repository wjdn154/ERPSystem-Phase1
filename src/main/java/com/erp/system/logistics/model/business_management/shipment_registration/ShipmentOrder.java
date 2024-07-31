package com.erp.system.logistics.model.business_management.shipment_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

import java.time.LocalDate;

/**
 * 출하지시서 테이블
 * 출하지시서에 대한 정보가 있는 테이블
 */
public class ShipmentOrder {
    @NotNull
    private final String id; // 출하지시코드 (Primary Key)
    @NotNull
    private final String saleId; // 판매 코드 참조

    @NotNull
    private LocalDate date; // 일자
    @NotNull
    private LocalDate shipmentDate; // 출하예정일
    @NotNull
    private String contactNumber; // 연락처
    @Unique
    private String postalCode; // 우편번호
    @NotNull
    private String address; // 주소
    private String remarks; // 비고
    @NotNull
    private String status; // 진행상태 (진행중, 완료)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String saleId;
        private LocalDate date;
        private LocalDate shipmentDate;
        private String contactNumber;
        private String postalCode;
        private String address;
        private String remarks;
        private String status;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder saleId(String saleId) {
            this.saleId = saleId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder shipmentDate(LocalDate shipmentDate) {
            this.shipmentDate = shipmentDate;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }
        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public ShipmentOrder build() {
            return new ShipmentOrder(this);
        }
    }

    private ShipmentOrder(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.saleId = builder.saleId;
        this.shipmentDate = builder.shipmentDate;
        this.date = builder.date;
        this.contactNumber = builder.contactNumber;
        this.postalCode = builder.postalCode;
        this.address = builder.address;
        this.remarks = builder.remarks;
        this.status = builder.status;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .saleId(this.saleId)
                .date(this.date)
                .shipmentDate(this.shipmentDate)
                .contactNumber(this.contactNumber)
                .postalCode(this.postalCode)
                .address(this.address)
                .remarks(this.remarks)
                .status(this.status);
    }

    public String getId() {
        return id;
    }

    public String getSaleId() {
        return saleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ShipmentOrder{" +
                "id='" + id + '\'' +
                ", saleId='" + saleId + '\'' +
                ", date=" + date +
                ", shipmentDate=" + shipmentDate +
                ", contactNumber='" + contactNumber + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", address='" + address + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}