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
public class ProductionRequestManagement {
    public enum Status { ENROLLED, CONFIRMED, CANCELED };

    @NotNull
    @Unique
    private final String id; // 요청코드: 생산 요청을 식별하기 위한 고유 코드 (PK, not null, unique)
    @NotNull
    private String requestName; // 요청명: 생산 요청의 이름
    @NotNull
    private LocalDate requestDate; // 요청 일자
    @NotNull
    private String requesterId; // 요청자 ID: 생산 요청을 한 사람의 고유 ID (FK, 참조: User.id, not null) - 요청자명, 요청자부서
    @NotNull
    private BigDecimal requestQuantity; // 요청 수량
    @NotNull
    private String itemCode; // 품목 코드 (FK, 참조: ItemRegistration.id, not null)
    @NotNull
    private Status status; // 요청의 상태 (등록, 확정, 취소)
    private String remarks; // 비고

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String requestName;
        private LocalDate requestDate;
        private String requesterId;
        private BigDecimal requestQuantity;
        private String itemCode;
        private Status status;
        private String remarks;

        public Builder id(String id) {
            this.id = id;
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

        public Builder requesterId(String requesterId) {
            this.requesterId = requesterId;
            return this;
        }

        public Builder requestQuantity(BigDecimal requestQuantity) {
            this.requestQuantity = requestQuantity;
            return this;
        }

        public Builder itemCode(String itemCode) {
            this.itemCode = itemCode;
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

        public ProductionRequestManagement build() {
            return new ProductionRequestManagement(this);
        }
    }

    private ProductionRequestManagement(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.requestName = builder.requestName;
        this.requestDate = builder.requestDate;
        this.requesterId = builder.requesterId;
        this.requestQuantity = builder.requestQuantity;
        this.itemCode = builder.itemCode;
        this.status = builder.status;
        this.remarks = builder.remarks;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .requestName(this.requestName)
                .requestDate(this.requestDate)
                .requesterId(this.requesterId)
                .requestQuantity(this.requestQuantity)
                .itemCode(this.itemCode)
                .status(this.status)
                .remarks(this.remarks);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getRequestName() {
        return requestName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public BigDecimal getRequestQuantity() {
        return requestQuantity;
    }

    public String getItemCode() {
        return itemCode;
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
        return "ProductionRequestManagement{" +
                "id='" + id + '\'' +
                ", requestName='" + requestName + '\'' +
                ", requestDate=" + requestDate +
                ", requesterId='" + requesterId + '\'' +
                ", requestQuantity=" + requestQuantity +
                ", itemCode='" + itemCode + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
