package src.main.java.com.erp.system.production.model.process_management;

import java.util.UUID;

// 공정 관리

public class Process {

    private final String id; // 공정 ID
    private final String code; // 공정 CODE
    private final String productId; // 제품 ID

    private String name; // 공정 이름
    private String description; // 공정 설명

    private Process(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.productId = builder.productId;
        this.name = builder.name;
        this.description = builder.description;
    }

    public static class Builder {
        private final String id; // 공정 ID
        private final String code; // 공정 CODE
        private final String productId; // 제품 ID

        private String name; // 공정 이름
        private String description; // 공정 설명

        public Builder(String code, String productId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.productId = productId;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Process build() {
            return new Process(this);
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

    public String getDescription() {
        return description;
    }
}
