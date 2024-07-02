package com.erp.system.production.model.basic_information_management.workcenter_process;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

/*
 * 작업장 정보 관리 테이블
 */

@EnumMapping
public class Workcenter {
    public enum WorkcenterType { PRODUCTION, ASSEMBLY, QUALITY_CONTROL, STORAGE };

    @Unique
    @NotNull
    private final String id; // 작업장코드 (PK)
    @NotNull
    @Unique
    private String name; // 작업장명
    @NotNull
    private WorkcenterType type; // 작업장구분 (예: 생산, 조립, 품질 관리, 창고 등)
    @NotNull
    private String primaryResourceId; // 주작업자원 (FK, 생산자원코드)
    @NotNull
    private String description; // 작업장에 대한 설명

    private int inputPersonnel; // 투입인원수

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;

        private WorkcenterType type;
        private String description;
        private String primaryResourceId;
        private int inputPersonnel;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder type(WorkcenterType type) {
            this.type = type;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder primaryResourceId(String primaryResourceId) {
            this.primaryResourceId = primaryResourceId;
            return this;
        }

        public Builder inputPersonnel(int inputPersonnel) {
            this.inputPersonnel = inputPersonnel;
            return this;
        }

        public Workcenter build() {
            return new Workcenter(this);
        }
    } // end of Builder

    private Workcenter(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.primaryResourceId = builder.primaryResourceId;
        this.inputPersonnel = builder.inputPersonnel;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .type(this.type)
                .description(this.description)
                .primaryResourceId(this.primaryResourceId)
                .inputPersonnel(this.inputPersonnel);

    }

    // getters


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public WorkcenterType getType() {
        return type;
    }

    public String getPrimaryResourceId() {
        return primaryResourceId;
    }

    public String getDescription() {
        return description;
    }

    public int getInputPersonnel() {
        return inputPersonnel;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "Workcenter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", primaryResourceType=" + primaryResourceId +
                ", inputPersonnel=" + inputPersonnel +
                '}';
    }
}
