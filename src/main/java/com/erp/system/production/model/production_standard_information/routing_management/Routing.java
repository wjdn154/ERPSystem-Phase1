package com.erp.system.production.model.production_standard_information.routing_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.util.List;

/**
 * Routing 정보 관리 테이블 : 각 생산품목에 대해 공정 경로를 정의하고 관리하여
 * 생산 공정의 효율성을 극대화하기 위해 사용
 * 제품을 만들기 위해 어떤 작업을 어떤 순서로 해야 하는지 기록하고 관리
 */

@EnumMapping
public class Routing {
    public enum Type { TYPE_A, TYPE_B, TYPE_C }

    @NotNull
    @Unique
    private final String id; // 공정경로코드: 공정 경로 코드 (PK, not null, unique)
    @NotNull
    @Unique
    private String name; // Routing의 이름
    @NotNull
    private Type type; // 공정 경로 유형
    @NotNull
    private String description; // Routing 설명
    @NotNull
    private boolean isStandard; // 표준 여부
    @NotNull
    private boolean isActive; // 사용 여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;
        private Type type;
        private String description;
        private boolean isStandard;
        private boolean isActive;
        private List<RoutingStep> steps;

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

        public Builder isStandard(boolean isStandard) {
            this.isStandard = isStandard;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder steps(List<RoutingStep> steps) {
            this.steps = steps;
            return this;
        }

        public Routing build() {
            return new Routing(this);
        }
    }

    private Routing(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.isStandard = builder.isStandard;
        this.isActive = builder.isActive;
        this.steps = builder.steps;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .type(this.type)
                .description(this.description)
                .isStandard(this.isStandard)
                .isActive(this.isActive)
                .steps(this.steps);
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

    public boolean isStandard() {
        return isStandard;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<RoutingStep> getSteps() {
        return steps;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "Routing{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type + '\'' +
                ", description='" + description + '\'' +
                ", isStandard=" + isStandard + '\'' +
                ", isActive=" + isActive + '\'' +
                ", steps=" + steps +
                '}';
    }
}