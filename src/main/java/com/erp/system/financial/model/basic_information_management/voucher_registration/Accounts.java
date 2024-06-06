package com.erp.system.financial.model.basic_information_management.voucher_registration;

import java.util.UUID;

/**
 * 계정과목 테이블
 * 계정과목 데이터 테이블
 */
public class Accounts {
    private final String id; // 계정 과목의 고유 식별자
    private final String code; // 계정과목 코드
    private final String parent_account_id; // 상위 계정과목 ID
    private String name; // 계정과목명
    private String reference; // 참고 사항

    public Accounts(String parent_account_id, String code) {
        this.id = UUID.randomUUID().toString();
        this.parent_account_id = parent_account_id;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getParent_account_id() {
        return parent_account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
