package com.erp.system.financial.model.basic_information_management.voucher_registration;

import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 적요 테이블
 * 적요 데이터 정보 저장 테이블
 */
public class Memo {
    @Unique
    @NotNull
    private final String id; // 적요의 고유 식별자
    @NotNull
    private final String accountId; // 계정과목 참조 코드

    @NotNull
    private String description; // 적요 설명(계정과목에 따라 달라진다)
    @NotNull
    private Boolean immutable; // 수정불가 여부

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String accountId;

        private String description;
        private Boolean immutable;

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

        public Builder immutable(Boolean immutable) {
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

    @Override
    public String toString() {
        return "Memo{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", description='" + description + '\'' +
                ", immutable=" + immutable +
                '}';
    }
}