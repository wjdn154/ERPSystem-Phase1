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
    private String stepName; // 단계명
    @NotNull
    private int sequence; // 단계 순서
    @NotNull
    private String equipment; // 사용할 장비
    @NotNull
    private double time; // 소요 시간

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String stepName;
        private int sequence;
        private String equipment;
        private double time;

        public Builder id(String id) {
            this.id = id;
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

        public Builder equipment(String equipment) {
            this.equipment = equipment;
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
        this.stepName = builder.stepName;
        this.sequence = builder.sequence;
        this.equipment = builder.equipment;
        this.time = builder.time;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .stepName(this.stepName)
                .sequence(this.sequence)
                .equipment(this.equipment)
                .time(this.time);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getStepName() {
        return stepName;
    }

    public int getSequence() {
        return sequence;
    }

    public String getEquipment() {
        return equipment;
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
                ", stepName='" + stepName + '\'' +
                ", sequence=" + sequence +
                ", equipment='" + equipment + '\'' +
                ", time=" + time +
                '}';
    }
}
