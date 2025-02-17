package com.erp.system.production.model.work_performance_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

@EnumMapping
public class DailyReport {
    @NotNull
    @Unique
    private final String id; // PK
    @NotNull
    private final String productionPlanId; // 생산 계획 ID (FK, ProductionPlan) // TODO: What If ADD StockProductionID;
    @NotNull
    private String workerId; // 작업자 이름(FK, 인사 부서 테이블)
    @NotNull
    private LocalDate reportDate; // 보고 날짜
    @NotNull
    private BigDecimal producedQuantity; // 생산량
    @NotNull
    private BigDecimal defectQuantity; // 불량 수량
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String productionPlanId;
        private LocalDate reportDate;
        private BigDecimal producedQuantity;
        private BigDecimal defectQuantity;
        private String workerId;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder productionPlanId(String productionPlanId) {
            this.productionPlanId = productionPlanId;
            return this;
        }

        public Builder workerId(String workerId) {
            this.workerId = workerId;
            return this;
        }

        public Builder reportDate(LocalDate reportDate) {
            this.reportDate = reportDate;
            return this;
        }

        public Builder producedQuantity(BigDecimal producedQuantity) {
            this.producedQuantity = producedQuantity;
            return this;
        }

        public Builder defectQuantity(BigDecimal defectQuantity) {
            this.defectQuantity = defectQuantity;
            return this;
        }


        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public DailyReport build() {
            return new DailyReport(this);
        }
    }

    private DailyReport(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.productionPlanId = builder.productionPlanId;
        this.workerId = builder.workerId;
        this.reportDate = builder.reportDate;
        this.producedQuantity = builder.producedQuantity;
        this.defectQuantity = builder.defectQuantity;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .productionPlanId(this.productionPlanId)
                .workerId(this.workerId)
                .reportDate(this.reportDate)
                .producedQuantity(this.producedQuantity)
                .defectQuantity(this.defectQuantity)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getProductionPlanId() {
        return productionPlanId;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public BigDecimal getProducedQuantity() {
        return producedQuantity;
    }

    public BigDecimal getDefectQuantity() {
        return defectQuantity;
    }

    public String getWorkerId() {
        return workerId;
    }

    public String getRemarks() {
        return remarks;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "DailyReport{" +
                "id='" + id + '\'' +
                ", productionPlanId='" + productionPlanId + '\'' +
                ", reportDate=" + reportDate +
                ", producedQuantity=" + producedQuantity +
                ", defectQuantity=" + defectQuantity +
                ", workerId='" + workerId + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
