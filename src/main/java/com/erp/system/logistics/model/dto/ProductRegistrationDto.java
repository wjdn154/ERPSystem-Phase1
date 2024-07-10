package com.erp.system.logistics.model.dto;

import com.erp.system.logistics.model.basic_information_registration.product_registration.Product;

/**
 * 품목 등록을 위한 DTO
 */
public class ProductRegistrationDto {
    private String id; // 품목의 고유 식별자
    private String name; // 품목명
    private String productionProcessId; // 생성공정 코드 참조
    private String groupId; // 품목 그룹 코드 참조
    private double purchasePrice; // 입고 단가
    private double salesPrice; // 출고 단가
    private String standard; // 규격
    private String unit; // 단위
    private String productType; // 품목 구분

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionProcessId() {
        return productionProcessId;
    }

    public void setProductionProcessId(String productionProcessId) {
        this.productionProcessId = productionProcessId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
