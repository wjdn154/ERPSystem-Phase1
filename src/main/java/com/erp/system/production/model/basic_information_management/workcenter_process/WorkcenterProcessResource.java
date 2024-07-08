package com.erp.system.production.model.basic_information_management.workcenter_process;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

/**
 * 작업장 생산공정 자원관리: 각 작업장 공정에 할당된 자원을 관리하는 테이블 for 다대다 관계 매핑
 */

public class WorkcenterProcessResource {
    @Unique
    @NotNull
    private final String id; // PK
    @NotNull
    private String processId; // (FK, WorkcenterProcess.id) 작업장공정코드
    @NotNull
    private String resourceId; // (FK, ProductionResource.id) // 생산자원코드

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String processId;
        private String resourceId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder processId(String processId) {
            this.processId = processId;
            return this;
        }

        public Builder resourceId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }

        public WorkcenterProcessResource build() { return new WorkcenterProcessResource(this); }
    }

    private WorkcenterProcessResource(Builder builder) {
        this.id = builder.id != null? builder.id : Integer.toString(idIndex++);
        this.processId = builder.processId;
        this.resourceId = builder.resourceId;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .processId(this.processId)
                .resourceId(this.resourceId);
    }

    // Getters


    public String getId() {
        return id;
    }

    public String getProcessId() {
        return processId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "WorkcenterProcessResource{" +
            "id ='" + id + '\'' +
            ", processId ='" + processId + '\'' +
            ", resourceId ='" + resourceId +
            '}';
    }
}
