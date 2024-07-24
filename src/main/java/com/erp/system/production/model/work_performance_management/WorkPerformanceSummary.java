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
 * TODO: 종합이라서 만들긴 했는데, 막상 필드를 들여다보니 애매하다 ? 작업장별, 작업지시별 실적이 있는데 작업팀 단위?가 있어야 하나 ?? 필드가 좀 많이 달라야할 것 같음
 */

@EnumMapping
public class WorkPerformanceSummary {
    public enum Status { ENROLLED, CONFIRMED, CANCELED }

    @NotNull
    @Unique
    private final String id; // 실적코드 (PK, not null, unique)
    @NotNull
    private String performerId; // 실적자 (FK, 인사) TODO: 종합에만 실적명(내용?) 있어도 되겠지? 다른 실적테이블엔 없는데...
    @NotNull
    private String productId; // 제품 코드 (FK, 참조: Product.id, not null)
    @NotNull
    private String performanceDepartmentId; // 실적 부서 (FK, 부서 테이블)
    @NotNull
    private String performanceTeamId; // 작업팀 단위 (FK, 팀 테이블) TODO : 인사팀 협의 후 삭제 결정
    @NotNull
    private String workCenterPerformanceId; // 작업장별 실적 ID (FK, WorkCenterPerformanceRegistration.id)
    @NotNull
    private String workOrderPerformanceId; // 작업지시별 실적 ID (FK, WorkOrderPerformanceRegistration.id)
    @NotNull
    private String performanceName; // 실적명
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
        private String performerId;
        private String productId;
        private String performanceDepartmentId;
        private String performanceTeamId;
        private String workCenterPerformanceId;
        private String workOrderPerformanceId;
        private String performanceName;
        private LocalDate performanceDate;
        private BigDecimal performanceQuantity;
        private Status status;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
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


        public Builder workCenterPerformanceId(String workCenterPerformanceId) {
            this.workCenterPerformanceId = workCenterPerformanceId;
            return this;
        }

        public Builder workOrderPerformanceId(String workOrderPerformanceId) {
            this.workOrderPerformanceId = workOrderPerformanceId;
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

        public WorkPerformanceSummary build() {
            return new WorkPerformanceSummary(this);
        }
    }

    private WorkPerformanceSummary(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.performerId = builder.performerId;
        this.productId = builder.productId;
        this.performanceDepartmentId = builder.performanceDepartmentId;
        this.performanceTeamId = builder.performanceTeamId;
        this.workCenterPerformanceId = builder.workCenterPerformanceId;
        this.workOrderPerformanceId = builder.workOrderPerformanceId;
        this.performanceName = builder.performanceName;
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
                .performerId(this.performerId)
                .productId(this.productId)
                .performanceDepartmentId(this.performanceDepartmentId)
                .performanceTeamId(this.performanceTeamId)
                .workCenterPerformanceId(this.workCenterPerformanceId)
                .workOrderPerformanceId(this.workOrderPerformanceId)
                .performanceName(this.performanceName)
                .performanceDate(this.performanceDate)
                .performanceQuantity(this.performanceQuantity)
                .status(this.status)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
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

    public String getWorkCenterPerformanceId() {
        return workCenterPerformanceId;
    }

    public String getWorkOrderPerformanceId() {
        return workOrderPerformanceId;
    }

    public String getPerformanceName() {
        return performanceName;
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
        return "WorkPerformanceSummary{" +
                "id='" + id + '\'' +
                ", performerId='" + performerId + '\'' +
                ", productId='" + productId + '\'' +
                ", performanceDepartmentId='" + performanceDepartmentId + '\'' +
                ", performanceTeamId='" + performanceTeamId + '\'' +
                ", workCenterPerformanceId='" + workCenterPerformanceId + '\'' +
                ", workOrderPerformanceId='" + workOrderPerformanceId + '\'' +
                ", performanceName='" + performanceName + '\'' +
                ", performanceDate=" + performanceDate +
                ", performanceQuantity=" + performanceQuantity +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
