package src.main.java.com.erp.system.production.model.master_data_management.routing;

// 공정경로 관리

import java.time.LocalDate;
import java.util.UUID;

public class Routing {
    private final String id; // 공정경로 ID
    private final String code; // 공정경로 CODE
    private final String productId; // 제품 ID

    private String name; // 공정경로 이름
    private LocalDate effectiveDate; // 공정경로 유효 시작일
    private LocalDate expirationDate; // 공정경로 유효 종료일

    public Routing(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.productId = builder.productId;
        this.name = builder.name;
        this.effectiveDate = builder.effectiveDate;
        this.expirationDate = builder.expirationDate;
    }

    public static class Builder {
        private final String id; // 공정경로 ID
        private final String code; // 공정경로 CODE
        private final String productId; // 제품 ID

        private String name; // 공정경로 이름
        private LocalDate effectiveDate; // 공정경로 유효 시작일
        private LocalDate expirationDate; // 공정경로 유효 종료일

        public Builder(String code, String productId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.productId = productId;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder effectiveDate(LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }

        public Builder expirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Routing build() {
            return new Routing(this);
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

    public String getName() {
        return name;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
