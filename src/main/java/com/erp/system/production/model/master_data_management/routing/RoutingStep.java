package com.erp.system.production.model.master_data_management.routing;

import java.util.UUID;

// 공정경로 각 단계
public class RoutingStep {

    private final String id; // 공정단계 ID
    private final String code; // 공정단계 CODE
    private final String routingId; // 공정경로 ID

    private int order; // 공정 순서
    private String description; // 해당 단계 작업내용 설명
    private int duration; // 소요시간 (분 단위)

    private RoutingStep(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.routingId = builder.routingId;
        this.order = builder.order;
        this.description = builder.description;
        this.duration = builder.duration;
    }

    public static class Builder {
        private final String id; // 공정단계 ID
        private final String code; // 공정단계 CODE
        private final String routingId; // 공정경로 ID

        private int order; // 공정 순서
        private String description; // 해당 단계 작업내용 설명
        private int duration; // 소요시간 (분 단위)

        public Builder(String code, String routingId) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.routingId = routingId;
        }

        public Builder order(int order) {
            this.order = order;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public RoutingStep build() {
            return new RoutingStep(this);
        }
    } // end of Builder

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getRoutingId() {
        return routingId;
    }

    public int getOrder() {
        return order;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }
}
