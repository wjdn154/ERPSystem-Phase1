package com.erp.system.financial.model.basic_information_management.company_registration;

import java.util.UUID;

/**
 * 법인구분 테이블
 * 법인구분 데이터 테이블
 */
public class CorporateTypes {
    private final String id; // 고유 식별자
    private final String code; // 법인구분 코드
    private String type; // 법인구분
    private String description; // 법인구분 설명

    public CorporateTypes(String code) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
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

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




