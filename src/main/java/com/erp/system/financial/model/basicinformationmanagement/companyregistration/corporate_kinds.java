package com.erp.system.financial.model.basicinformationmanagement.companyregistration;

import java.util.UUID;

public class corporate_kinds {
    private final String id; // 고유 실벽자
    private final String code; // 법인종류 코드
    private String kind; // 법인종류
    private String description; // 법인종류 설명

    public corporate_kinds(String code) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public String getKind() {
        return kind;
    }

    public String getDescription() {
        return description;
    }
}
