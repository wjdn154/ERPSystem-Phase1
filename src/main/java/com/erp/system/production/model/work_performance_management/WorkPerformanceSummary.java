package com.erp.system.production.model.work_performance_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 작업장별 및 작업 지시별 실적을 포함하여 전반적인 작업 실적을 관리하는 테이블
 */

@EnumMapping
public class WorkPerformanceSummary {
    private enum Status { ENROLLED, CONFIRMED, CANCELED }

    @NotNull
    @Unique
    private final String id; // 실적코드 (PK, not null, unique)
    @NotNull
    private String performanceName; // 실적명
    @NotNull
    private LocalDate performanceDate; // 실적 일자
    @NotNull
    private String performerId; // 실적자 (FK, 인사)
    @NotNull
    private BigDecimal performanceQuantity; // 실적 수량
    @NotNull
    private String itemCode; // 품목 코드 (FK, 참조: ItemRegistration.id, not null)
    @NotNull
    private String performanceDepartmentId; // 실적 부서 (FK, 부서 테이블)
    @NotNull
    private String performanceTeamId; // 작업팀 단위 (FK, 팀 테이블)
    @NotNull
    private Status status; // 실적의 상태 (등록, 확정, 취소)
    private String remarks; // 비고

    @NotNull
    private String workCenterPerformanceId; // 작업장별 실적 ID (FK, WorkCenterPerformanceRegistration.id)
    @NotNull
    private String workOrderPerformanceId; // 작업지시별 실적 ID (FK, WorkOrderPerformanceRegistration.id)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String performanceName;
        private LocalDate performanceDate;
        private String performerId;
        private BigDecimal performanceQuantity;
        private String itemCode;
        private String performanceDepartmentId;
        private String performanceTeamId;
        private Status status;
        private String remarks;
        private String workCenterPerformanceId;
        private String workOrderPerformanceId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder performanceName(String performanceName) {
            this.performanceName = performanceName;
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

        public Builder performanceDepartmentId(String performanceDepartmentId) {
            this.performanceDepartmentId = performanceDepartmentId;
            return this;
        }

        public Builder performanceTeamId(String performanceTeamId) {
            this.performanceTeamId = performanceTeamId;
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

        public Builder workCenterPerformanceId(String workCenterPerformanceId) {
            this.workCenterPerformanceId = workCenterPerformanceId;
            return this;
        }

        public Builder workOrderPerformanceId(String workOrderPerformanceId) {
            this.workOrderPerformanceId = workOrderPerformanceId;
            return this;
        }

        public WorkPerformanceSummary build() {
            return new WorkPerformanceSummary(this);
        }
    }

    private WorkPerformanceSummary(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.performanceName = builder.performanceName;
        this.performanceDate = builder.performanceDate;
        this.performerId = builder.performerId;
        this.performanceQuantity = builder.performanceQuantity;
        this.itemCode = builder.itemCode;
        this.performanceDepartmentId = builder.performanceDepartmentId;
        this.performanceTeamId = builder.performanceTeamId;
        this.status = builder.status;
        this.remarks = builder.remarks;
        this.workCenterPerformanceId = builder.workCenterPerformanceId;
        this.workOrderPerformanceId = builder.workOrderPerformanceId;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .performanceName(this.performanceName)
                .performanceDate(this.performanceDate)
                .performerId(this.performerId)
                .performanceQuantity(this.performanceQuantity)
                .itemCode(this.itemCode)
                .performanceDepartmentId(this.performanceDepartmentId)
                .performanceTeamId(this.performanceTeamId)
                .status(this.status)
                .remarks(this.remarks)
                .workCenterPerformanceId(this.workCenterPerformanceId)
                .workOrderPerformanceId(this.workOrderPerformanceId);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPerformanceName() {
        return performanceName;
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

    public String getPerformanceDepartmentId() {
        return performanceDepartmentId;
    }

    public String getPerformanceTeamId() {
        return performanceTeamId;
    }

    public Status getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getWorkCenterPerformanceId() {
        return workCenterPerformanceId;
    }

    public String getWorkOrderPerformanceId() {
        return workOrderPerformanceId;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "WorkPerformanceSummary{" +
                "id='" + id + '\'' +
                ", performanceName='" + performanceName + '\'' +
                ", performanceDate=" + performanceDate +
                ", performerId='" + performerId + '\'' +
                ", performanceQuantity=" + performanceQuantity +
                ", itemCode='" + itemCode + '\'' +
                ", performanceDepartmentId='" + performanceDepartmentId + '\'' +
                ", performanceTeamId='" + performanceTeamId + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", workCenterPerformanceId='" + workCenterPerformanceId + '\'' +
                ", workOrderPerformanceId='" + workOrderPerformanceId + '\'' +
                '}';
    }
}
