package com.erp.system.production.model.production_plan_management.production_plan;

import java.time.LocalDate;
import java.util.UUID;

// 분기 생산 계획
public class QuarterlyProductionPlan {

    private final String id; // 분기 생산 계획 ID
    private final String code; // 분기 생산 계획 CODE
    private final String annualProductionId; // 연간 생산 계획 ID

    private int quarter; // 계획 분기
    private int quantity; // 생산 계획 수량 (목표 수량)
    private String description; // 계획 내용
    private LocalDate date; // 계획 생성 일자

    private QuarterlyProductionPlan(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.annualProductionId = builder.annualProductionId;
        this.quarter = builder.quarter;
        this.quantity = builder.quantity;
        this.description = builder.description;
        this.date = builder.date;
    }

    public static class Builder {
        private final String id; // 분기 생산 계획 ID
        private final String code; // 분기 생산 계획 CODE
        private final String annualProductionId; // 연간 생산 계획 ID

        private int quarter; // 계획 분기
        private int quantity; // 생산 계획 수량 (목표 수량)
        private String description; // 계획 내용
        private LocalDate date; // 계획 생성 일자

        public Builder(String code, String annualProductionId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.annualProductionId = annualProductionId;
        }

        public Builder quarter(int quarter) {
            this.quarter = quarter;
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

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public QuarterlyProductionPlan build() {
            return new QuarterlyProductionPlan(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getAnnualProductionId() {
        return annualProductionId;
    }

    public int getQuarter() {
        return quarter;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
