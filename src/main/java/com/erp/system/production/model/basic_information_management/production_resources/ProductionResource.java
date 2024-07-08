package com.erp.system.production.model.basic_information_management.production_resources;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

/** 생산 활동에 필요한 인력, 기계, 도구 등의 자원을 관리하여
 *  각 공정에서 어떤 자원을 사용할지 정의하고 최적화하기 위한 테이블
 *  제품을 만들 때 필요한 사람, 기계, 도구 등의 정보를 기록하고 관리하는 정보
 *  Workcenter와 Routing 테이블과 연관되어 사용 -> 특정 공정에서 어떤 자원 사용할지 정의
 */

@EnumMapping
public class ProductionResource {
    public enum Type { MACHINE, HUMAN_RESOURCE, TOOL, MATERIAL, SYSTEM, ENERGY, SOFTWARE, VEHICLE }
    public enum Status { AVAILABLE, IN_USE, MAINTENANCE, DEACTIVATED }


    @NotNull
    @Unique
    private final String id; // 생산자원코드 (PK)
    @NotNull
    @Unique
    private String name; // 생산자원명
    @NotNull
    private Type type; // 생산자원 유형 (예: 기계, 인력, 도구 등)
    private String description; // 설명
    private Status status; // 자원의 상태
    private String location; // 자원의 위치 (nullable)
    private LocalDate purchaseDate; // 구매 날짜 (nullable)
    private Integer lifecycle; // 예상 수명 주기 (연 단위, nullable) *기본형 int는 null 값 허용x 항상 0 초기화
    private BigDecimal cost; // 비용 정보 (nullable)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;
        private Type type;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ProductionResource build() {
            return new ProductionResource(this);
        }
    }

    // private 생성자
    private ProductionResource(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .type(this.type)
                .description(this.description);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    // toString
    @Override
    public String toString() {
        return "ProductionResource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
