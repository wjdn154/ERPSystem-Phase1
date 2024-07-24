package com.erp.system.production.model.basic_information_management.workcenter_process;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

/*
	생산공정 테이블 : 생산 공정 정보 관리
*/

public class ProductionProcess {
    @Unique
    @NotNull
    private final String id; // 생산공정코드 (PK)
    @NotNull
    private String defaultInboundId; // 입고기본위치 (FK, 창고 테이블의 ID 참조)
    @NotNull
    private String defaultOutboundId; // 출고기본위치 (FK, 창고 테이블의 ID 참조)
    @Unique
    @NotNull
    private final String processName; // 생산공정명
    @NotNull
    private String description; // 공정 설명
    private boolean isActive; // 해당 공정 사용 여부(0: 미사용, 1: 사용)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String defaultInboundId;
        private String defaultOutboundId;

        private String processName;
        private String description;
        private boolean isActive;

        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder defaultInboundId(String defaultInboundId) {
            this.defaultInboundId = defaultInboundId;
            return this;
        }
        public Builder defaultOutboundId(String defaultOutboundId) {
            this.defaultOutboundId = defaultOutboundId;
            return this;
        }
        public Builder processName(String processName) {
            this.processName = processName;
            return this;
        }
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }
    } // end of Builder

    private ProductionProcess(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.defaultInboundId = builder.defaultInboundId;
        this.defaultOutboundId = builder.defaultOutboundId;
        this.processName = builder.processName;
        this.description = builder.description;
        this.isActive = builder.isActive;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .defaultInboundId(this.defaultInboundId)
                .defaultOutboundId(this.defaultOutboundId)
                .processName(this.processName)
                .description(this.description)
                .isActive(this.isActive);
    }

    public String getId() {
        return id;
    }

    public String getDefaultInboundId() {
        return defaultInboundId;
    }

    public String getDefaultOutboundId() {
        return defaultOutboundId;
    }

    public String getProcessName() {
        return processName;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return isActive;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "ProductionProcess{" +
                "id='" + id + '\'' +
                ", defaultInboundId='" + defaultInboundId + '\'' +
                ", defaultOutboundId='" + defaultOutboundId + '\'' +
                ", processName='" + processName + '\'' +
                ", description='" + description + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
