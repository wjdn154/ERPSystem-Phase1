package com.erp.system.production.model.work_performance_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 작업 지시(Work Order, W/O)에 따라 발생하는 작업 실적을 관리하는 테이블
 */

@EnumMapping
public class WorkOrderPerformance {
    public enum Status { ENROLLED, CONFIRMED, CANCELED }

    @NotNull
    @Unique
    private final String id; // 실적코드 (PK, not null, unique)
    @NotNull
    private String workOrderId; // 작업지시 ID (FK, 참조: WorkOrder.id, not null)
    @NotNull
    private String performerId; // 실적자 (FK, 인사)
    @NotNull
    private String productId; // 품목 코드 (FK, 참조: Product.id, not null)
    @NotNull
    private String performanceDepartmentId; // 실적 부서 (FK, 부서 테이블)
    @NotNull
    private String performanceTeamId; // 작업팀 단위 (FK, 팀 테이블) // TODO : 여러 작업센터 참조?...
    @NotNull
    private LocalDate performanceDate; // 실적 일자
    @NotNull
    private BigDecimal performanceQuantity; // 실적 수량
    @NotNull
    private Status status; // 실적의 상태 (등록, 확정, 취소) TODO: 생각해보니.. 실적은 실적인데 계획도 아니고 이게 등록확정취소..?
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String workOrderId;
        private String performerId;
        private String productId;
        private String performanceDepartmentId;
        private String performanceTeamId;
        private LocalDate performanceDate;
        private BigDecimal performanceQuantity;
        private Status status;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder workOrderId(String workOrderId) {
            this.workOrderId = workOrderId;
            return this;
        }

        public Builder performerId(String performerId) {
            this.performerId = performerId;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder performanceDepartmentId(String performanceDepartmentId) {
            this.performanceDepartmentId = performanceDepartmentId;
            return this;
        }

        public Builder performanceTeamId(String performanceTeamId) {
            this.performanceTeamId = performanceTeamId;
            return this;
        }

        public Builder performanceDate(LocalDate performanceDate) {
            this.performanceDate = performanceDate;
            return this;
        }

        public Builder performanceQuantity(BigDecimal performanceQuantity) {
            this.performanceQuantity = performanceQuantity;
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

        public WorkOrderPerformance build() {
            return new WorkOrderPerformance(this);
        }
    }

    private WorkOrderPerformance(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.workOrderId = builder.workOrderId;
        this.performerId = builder.performerId;
        this.productId = builder.productId;
        this.performanceDepartmentId = builder.performanceDepartmentId;
        this.performanceTeamId = builder.performanceTeamId;
        this.performanceDate = builder.performanceDate;
        this.performanceQuantity = builder.performanceQuantity;
        this.status = builder.status;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .workOrderId(this.workOrderId)
                .performerId(this.performerId)
                .productId(this.productId)
                .performanceDepartmentId(this.performanceDepartmentId)
                .performanceTeamId(this.performanceTeamId)
                .performanceDate(this.performanceDate)
                .performanceQuantity(this.performanceQuantity)
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

    public String getPerformerId() {
        return performerId;
    }

    public String getProductId() {
        return productId;
    }

    public String getPerformanceDepartmentId() {
        return performanceDepartmentId;
    }

    public String getPerformanceTeamId() {
        return performanceTeamId;
    }

    public LocalDate getPerformanceDate() {
        return performanceDate;
    }

    public BigDecimal getPerformanceQuantity() {
        return performanceQuantity;
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
        return "WorkOrderPerformance{" +
                "id='" + id + '\'' +
                ", workOrderId='" + workOrderId + '\'' +
                ", performerId='" + performerId + '\'' +
                ", productId='" + productId + '\'' +
                ", performanceDepartmentId='" + performanceDepartmentId + '\'' +
                ", performanceTeamId='" + performanceTeamId + '\'' +
                ", performanceDate=" + performanceDate +
                ", performanceQuantity=" + performanceQuantity +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
