package com.erp.system.production.model.basic_information_management.production_resources;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Material {
    @NotNull
    @Unique
    private final String id;
    @NotNull
    private String type; // TODO Type Enum?
    @NotNull
    @Unique
    private String name;
    @NotNull
    private BigDecimal quantity;
    @NotNull
    private LocalDateTime last_updated;

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String type;
        private String name;
        private BigDecimal quantity;
        private LocalDateTime last_updated;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder quantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder last_updated(LocalDateTime last_updated) {
            this.last_updated = last_updated;
            return this;
        }

        public Material build() { return new Material(this);}
    }

    private Material(Builder builder) {

        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.type = builder.type;
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.last_updated = builder.last_updated;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    // tobuild() 
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .type(this.type)
                .name(this.name)
                .quantity(this.quantity)
                .last_updated(this.last_updated);
    }

    // Getters
    public String getId() { return id;}

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public static int getIdIndex() { return idIndex;}

    @Override
    public String toString() {
        return "Material{" +
                "id='" + id + '\'' +
                ", type'" + type + '\'' +
                ", name'" + name + '\'' +
                ", quantity'" + quantity + '\'' +
                ", last_updated'" + last_updated + '\'' +
                '}';
    }
}
