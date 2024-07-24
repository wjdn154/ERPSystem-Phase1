package com.erp.system.logistics.model.warehouse_management_system.receiving_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

import java.time.LocalDate;

/**
 * 입고 테이블
 * 입고에 대한 정보가 있는 테이블 - 입고 등록 시 사용
 */
public class Receiving {
    @NotNull
    private final String id; // 입고 고유 식별자 (Primary Key)
    @NotNull
    private final String purchaseOrderId; // 구매 코드 참조

    @NotNull
    private LocalDate date; // 일자
    @NotNull
    private int instructionQuantity; // 입고지시수량
    private String remarks; // 비고

    public static int idIndex = 1;

     public static class Builder {
        private String id;
        private String purchaseOrderId;
        private LocalDate date;
        private int instructionQuantity;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder purchaseOrderId(String purchaseOrderId) {
            this.purchaseOrderId = purchaseOrderId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder instructionQuantity(int instructionQuantity) {
            this.instructionQuantity = instructionQuantity;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Receiving build() {
            return new Receiving(this);
        }
    }

    private Receiving(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.purchaseOrderId = builder.purchaseOrderId;
        this.date = builder.date;
        this.instructionQuantity = builder.instructionQuantity;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .purchaseOrderId(this.purchaseOrderId)
                .date(this.date)
                .instructionQuantity(this.instructionQuantity)
                .remarks(this.remarks);
    }

    public String getId() {
        return id;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getInstructionQuantity() {
        return instructionQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "ReceivingRegistration{" +
                "id='" + id + '\'' +
                ", purchaseOrderId='" + purchaseOrderId + '\'' +
                ", date=" + date +
                ", instructionQuantity=" + instructionQuantity +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}

