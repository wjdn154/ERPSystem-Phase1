package com.erp.system.financial.model.basicinformationmanagement.companyregistration;

import java.util.UUID;

public class corporate_types {
    private final String id; // 고유 식별자
    private final String code; // 법인구분 코드
    private String type; // 법인구분
    private String description; // 법인구분 설명

    public corporate_types(String code) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}




