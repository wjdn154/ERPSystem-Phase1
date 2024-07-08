package com.erp.system.production.model.basic_information_management.workcenter_process;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

public class WorkcenterProcess {
    @NotNull
    @Unique
    private final String id; // 작업장공정코드
    @NotNull
    @Unique
    private String processName; // 작업장의 공정명
    @NotNull
    private String workcenterId; // (FK, Workcenter.id) // 작업장코드
    @NotNull
    private String itemId; // (FK, item.id from 물류) // 품번코드
    @NotNull
    private boolean isActive; // 사용 여부

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String processName;
        private String workcenterId;
        private String itemId;
        private boolean isActive;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder processName(String processName) {
            this.processName = processName;
            return this;
        }

        public Builder workcenterId(String workcenterId) {
            this.workcenterId = workcenterId;
            return this;
        }

        public Builder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public WorkcenterProcess build() {
            return new WorkcenterProcess(this);
        }
    }

    private WorkcenterProcess(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.processName = builder.processName;
        this.workcenterId = builder.workcenterId;
        this.itemId = builder.itemId;
        this.isActive = builder.isActive;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .processName(this.processName)
                .workcenterId(this.workcenterId)
                .itemId(this.itemId)
                .isActive(this.isActive);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getProcessName() {
        return processName;
    }

    public String getWorkcenterId() {
        return workcenterId;
    }

    public String getItemId() {
        return itemId;
    }

    public boolean isActive() {
        return isActive;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    // toString
    @Override
    public String toString() {
        return "WorkcenterProcess{" +
                "id='" + id + '\'' +
                ", processName='" + processName + '\'' +
                ", workcenterId='" + workcenterId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
