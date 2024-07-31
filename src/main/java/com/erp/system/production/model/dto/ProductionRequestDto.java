package com.erp.system.production.model.dto;

import com.erp.system.production.model.work_order_management.ProductionRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductionRequestDto {
    private String requesterId;
    private String productId;
    private String requestName;
    private LocalDate requestDate;
    private BigDecimal requestQuantity;
    private ProductionRequest.Status status;
    private ProductionRequest.RequestProductionType requestProductionType;
    private String remarks;

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public BigDecimal getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(BigDecimal requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public ProductionRequest.Status getStatus() {
        return status;
    }

    public void setStatus(ProductionRequest.Status status) {
        this.status = status;
    }

    public ProductionRequest.RequestProductionType getRequestProductionType() {
        return requestProductionType;
    }

    public void setRequestProductionType(ProductionRequest.RequestProductionType requestProductionType) {
        this.requestProductionType = requestProductionType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
