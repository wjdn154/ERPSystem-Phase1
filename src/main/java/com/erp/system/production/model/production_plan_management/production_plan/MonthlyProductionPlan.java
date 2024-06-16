package src.main.java.com.erp.system.production.model.production_plan_management.production_plan;

import java.time.LocalDate;
import java.util.UUID;

// 월간 생산 계획
public class MonthlyProductionPlan {
    private final String id; // 월간 생산 계획 ID
    private final String code; // 월간 생산 계획 CODE
    private final String quarterlyProductionId; // 분기 생산 계획 ID

    private int month; // 계획 월
    private int quantity; // 생산 계획 수량 (목표 수량)
    private String description; // 계획 내용
    private LocalDate date; // 계획 생성 일자

    private MonthlyProductionPlan(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.quarterlyProductionId = builder.quarterlyProductionId;
        this.month = builder.month;
        this.quantity = builder.quantity;
        this.description = builder.description;
        this.date = builder.date;
    }

    public static class Builder {
        private final String id; // 월간 생산 계획 ID
        private final String code; // 월간 생산 계획 CODE
        private final String quarterlyProductionId; // 분기 생산 계획 ID

        private int month; // 계획 월
        private int quantity; // 생산 계획 수량 (목표 수량)
        private String description; // 계획 내용
        private LocalDate date; // 계획 생성 일자

        public Builder(String code, String quarterlyProductionId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.quarterlyProductionId = quarterlyProductionId;
        }

        public Builder month(int month) {
            this.month = month;
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

        public MonthlyProductionPlan build() {
            return new MonthlyProductionPlan(this);
        }
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getQuarterlyProductionId() {
        return quarterlyProductionId;
    }

    public int getMonth() {
        return month;
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
