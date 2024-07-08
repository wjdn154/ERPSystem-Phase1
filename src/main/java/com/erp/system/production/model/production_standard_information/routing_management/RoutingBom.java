package com.erp.system.production.model.production_standard_information.routing_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

/**
 * Routing과 Bom 매핑 테이블
 */

public class RoutingBom {
    @Unique
    @NotNull
    private final String id; // RoutingBom코드 (PK)
    @NotNull
    private final String routingId; // FK, Routing.id
    private final String bomId; // FK, Bom.id

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String routingId;
        private String bomId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder routingId(String routingId) {
            this.routingId = routingId;
            return this;
        }

        public Builder bomId(String bomId) {
            this.bomId = bomId;
            return this;
        }

        public RoutingBom build() {
            return new RoutingBom(this);
        }
    }

    private RoutingBom(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.routingId = builder.routingId;
        this.bomId = builder.bomId;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .routingId(this.routingId)
                .bomId(this.bomId);
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getRoutingId() {
        return routingId;
    }

    public String getBomId() {
        return bomId;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "RoutingBom{" +
                "id='" + id + '\'' +
                ", routingId='" + routingId + '\'' +
                ", bomId='" + bomId + '\'' +
                '}';
    }
}