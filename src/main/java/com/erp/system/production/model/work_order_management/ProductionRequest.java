package com.erp.system.production.model.work_order_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
 * 고객 또는 내부 부서로부터 제품 생산요청 관리 테이블
 * 발생 시점에 따라 개별적으로 기록되며, 주로 요청 단위로 관리하는 테이블
 */

@EnumMapping
public class ProductionRequest {
    public enum Status { ENROLLED, CONFIRMED, CANCELED };
    public enum RequestProductionType { MAKE_TO_ORDER, MAKE_TO_STOCK, ASSEMBLE_TO_ORDER, CUSTOM_DESIGN_REQUEST, PROTOTYPE_REQUEST }

    @NotNull
    @Unique
    private final String id; // 요청코드: 생산 요청을 식별하기 위한 고유 코드 (PK, not null, unique)
    @NotNull
    private String requesterId; // 요청자 ID: 생산 요청을 한 사람의 고유 ID (FK, 참조: User.id, not null) - 요청자명, 요청자부서
    @NotNull
    private String productId; // 제품 ID (FK, 참조: Product.id, not null)
    @NotNull
    private String requestName; // 요청명: 생산 요청의 이름
    @NotNull
    private LocalDate requestDate; // 요청 일자
    @NotNull
    private BigDecimal requestQuantity; // 요청 수량
    @NotNull
    private Status status; // 요청의 상태 (등록, 확정, 취소)
    @NotNull
    private RequestProductionType requestProductionType; // 생산유형
    private boolean isActive; // 사용 여부
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String requesterId;
        private String productId;
        private String requestName;
        private LocalDate requestDate;
        private BigDecimal requestQuantity;
        private Status status;
        private boolean isActive;
        private RequestProductionType requestProductionType;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder requesterId(String requesterId) {
            this.requesterId = requesterId;
            return this;
        }

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder requestName(String requestName) {
            this.requestName = requestName;
            return this;
        }

        public Builder requestDate(LocalDate requestDate) {
            this.requestDate = requestDate;
            return this;
        }

        public Builder requestQuantity(BigDecimal requestQuantity) {
            this.requestQuantity = requestQuantity;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder requestProductionType(RequestProductionType requestProductionType) {
            this.requestProductionType = requestProductionType;
            return this;
        }

        public Builder remarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public ProductionRequest build() {
            return new ProductionRequest(this);
        }
    }

    private ProductionRequest(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.requesterId = builder.requesterId;
        this.productId = builder.productId;
        this.requestDate = builder.requestDate;
        this.requestName = builder.requestName;
        this.requestQuantity = builder.requestQuantity;
        this.status = builder.status;
        this.isActive = builder.isActive;
        this.requestProductionType = builder.requestProductionType;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .requesterId(this.requesterId)
                .productId(this.productId)
                .requestName(this.requestName)
                .requestDate(this.requestDate)
                .requestQuantity(this.requestQuantity)
                .status(this.status)
                .isActive(this.isActive)
                .requestProductionType(this.requestProductionType)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public String getProductId() {
        return productId;
    }

    public String getRequestName() {
        return requestName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public BigDecimal getRequestQuantity() {
        return requestQuantity;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isActive() {
        return isActive;
    }

    public RequestProductionType getRequestProductionType() { return requestProductionType; }

    public String getRemarks() {
        return remarks;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "ProductionRequest{" +
                "id='" + id + '\'' +
                ", requesterId='" + requesterId + '\'' +
                ", productId='" + productId + '\'' +
                ", requestName='" + requestName + '\'' +
                ", requestDate=" + requestDate +
                ", requestQuantity=" + requestQuantity +
                ", status=" + status + '\'' +
                ", isActive=" + isActive + '\'' +
                ", requestProductionType=" + requestProductionType + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
