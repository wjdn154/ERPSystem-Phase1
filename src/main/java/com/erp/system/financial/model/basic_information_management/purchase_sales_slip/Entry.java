package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import java.util.UUID;

/**
 * 분개 테이블
 * 매입매출전표 등록 할때 선택할 분개 정보 테이블
 */
public class Entry {
    private final String id; // 고유 식별자
    private final String code; // 분개 코드
    private String name; // 분개 이름

    public Entry(String code) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}