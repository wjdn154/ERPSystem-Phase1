package com.erp.system.production.model.production_plan_management.production_plan;

import java.time.LocalDate;
import java.util.UUID;

// 일간 생산 계획
public class DailyProductionPlan {

    private final String id; // 일간 생산 계획 ID
    private final String code; // 일간 생산 계획 CODE
    private final String weeklyProductionId; // 주간 생산 계획 ID

    private LocalDate date; // 계획 일자
    private int quantity; // 생산 계획 수량 (목표 수량)
    private String description; // 계획 내용

    private DailyProductionPlan(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.weeklyProductionId = builder.weeklyProductionId;
        this.date = builder.date;
        this.quantity = builder.quantity;
        this.description = builder.description;
    }

    public static class Builder {
        private final String id; // 일간 생산 계획 ID
        private final String code; // 일간 생산 계획 CODE
        private final String weeklyProductionId; // 주간 생산 계획 ID

        private LocalDate date; // 계획 일자
        private int quantity; // 생산 계획 수량 (목표 수량)
        private String description; // 계획 내용

        public Builder(String code, String weeklyProductionId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.weeklyProductionId = weeklyProductionId;
        }

        public Builder date(LocalDate date) {
            this.date = date;
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

        public DailyProductionPlan build() {
            return new DailyProductionPlan(this);
        }
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getWeeklyProductionId() {
        return weeklyProductionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }
}