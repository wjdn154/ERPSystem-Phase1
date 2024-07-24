package com.erp.system.production.model.work_order_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;

import java.time.LocalDate;
import java.math.BigDecimal;

/**
 * 생산계획에 따라 구체적인 작업을 지시하여 개별 작업 지시 단위 정보를 관리하는 테이블
 *     // TODO 이렇게 되면 StockBasedPlan ID를 받을 작업지시 테이블을 또 만들고,
 *     // TODO 그럼 작업지시가 연결된 작업장에는...? 어떻게 나눠서 줘야 하지?
 *     // TODO 두 작업지시를 합친 종합 작업지시 테이블(매핑..테이블처럼?)을 만들어서??
 */
@EnumMapping
public class RequestBasedWorkOrder {
    public enum Status { REGISTERED, IN_PROGRESS, COMPLETED, CANCELED }

    @NotNull
    @Unique
    private final String id; // 지시코드: 작업 지시를 식별하기 위한 고유 코드 (PK, not null, unique)
    @NotNull
    private final String requestBasedPlanId; // 생산요청 기반 계획의 ID (FK)
    @NotNull
    private String workOrdererId; // 지시자: 작업 지시를 한 사람 (FK, 인사)
    @NotNull
    private String workOrderName; // 지시명: 작업 지시의 이름
    @NotNull
    private LocalDate workOrderDate; // 작업 지시 일자
    @NotNull
    private BigDecimal workOrderQuantity; // 작업 지시 수량
    @NotNull
    private Status status; // 지시의 상태 (등록, 진행, 완료, 취소)
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String requestBasedPlanId;
        private String workOrdererId;
        private String workOrderName;
        private LocalDate workOrderDate;
        private BigDecimal workOrderQuantity;
        private Status status;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder requestBasedPlanId(String requestBasedPlanId) {
            this.requestBasedPlanId = requestBasedPlanId;
            return this;
        }

        public Builder workOrdererId(String workOrdererId) {
            this.workOrdererId = workOrdererId;
            return this;
        }

        public Builder workOrderName(String workOrderName) {
            this.workOrderName = workOrderName;
            return this;
        }

        public Builder workOrderDate(LocalDate workOrderDate) {
            this.workOrderDate = workOrderDate;
            return this;
        }

        public Builder workOrderQuantity(BigDecimal workOrderQuantity) {
            this.workOrderQuantity = workOrderQuantity;
            return this;
        }


        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public RequestBasedWorkOrder build() {
            return new RequestBasedWorkOrder(this);
        }
    }

    private RequestBasedWorkOrder(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.requestBasedPlanId = builder.requestBasedPlanId;
        this.workOrdererId = builder.workOrdererId;
        this.workOrderName = builder.workOrderName;
        this.workOrderDate = builder.workOrderDate;
        this.workOrderQuantity = builder.workOrderQuantity;
        this.status = builder.status;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .requestBasedPlanId(this.requestBasedPlanId)
                .workOrdererId(this.workOrdererId)
                .workOrderName(this.workOrderName)
                .workOrderDate(this.workOrderDate)
                .workOrderQuantity(this.workOrderQuantity)
                .status(this.status)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getRequestBasedPlanId() {
        return requestBasedPlanId;
    }

    public String getWorkOrdererId() {
        return workOrdererId;
    }

    public String getWorkOrderName() {
        return workOrderName;
    }

    public LocalDate getWorkOrderDate() {
        return workOrderDate;
    }

    public BigDecimal getWorkOrderQuantity() {
        return workOrderQuantity;
    }

    public Status getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "WorkOrderStatus{" +
                "id='" + id + '\'' +
                ", requestBasedPlanId='" + requestBasedPlanId + '\'' +
                ", workOrdererId='" + workOrdererId + '\'' +
                ", workOrderName='" + workOrderName + '\'' +
                ", workOrderDate=" + workOrderDate +
                ", workOrderQuantity=" + workOrderQuantity +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
