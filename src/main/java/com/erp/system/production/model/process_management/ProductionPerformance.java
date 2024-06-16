package src.main.java.com.erp.system.production.model.process_management;

import java.time.LocalDate;
import java.util.UUID;

// 생산실적 관리
public class ProductionPerformance {
    private final String id; // 생산실적 ID
    private final String code; // 생산실적 CODE
    private final String productionPlanId; // 생산 계획 ID (일간, 주간, 월간, 분기, 연간)

    private String productId; // 제품 ID
    private int quantity; // 생산수량
    private LocalDate recordDate; // 생산실적 기록 일자

    public ProductionPerformance(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.productionPlanId = builder.productionPlanId;
        this.productId = builder.productId;
        this.quantity = builder.quantity;
        this.recordDate = builder.recordDate;
    }

    public static class Builder {
        private final String id; // 생산실적 ID
        private final String code; // 생산실적 CODE
        private final String productionPlanId; // 생산 계획 ID

        private String productId; // 제품 ID
        private int quantity; // 생산수량
        private LocalDate recordDate; // 생산실적 기록 일자

        public Builder(String code, String productionPlanId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.productionPlanId = productionPlanId;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder recordDate(LocalDate recordDate) {
            this.recordDate = recordDate;
            return this;
        }

        public ProductionPerformance build() {
            return new ProductionPerformance(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getProductionPlanId() {
        return productionPlanId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }
}
