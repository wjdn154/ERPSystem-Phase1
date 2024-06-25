package com.erp.system.financial.model.basic_information_management.purchase_sales_slip;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

import java.util.UUID;

/**
 * 분개 테이블
 * 매입매출전표 등록 할때 선택할 분개 정보 테이블
 */
public class Entry {
    @NotNull
    private final String id; // 고유 식별자

    @NotNull
    private String name; // 분개 이름

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Entry build() {
            return new Entry(this);
        }
    }// end of Builder

    private Entry(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}