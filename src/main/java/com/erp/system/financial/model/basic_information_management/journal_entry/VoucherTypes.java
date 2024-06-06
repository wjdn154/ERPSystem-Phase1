package com.erp.system.financial.model.basic_information_management.journal_entry;

import java.util.UUID;

/**
 * 전표 타입 테이블
 * 전표 타입 데이터를 저장하는 테이블
 */
public class VoucherTypes {
    private final String id; // 전표 타입의 고유 식별자
    private final String code; // 전표 타입 코드
    private String name; // 전표의 종류 (ex 출금,입금,차변,대변)

    public VoucherTypes(String code) {
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
