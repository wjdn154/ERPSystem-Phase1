package com.erp.system.production.model.work_order_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

/**
 * 작업장에 여러 작업지시가 들어갈 수 있으므로,
 * 작업지시와 작업장을 이어주는 매핑 테이블 생성함
 */

public class WorkcenterOrder {
    @NotNull
    @Unique
    private String id; // pk
    @NotNull
    private String workcenterId; // FK 작업장코드
    @NotNull
    private String workOrderStatusId; // FK 작업지시현황코드

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String workcenterId;
        private String workOrderStatusId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder workcenterId(String workcenterId) {
            this.workcenterId = workcenterId;
            return this;
        }

        public Builder workOrderStatusId(String workOrderStatusID) {
            this.workOrderStatusId = workOrderStatusId;
            return this;
        }

        public WorkcenterOrder build() { return new WorkcenterOrder(this);}

    }
    private WorkcenterOrder(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.workcenterId = builder.workcenterId;
        this.workOrderStatusId = builder.workOrderStatusId;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .workcenterId(this.workcenterId)
                .workOrderStatusId(this.workOrderStatusId);
    }

    public String getId() {
        return id;
    }

    public String getWorkcenterId() {
        return workcenterId;
    }

    public String getWorkOrderStatusId() {
        return workOrderStatusId;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "WorkcenterOrder{" +
                "id='" + id + '\'' +
                ", workcenterId='" + workcenterId + '\'' +
                ", workOrderStatusId='" + workOrderStatusId + '\'' +
                '}';

    }

}
