package com.erp.system.production.model.production_standard_information.routing_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

/**
 * RoutingStep 정보 관리 테이블
 */
public class RoutingStep {
    @NotNull
    @Unique
    private final String id; // 단계 ID (PK, not null, unique)
    @NotNull
    private final String routingId; // FK
    @NotNull
    private final String productionProcessId; //FK
    @NotNull
    private String stepName; // 단계명
    @NotNull
    private int sequence; // 단계 순서
    @NotNull
    private double time; // 소요 시간

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String routingId;
        private String productionProcessId;
        private String stepName;
        private int sequence;
        private double time;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder routingId(String routingId) {
            this.routingId = routingId;
            return this;
        }

        public Builder productionProcessId(String productionProcessId) {
            this.productionProcessId = productionProcessId;
            return this;
        }

        public Builder stepName(String stepName) {
            this.stepName = stepName;
            return this;
        }

        public Builder sequence(int sequence) {
            this.sequence = sequence;
            return this;
        }

        public Builder time(double time) {
            this.time = time;
            return this;
        }

        public RoutingStep build() {
            return new RoutingStep(this);
        }
    }

    private RoutingStep(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.routingId = builder.routingId;
        this.productionProcessId = builder.productionProcessId;
        this.stepName = builder.stepName;
        this.sequence = builder.sequence;
        this.time = builder.time;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .routingId(this.routingId)
                .productionProcessId(this.productionProcessId)
                .stepName(this.stepName)
                .sequence(this.sequence)
                .time(this.time);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getRoutingId() {
        return routingId;
    }

    public String getProductionProcessId() {
        return productionProcessId;
    }

    public String getStepName() {
        return stepName;
    }

    public int getSequence() {
        return sequence;
    }

    public double getTime() {
        return time;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "RoutingStep{" +
                "id='" + id + '\'' +
                ", routingId='" + routingId + '\'' +
                ", productionProcessId='" + productionProcessId + '\'' +
                ", stepName='" + stepName + '\'' +
                ", sequence=" + sequence +
                ", time=" + time +
                '}';
    }
}
