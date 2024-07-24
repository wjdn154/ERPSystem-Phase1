package com.erp.system.production.model.dto;

import com.erp.system.production.model.work_order_management.RequestBasedPlan;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 생산요청기반 생산계획 등록을 위한 데이터 전송 객체 (DTO)
 */
public class RequestBasedPlanDto {
    private String id;
    private String productionRequestId;
    private RequestBasedPlan.PlanType type;
    private LocalDate startDate;
    private LocalDate endDate;
    private String planDescription;
    private String plannerDepartment;
    private String plannerName;
    private RequestBasedPlan.Status status;
    private BigDecimal goalQuantity;
    private BigDecimal estimatedCost;
    private BigDecimal actualCost;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getProductionRequestId() { return productionRequestId; }
    public void setProductionRequestId(String productionRequestId) { this.productionRequestId = productionRequestId; }

    public RequestBasedPlan.PlanType getType() { return type; }
    public void setType(RequestBasedPlan.PlanType type) { this.type = type; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getPlanDescription() { return planDescription; }
    public void setPlanDescription(String planDescription) { this.planDescription = planDescription; }

    public String getPlannerDepartment() { return plannerDepartment; }
    public void setPlannerDepartment(String plannerDepartment) { this.plannerDepartment = plannerDepartment; }

    public String getPlannerName() { return plannerName; }
    public void setPlannerName(String plannerName) { this.plannerName = plannerName; }

    public RequestBasedPlan.Status getStatus() { return status; }
    public void setStatus(RequestBasedPlan.Status status) { this.status = status; }

    public BigDecimal getGoalQuantity() { return goalQuantity; }
    public void setGoalQuantity(BigDecimal goalQuantity) { this.goalQuantity = goalQuantity; }

    public BigDecimal getEstimatedCost() { return estimatedCost; }
    public void setEstimatedCost(BigDecimal estimatedCost) { this.estimatedCost = estimatedCost; }

    public BigDecimal getActualCost() { return actualCost; }
    public void setActualCost(BigDecimal actualCost) { this.actualCost = actualCost; }
}

