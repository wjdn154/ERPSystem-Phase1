package src.main.java.com.erp.system.production.model.equipment_management;

import java.time.LocalDate;
import java.util.UUID;

// 설비 정보 관리
public class Equipment {

    private final String id; // 설비 ID
    private final String code; // 설비 CODE

    private String name; // 설비 이름
    private LocalDate purchaseDate; // 구입일자
    private String location; // 위치

    private Equipment(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.name = builder.name;
        this.purchaseDate = builder.purchaseDate;
        this.location = builder.location;
    }

    public static class Builder {
        private final String id; // 설비 ID
        private final String code; // 설비 CODE

        private String name; // 설비 이름
        private LocalDate purchaseDate; // 구입일자
        private String location; // 위치

        public Builder(String code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder purchaseDate(LocalDate purchaseDate) {
            this.purchaseDate = purchaseDate;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Equipment build() {
            return new Equipment(this);
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

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getLocation() {
        return location;
    }
}
