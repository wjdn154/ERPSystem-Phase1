package com.erp.system.production.model.work_order_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.time.LocalDate;
import java.math.BigDecimal;

/**
 * 생산계획에 따라 구체적인 작업을 지시하여 개별 작업 지시 단위 정보를 관리하는 테이블
 */
@EnumMapping
public class WorkOrderStatus {
    public enum Status { REGISTERED, IN_PROGRESS, COMPLETED, CANCELED }

    @NotNull
    @Unique
    private final String id; // 지시코드: 작업 지시를 식별하기 위한 고유 코드 (PK, not null, unique)
    @NotNull
    private String workOrderName; // 지시명: 작업 지시의 이름
    @NotNull
    private LocalDate workOrderDate; // 작업 지시 일자
    @NotNull
    private String workOrdererId; // 지시자: 작업 지시를 한 사람 (FK, 인사)
    @NotNull
    private BigDecimal workOrderQuantity; // 작업 지시 수량
    @NotNull
    private String itemCode; // 품목 코드 (FK, 참조: ItemRegistration.id, not null)
    @NotNull
    private String itemName; // 품목 이름
    @NotNull
    private Status status; // 지시의 상태 (등록, 진행, 완료, 취소)
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String workOrderName;
        private LocalDate workOrderDate;
        private String workOrdererId;
        private BigDecimal workOrderQuantity;
        private String itemCode;
        private String itemName;
        private Status status;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder workOrderName(String workOrderName) {
            this.workOrderName = workOrderName;
            return this;
        }

        public Builder workOrderDate(LocalDate workOrderDate) {
            this.workOrderDate = workOrderDate;
            return this;
        }

        public Builder workOrdererId(String workOrdererId) {
            this.workOrdererId = workOrdererId;
            return this;
        }

        public Builder workOrderQuantity(BigDecimal workOrderQuantity) {
            this.workOrderQuantity = workOrderQuantity;
            return this;
        }

        public Builder itemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder itemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public WorkOrderStatus build() {
            return new WorkOrderStatus(this);
        }
    }

    private WorkOrderStatus(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.workOrderName = builder.workOrderName;
        this.workOrderDate = builder.workOrderDate;
        this.workOrdererId = builder.workOrdererId;
        this.workOrderQuantity = builder.workOrderQuantity;
        this.itemCode = builder.itemCode;
        this.itemName = builder.itemName;
        this.status = builder.status;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .workOrderName(this.workOrderName)
                .workOrderDate(this.workOrderDate)
                .workOrdererId(this.workOrdererId)
                .workOrderQuantity(this.workOrderQuantity)
                .itemCode(this.itemCode)
                .itemName(this.itemName)
                .status(this.status)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getWorkOrderName() {
        return workOrderName;
    }

    public LocalDate getWorkOrderDate() {
        return workOrderDate;
    }

    public String getWorkOrdererId() {
        return workOrdererId;
    }

    public BigDecimal getWorkOrderQuantity() {
        return workOrderQuantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public Status getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "WorkOrderStatus{" +
                "id='" + id + '\'' +
                ", workOrderName='" + workOrderName + '\'' +
                ", workOrderDate=" + workOrderDate +
                ", workOrdererId='" + workOrdererId + '\'' +
                ", workOrderQuantity=" + workOrderQuantity +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
