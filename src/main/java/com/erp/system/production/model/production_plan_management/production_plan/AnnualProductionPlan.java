package src.main.java.com.erp.system.production.model.production_plan_management.production_plan;

import java.time.LocalDate;
import java.util.UUID;

// 연간생산 계획
public class AnnualProductionPlan {

    private final String id; // 연간생산 계획 ID
    private final String code; // 연간생산 계획 CODE
    private final String productId; // 제품 ID

    private int year; // 계획연도
    private int quantity; // 생산 계획 수량 (목표 수량)
    private String description; // 계획 내용
    private LocalDate date; // 계획 생성 일자

    private AnnualProductionPlan(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.productId = builder.productId;
        this.year = builder.year;
        this.quantity = builder.quantity;
        this.description = builder.description;
        this.date = builder.date;
    }

    public static class Builder {
        private final String id; // 연간생산 계획 ID
        private final String code; // 연간생산 계획 CODE
        private final String productId; // 제품 ID

        private int year; // 계획연도
        private int quantity; // 생산 계획 수량 (목표 수량)
        private String description; // 계획 내용
        private LocalDate date; // 계획 생성 일자

        public Builder(String code, String productId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.productId = productId;
        }

        public Builder year(int year) {
            this.year = year;
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

        public AnnualProductionPlan build() {
            return new AnnualProductionPlan(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getProductId() {
        return productId;
    }

    public int getYear() {
        return year;
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