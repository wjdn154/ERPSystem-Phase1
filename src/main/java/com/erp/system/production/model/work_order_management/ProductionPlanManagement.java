package com.erp.system.production.model.work_order_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
* 생산요청을 기반으로 일정 기간 동안의 생산 목표와 일정을 계획하는 단계
* - 생산요청에 따른 생산계획 정보를 주로 주간, 월간 또는 프로젝트 단위로 수립되며,
*   구체적인 일정 계획에 따라 관리하는 테이블
 * */

@EnumMapping
public class ProductionPlanManagement {
    private enum PlanType { DAILY, WEEKLY, MONTHLY, YEARLY };
    private enum Status { PLAN, IN_PROGRESS, COMPLETED };

    @NotNull
    @Unique
    private final String id; // PK

    @NotNull
    private final String productionRequestId; // 생산 요청 ID (FK, 생산요청)
    @NotNull
    private PlanType type; // 계획 유형 (일별, 주별, 월별, 연간)
    @NotNull
    private LocalDate startDate; // 시작 날짜
    @NotNull
    private LocalDate endDate; // 종료 날짜
    @NotNull
    private String planDescription; // 계획 설명
    @NotNull
    private String plannerDepartment; // 계획 담당부서 (FK, 인사)
    @NotNull
    private String plannerName; // 계획 담당자 이름 (FK, 인사)
    @NotNull
    private Status status; // 상태 (예: 계획, 진행 중, 완료)

    private BigDecimal estimatedCost; // 예상 비용
    private BigDecimal actualCost; // 실제 비용

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String productionRequestId;
        private PlanType type;
        private LocalDate startDate;
        private LocalDate endDate;
        private String planDescription;
        private String plannerDepartment;
        private String plannerName;
        private Status status;
        private BigDecimal estimatedCost;
        private BigDecimal actualCost;


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder productionRequestId(String productionRequestId) {
            this.productionRequestId = productionRequestId;
            return this;
        }

        public Builder type(PlanType type) {
            this.type = type;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder planDescription(String planDescription) {
            this.planDescription = planDescription;
            return this;
        }

        public Builder plannerDepartment(String plannerDepartment) {
            this.plannerDepartment = plannerDepartment;
            return this;
        }

        public Builder plannerName(String plannerName) {
            this.plannerName = plannerName;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder estimatedCost(BigDecimal estimatedCost) {
            this.estimatedCost = estimatedCost;
            return this;
        }

        public Builder actualCost(BigDecimal actualCost) {
            this.actualCost = actualCost;
            return this;
        }

        public ProductionPlanManagement build() {
            return new ProductionPlanManagement(this);
        }
    }

    // private Builder Constructor
    private ProductionPlanManagement(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.productionRequestId = builder.productionRequestId;
        this.type = builder.type;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.planDescription = builder.planDescription;
        this.plannerDepartment = builder.plannerDepartment;
        this.plannerName = builder.plannerName;
        this.status = builder.status;
        this.estimatedCost = builder.estimatedCost;
        this.actualCost = builder.actualCost;
        NotNullValidator.validateFields(this);
    }

    // tobuild()
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .productionRequestId(this.productionRequestId)
                .type(this.type)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .planDescription(this.planDescription)
                .plannerDepartment(this.plannerDepartment)
                .plannerName(this.plannerName)
                .status(this.status)
                .estimatedCost(this.estimatedCost)
                .actualCost(this.actualCost);
    }

    // getters

    public String getId() {
        return id;
    }

    public String getProductionRequestId() {
        return productionRequestId;
    }

    public PlanType getType() {
        return type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getPlanDescription() {
        return planDescription;
    }

    public String getPlannerDepartment() {
        return plannerDepartment;
    }

    public String getPlannerName() {
        return plannerName;
    }

    public Status getStatus() {
        return status;
    }

    public BigDecimal getEstimatedCost() {
        return estimatedCost;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public static int getIdIndex() {
        return idIndex;
    }


    // toString
    @Override
    public String toString() {
        return "ProductionPlanManagement{" +
                "id='" + id + '\'' +
                ", productionRequestId='" + productionRequestId + '\'' +
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", planDescription='" + planDescription + '\'' +
                ", plannerDepartment='" + plannerDepartment + '\'' +
                ", plannerName='" + plannerName + '\'' +
                ", status=" + status +
                ", estimatedCost=" + estimatedCost +
                ", actualCost=" + actualCost +
                '}';
    }
}