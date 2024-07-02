package com.erp.system.production.model.work_order_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

@EnumMapping
public class ProductionReport {
    private enum ReportType { DAILY, MONTHLY }

    @NotNull
    @Unique
    private final String id; // PK
    @NotNull
    private final String productionPlanId; // 생산 계획 ID (FK)
    @NotNull
    private LocalDate reportDate; // 보고 날짜
    @NotNull
    private ReportType reportType; // 리포트 유형
    @NotNull
    private BigDecimal producedQuantity; // 생산량
    @NotNull
    private BigDecimal defectQuantity; // 불량 수량
    @NotNull
    private String productionOperator; // 작업자 이름(FK, 인사 부서 테이블)
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String productionPlanId;
        private LocalDate reportDate;
        private ReportType reportType;
        private BigDecimal producedQuantity;
        private BigDecimal defectQuantity;
        private String productionOperator;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder productionPlanId(String productionPlanId) {
            this.productionPlanId = productionPlanId;
            return this;
        }

        public Builder reportDate(LocalDate reportDate) {
            this.reportDate = reportDate;
            return this;
        }

        public Builder reportType(ReportType reportType) {
            this.reportType = reportType;
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

        public Builder productionOperator(String productionOperator) {
            this.productionOperator = productionOperator;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public ProductionReport build() {
            return new ProductionReport(this);
        }
    }

    private ProductionReport(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.productionPlanId = builder.productionPlanId;
        this.reportDate = builder.reportDate;
        this.reportType = builder.reportType;
        this.producedQuantity = builder.producedQuantity;
        this.defectQuantity = builder.defectQuantity;
        this.productionOperator = builder.productionOperator;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .productionPlanId(this.productionPlanId)
                .reportDate(this.reportDate)
                .reportType(this.reportType)
                .producedQuantity(this.producedQuantity)
                .defectQuantity(this.defectQuantity)
                .productionOperator(this.productionOperator)
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

    public ReportType getReportType() {
        return reportType;
    }

    public BigDecimal getProducedQuantity() {
        return producedQuantity;
    }

    public BigDecimal getDefectQuantity() {
        return defectQuantity;
    }

    public String getProductionOperator() {
        return productionOperator;
    }

    public String getRemarks() {
        return remarks;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "ProductionReport{" +
                "id='" + id + '\'' +
                ", productionPlanId='" + productionPlanId + '\'' +
                ", reportDate=" + reportDate +
                ", reportType=" + reportType +
                ", producedQuantity=" + producedQuantity +
                ", defectQuantity=" + defectQuantity +
                ", productionOperator='" + productionOperator + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
