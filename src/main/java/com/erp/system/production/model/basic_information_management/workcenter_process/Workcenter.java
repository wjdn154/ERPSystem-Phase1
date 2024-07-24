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
    public enum WorkcenterType { PRODUCTION, ASSEMBLY, QUALITY_CONTROL, PACKAGING, MAINTENANCE, R_AND_D, TEST, LOGISTICS };

    @Unique
    @NotNull
    private final String id; // 작업장코드 (PK)
    @NotNull
    private final String factoryId; // 공장코드 (FK)
    @NotNull
    private String primaryProcessId; // 주생산공정 (FK, 생산공정코드)
    @NotNull
    private String primaryResourceId; // 주작업자원 (FK, 생산자원코드)
    @NotNull
    @Unique
    private String name; // 작업장명
    @NotNull
    private WorkcenterType type; // 작업장구분 (예: 생산, 조립, 품질 관리 등)
    @NotNull
    private String description; // 작업장에 대한 설명
    @NotNull
    private int inputPersonnel; // 투입인원수 ( 변동 잦을 수 있는 값이라 nullable )

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String factoryId;
        private String primaryProcessId;
        private String primaryResourceId;
        private String name;
        private WorkcenterType type;
        private String description;
        private int inputPersonnel;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder factoryId(String id) {
            this.factoryId = factoryId;
            return this;
        }

        public Builder primaryProcessId(String primaryProcessId) {
            this.primaryProcessId = primaryProcessId;
            return this;
        }

        public Builder primaryResourceId(String primaryResourceId) {
            this.primaryResourceId = primaryResourceId;
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
        this.factoryId = builder.factoryId;
        this.primaryProcessId = builder.primaryProcessId;
        this.primaryResourceId = builder.primaryResourceId;
        this.name = builder.name;
        this.type = builder.type;
        this.description = builder.description;
        this.inputPersonnel = builder.inputPersonnel;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .factoryId(this.factoryId)
                .primaryProcessId(this.primaryProcessId)
                .primaryResourceId(this.primaryResourceId)
                .name(this.name)
                .type(this.type)
                .description(this.description)
                .inputPersonnel(this.inputPersonnel);

    }

    // getters


    public String getId() {
        return id;
    }

    public String getFactoryId() { return factoryId; }

    public String getPrimaryProcessId() { return primaryProcessId; }

    public String getPrimaryResourceId() { return primaryResourceId; }

    public String getName() { return name; }

    public WorkcenterType getType() { return type; }

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
                ", factoryId'" + factoryId + '\'' +
                ", primaryProcessId'" + primaryProcessId + '\'' +
                ", primaryResourceId=" + primaryResourceId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", inputPersonnel=" + inputPersonnel +
                '}';
    }
}
