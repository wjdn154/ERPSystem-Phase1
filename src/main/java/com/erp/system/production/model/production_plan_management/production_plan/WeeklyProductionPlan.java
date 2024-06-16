package src.main.java.com.erp.system.production.model.production_plan_management.production_plan;

import java.time.LocalDate;
import java.util.UUID;

// 주간 생산 계획
public class WeeklyProductionPlan {

    private final String id; // 주간 생산 계획 ID
    private final String code; // 주간 생산 계획 CODE
    private final String monthlyProductionId; // 월간 생산 계획 ID

    private LocalDate startDate; // 계획 시작일
    private LocalDate endDate; // 계획 종료일
    private int quantity; // 생산 계획 수량 (목표 수량)
    private String description; // 계획 내용

    private WeeklyProductionPlan(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.monthlyProductionId = builder.monthlyProductionId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.quantity = builder.quantity;
        this.description = builder.description;
    }

    public static class Builder {
        private final String id; // 주간 생산 계획 ID
        private final String code; // 주간 생산 계획 CODE
        private final String monthlyProductionId; // 월간 생산 계획 ID

        private LocalDate startDate; // 계획 시작일
        private LocalDate endDate; // 계획 종료일
        private int quantity; // 생산 계획 수량 (목표 수량)
        private String description; // 계획 내용

        public Builder(String code, String monthlyProductionId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.monthlyProductionId = monthlyProductionId;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public WeeklyProductionPlan build() {
            return new WeeklyProductionPlan(this);
        }
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getMonthlyProductionId() {
        return monthlyProductionId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}