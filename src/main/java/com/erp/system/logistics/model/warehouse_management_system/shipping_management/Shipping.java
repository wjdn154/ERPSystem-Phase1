package com.erp.system.logistics.model.warehouse_management_system.shipping_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.logistics.model.warehouse_management_system.receiving_management.Receiving;

import java.time.LocalDate;

/**
 * 출고 테이블
 * 출고에 대한 정보가 있는 테이블 - 출고 등록 시 사용
 */
public class Shipping {
    @NotNull
    private final String id; // 출고 고유 식별자
    @NotNull
    private final String saleId; // 판매 코드 참조

    @NotNull
    private LocalDate date; // 일자
    @NotNull
    private int instructionQuantity; // 출고지시수량
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String saleId;
        private LocalDate date;
        private int instructionQuantity;
        private String remarks;

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

        public Builder instructionQuantity(int instructionQuantity) {
            this.instructionQuantity = instructionQuantity;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public Shipping build() {
            return new Shipping(this);
        }
    }

    private Shipping(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.saleId = builder.saleId;
        this.date = builder.date;
        this.instructionQuantity = builder.instructionQuantity;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .saleId(this.saleId)
                .date(this.date)
                .instructionQuantity(this.instructionQuantity)
                .remarks(this.remarks);
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

    public int getInstructionQuantity() {
        return instructionQuantity;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "id='" + id + '\'' +
                ", saleId='" + saleId + '\'' +
                ", date=" + date +
                ", instructionQuantity=" + instructionQuantity +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
