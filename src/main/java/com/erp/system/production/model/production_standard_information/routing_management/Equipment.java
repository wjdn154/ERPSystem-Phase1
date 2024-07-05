package com.erp.system.production.model.production_standard_information.routing_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

// TODO : Complete table

public class Equipment {
    @NotNull
    @Unique
    private final String id;

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
    }

    private Equipment(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id);
    }

    // Getters
    public String getId() { return id;}

    public static int getIdIndex() { return idIndex;}

    @Override
    public String toString() {
        return "Equipment{" +
                "id='" + id + '\'' +
                ", '" + "" + '\'' +
                '}';
    }
}
