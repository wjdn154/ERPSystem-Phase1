package src.main.java.com.erp.system.production.model.master_data_management.design_change;

// 설계 변경 관리

import java.time.LocalDate;
import java.util.UUID;

public class DesignChange {

    private final String id; // 설계 변경 ID
    private final String code; // 설계 변경 CODE
    private final String productId; // 제품 ID

    private String description; // 변경 내용
    private LocalDate date; // 변경 일자

    public DesignChange(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.productId = builder.productId;
        this.description = builder.description;
        this.date = builder.date;
    }

    public static class Builder {
        private final String id; // 설계 변경 ID
        private final String code; // 설계 변경 CODE
        private final String productId; // 제품 ID

        private String description; // 변경 내용
        private LocalDate date; // 변경 일자

        public Builder(String code, String productId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.productId = productId;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public DesignChange build() {
            return new DesignChange(this);
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

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
