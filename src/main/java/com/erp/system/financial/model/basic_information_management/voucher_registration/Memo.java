package com.erp.system.financial.model.basic_information_management.voucher_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.util.UUID;

/**
 * 적요 테이블
 * 적요 데이터 정보 저장 테이블
 */
public class Memo {
    @NotNull
    private final String id; // 적요의 고유 식별자
    @NotNull
    private final String accountId; // 계정과목 참조 코드

    @NotNull
    private String description; // 적요 설명(계정과목에 따라 달라진다)
    @NotNull
    private boolean immutable; // 수정불가 여부

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String accountId;

        private String description;
        private boolean immutable;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder immutable(boolean immutable) {
            this.immutable = immutable;
            return this;
        }

        public Memo build() {
            return new Memo(this);
        }
    } // end of Builder

    private Memo(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.accountId = builder.accountId;
        this.description = builder.description;
        this.immutable = builder.immutable;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .accountId(this.accountId)
                .description(this.description)
                .immutable(this.immutable);
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isImmutable() {
        return immutable;
    }
}