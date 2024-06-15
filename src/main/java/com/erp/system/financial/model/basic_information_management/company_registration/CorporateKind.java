package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 법인종류 테이블
 * 법인종류 데이터 테이블
 * 
 */
public class CorporateKind {
    private final String id; // 고유 실벽자
    private final String code; // 법인종류 코드
    private String kind; // 법인종류
    private String description; // 법인종류 설명

    public CorporateKind(String code) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
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

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
