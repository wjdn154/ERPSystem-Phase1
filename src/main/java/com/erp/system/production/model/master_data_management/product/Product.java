package src.main.java.com.erp.system.production.model.master_data_management.product;

import java.time.LocalDate;
import java.util.UUID;

/*
생산한 제품 항목
 */
public class Product {

    private final String id; // 제품 ID
    private final String code; // 제품 CODE

    private String name; // 제품명
    private String category; // 제품 구분 카테고리
    private String description; // 제품 설명
    private LocalDate releaseDate; // 출시일

    public Product(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
        this.category = builder.category;
        this.description = builder.description;
        this.releaseDate = builder.releaseDate;
    }

    public static class Builder {
        private final String id; // 제품 ID
        private final String code; // 제품 CODE

        private String name; // 제품명
        private String category; // 제품 구분 카테고리
        private String description; // 제품 설명
        private LocalDate releaseDate; // 출시일

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
