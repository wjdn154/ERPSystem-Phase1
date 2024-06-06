package com.erp.system.financial.model.basic_information_management.voucher_registration;

import java.util.UUID;

/**
 * 적요 테이블
 * 적요 데이터 정보 저장 테이블
 */
public class Memos {
    private final String id; // 적요의 고유 식별자
    private final String code; // 적요의 고유 코드
    private final String account_code; // 계정과목 참조 코드
    private String description; // 적요 설명(계정과목에 따라 달라진다)
    private boolean immutable; // 수정불가 여부

    public Memos(String account_code, String code) {
        this.id = UUID.randomUUID().toString();
        this.account_code = account_code;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getAccount_code() {
        return account_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isImmutable() {
        return immutable;
    }

    public void setImmutable(boolean immutable) {
        this.immutable = immutable;
    }
}
