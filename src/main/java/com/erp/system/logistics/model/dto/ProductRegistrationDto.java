package com.erp.system.logistics.model.dto;

import com.erp.system.logistics.model.basic_information_registration.product_registration.Product;

/**
 * 품목 등록을 위한 DTO
 */
public class ProductRegistrationDto {

    private String name; // 품목명
    private String productionProcessName; // 생성공정명
    private String groupName; // 품목 그룹명
    private double purchasePrice; // 입고 단가
    private double salesPrice; // 출고 단가
    private String standard; // 규격
    private String unit; // 단위
    private Product.ProductType productType; // 품목구분

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductionProcessName() {
        return productionProcessName;
    }

    public void setProductionProcessName(String productionProcessName) {
        this.productionProcessName = productionProcessName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public Product.ProductType getProductType() {
        return productType;
    }

    public void setProductType(Product.ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "ProductRegistrationDto{" +
                "name='" + name + '\'' +
                ", productionProcessName='" + productionProcessName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", salesPrice=" + salesPrice +
                ", standard='" + standard + '\'' +
                ", unit='" + unit + '\'' +
                ", productType=" + productType +
                '}';
    }
}
