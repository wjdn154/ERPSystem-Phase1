package com.erp.system.production.model.work_performance_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 작업장(Work Center, W/C)에서 발생하는 작업 실적을 관리하는 테이블
 */
public class WorkCenterPerformance {
    @NotNull
    @Unique
    private final String id; // 실적코드 (PK, not null, unique)
    @NotNull
    private String workCenterId; // 작업장 ID (FK, 참조: WorkCenter.id, not null)
    @NotNull
    private LocalDate performanceDate; // 실적 일자
    @NotNull
    private String performer; // 실적자 (FK, 인사)
    @NotNull
    private BigDecimal performanceQuantity; // 실적 수량
    @NotNull
    private String itemCode; // 품목 코드 (FK, 참조: ItemRegistration.id, not null)
    @NotNull
    private String itemName; // 품목 이름
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
        private String workCenterId;
        private LocalDate performanceDate;
        private String performer;
        private BigDecimal performanceQuantity;
        private String itemCode;
        private String itemName;
        private String performanceDepartment;
        private String performanceTeam;
        private WorkPerformanceSummary.Status status;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder workCenterId(String workCenterId) {
            this.workCenterId = workCenterId;
            return this;
        }

        public Builder performanceDate(LocalDate performanceDate) {
            this.performanceDate = performanceDate;
            return this;
        }

        public Builder performer(String performer) {
            this.performer = performer;
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

        public Builder itemName(String itemName) {
            this.itemName = itemName;
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

        public WorkCenterPerformance build() {
            return new WorkCenterPerformance(this);
        }
    }

    private WorkCenterPerformance(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.workCenterId = builder.workCenterId;
        this.performanceDate = builder.performanceDate;
        this.performer = builder.performer;
        this.performanceQuantity = builder.performanceQuantity;
        this.itemCode = builder.itemCode;
        this.itemName = builder.itemName;
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
                .workCenterId(this.workCenterId)
                .performanceDate(this.performanceDate)
                .performer(this.performer)
                .performanceQuantity(this.performanceQuantity)
                .itemCode(this.itemCode)
                .itemName(this.itemName)
                .performanceDepartment(this.performanceDepartment)
                .performanceTeam(this.performanceTeam)
                .status(this.status)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getWorkCenterId() {
        return workCenterId;
    }

    public LocalDate getPerformanceDate() {
        return performanceDate;
    }

    public String getPerformer() {
        return performer;
    }

    public BigDecimal getPerformanceQuantity() {
        return performanceQuantity;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
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
        return "WorkCenterPerformance{" +
                "id='" + id + '\'' +
                ", workCenterId='" + workCenterId + '\'' +
                ", performanceDate=" + performanceDate +
                ", performer='" + performer + '\'' +
                ", performanceQuantity=" + performanceQuantity +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", performanceDepartment='" + performanceDepartment + '\'' +
                ", performanceTeam='" + performanceTeam + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
