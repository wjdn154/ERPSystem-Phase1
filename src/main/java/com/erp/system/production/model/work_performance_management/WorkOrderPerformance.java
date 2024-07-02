package com.erp.system.production.model.work_performance_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 작업 지시(Work Order, W/O)에 따라 발생하는 작업 실적을 관리하는 테이블
 */

public class WorkOrderPerformance {
    @NotNull
    @Unique
    private final String id; // 실적코드 (PK, not null, unique)
    @NotNull
    private String workOrderId; // 작업지시 ID (FK, 참조: WorkOrder.id, not null)
    @NotNull
    private LocalDate performanceDate; // 실적 일자
    @NotNull
    private String performerId; // 실적자 (FK, 인사)
    @NotNull
    private BigDecimal performanceQuantity; // 실적 수량
    @NotNull
    private String itemCode; // 품목 코드 (FK, 참조: ItemRegistration.id, not null)
    @NotNull
    private String performanceDepartment; // 실적 부서 (FK, 부서 테이블)
    @NotNull
    private String performanceTeam; // 작업팀 단위 (FK, 팀 테이블)
    @NotNull
    private WorkPerformanceSummary.Status status; // 실적의 상태 (등록, 확정, 취소)
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String workOrderId;
        private LocalDate performanceDate;
        private String performerId;
        private BigDecimal performanceQuantity;
        private String itemCode;
        private String performanceDepartment;
        private String performanceTeam;
        private WorkPerformanceSummary.Status status;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder workOrderId(String workOrderId) {
            this.workOrderId = workOrderId;
            return this;
        }

        public Builder performanceDate(LocalDate performanceDate) {
            this.performanceDate = performanceDate;
            return this;
        }

        public Builder performerId(String performerId) {
            this.performerId = performerId;
            return this;
        }

        public Builder performanceQuantity(BigDecimal performanceQuantity) {
            this.performanceQuantity = performanceQuantity;
            return this;
        }

        public Builder itemCode(String itemCode) {
            this.itemCode = itemCode;
            return this;
        }

        public Builder performanceDepartment(String performanceDepartment) {
            this.performanceDepartment = performanceDepartment;
            return this;
        }

        public Builder performanceTeam(String performanceTeam) {
            this.performanceTeam = performanceTeam;
            return this;
        }

        public Builder status(WorkPerformanceSummary.Status status) {
            this.status = status;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public WorkOrderPerformance build() {
            return new WorkOrderPerformance(this);
        }
    }

    private WorkOrderPerformance(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.workOrderId = builder.workOrderId;
        this.performanceDate = builder.performanceDate;
        this.performerId = builder.performerId;
        this.performanceQuantity = builder.performanceQuantity;
        this.itemCode = builder.itemCode;
        this.performanceDepartment = builder.performanceDepartment;
        this.performanceTeam = builder.performanceTeam;
        this.status = builder.status;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .workOrderId(this.workOrderId)
                .performanceDate(this.performanceDate)
                .performerId(this.performerId)
                .performanceQuantity(this.performanceQuantity)
                .itemCode(this.itemCode)
                .performanceDepartment(this.performanceDepartment)
                .performanceTeam(this.performanceTeam)
                .status(this.status)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public LocalDate getPerformanceDate() {
        return performanceDate;
    }

    public String getPerformerId() {
        return performerId;
    }

    public BigDecimal getPerformanceQuantity() {
        return performanceQuantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getPerformanceDepartment() {
        return performanceDepartment;
    }

    public String getPerformanceTeam() {
        return performanceTeam;
    }

    public WorkPerformanceSummary.Status getStatus() {
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
        return "WorkOrderPerformance{" +
                "id='" + id + '\'' +
                ", workOrderId='" + workOrderId + '\'' +
                ", performanceDate=" + performanceDate +
                ", performerId='" + performerId + '\'' +
                ", performanceQuantity=" + performanceQuantity +
                ", itemCode='" + itemCode + '\'' +
                ", performanceDepartment='" + performanceDepartment + '\'' +
                ", performanceTeam='" + performanceTeam + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
