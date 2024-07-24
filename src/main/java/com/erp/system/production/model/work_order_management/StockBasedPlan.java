package com.erp.system.production.model.work_order_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
 *   자체 생산으로 재고 누적을 위해 일정 기간 동안의 생산 목표와 일정을 계획하는 단계
 *   타 부서로부터 생산 요청을 받아서 계획하는 게 아니라
 *   자체 생산으로 진행하여 요청기반계획과 달리 `생산요청ID`를 참조하지 않음
 * */

@EnumMapping
public class StockBasedPlan {
    public enum PlanType { DAILY, WEEKLY, MONTHLY, YEARLY };
    public enum Status { PLAN, IN_PROGRESS, COMPLETED };

    @NotNull
    @Unique
    private final String id; // PK
    @NotNull
    private String plannerDepartment; // 계획 담당부서 (FK, 인사)
    @NotNull
    private String plannerName; // 계획 담당자 이름 (FK, 인사)
    @NotNull
    private PlanType type; // 계획 유형 (일별, 주별, 월별, 연간)
    @NotNull
    private LocalDate startDate; // 시작 날짜
    @NotNull
    private LocalDate endDate; // 종료 날짜
    @NotNull
    private String planDescription; // 계획 설명
    @NotNull
    private Status status; // 상태 (예: 계획, 진행 중, 완료)
    @NotNull
    private BigDecimal goalQuantity; // 목표수량
    private BigDecimal estimatedCost; // 예상 비용
    private BigDecimal actualCost; // 실제 비용

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private PlanType type;
        private LocalDate startDate;
        private LocalDate endDate;
        private String planDescription;
        private String plannerDepartment;
        private String plannerName;
        private Status status;
        private BigDecimal goalQuantity;
        private BigDecimal estimatedCost;
        private BigDecimal actualCost;


        public Builder id(String id) {
            this.id = id;
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

        public Builder goalQuantity(BigDecimal goalQuantity) {
            this.goalQuantity = goalQuantity;
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

        public StockBasedPlan build() {
            return new StockBasedPlan(this);
        }
    }

    // private Builder Constructor
    private StockBasedPlan(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.type = builder.type;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.planDescription = builder.planDescription;
        this.plannerDepartment = builder.plannerDepartment;
        this.plannerName = builder.plannerName;
        this.status = builder.status;
        this.goalQuantity = builder.goalQuantity;
        this.estimatedCost = builder.estimatedCost;
        this.actualCost = builder.actualCost;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    // tobuild()
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .type(this.type)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .planDescription(this.planDescription)
                .plannerDepartment(this.plannerDepartment)
                .plannerName(this.plannerName)
                .status(this.status)
                .goalQuantity(this.goalQuantity)
                .estimatedCost(this.estimatedCost)
                .actualCost(this.actualCost);
    }

    // getters

    public String getId() {
        return id;
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

    public BigDecimal getGoalQuantity() {
        return goalQuantity;
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
                ", type=" + type +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", planDescription='" + planDescription + '\'' +
                ", plannerDepartment='" + plannerDepartment + '\'' +
                ", plannerName='" + plannerName + '\'' +
                ", status=" + status +
                ", goalQuantity='" + goalQuantity + '\'' +
                ", estimatedCost=" + estimatedCost +
                ", actualCost=" + actualCost +
                '}';
    }
}