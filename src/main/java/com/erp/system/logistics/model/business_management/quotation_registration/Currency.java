package com.erp.system.logistics.model.business_management.quotation_registration;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.validator.NotNullValidator;

/**
 * 외화 테이블
 * 외화에 대한 정보가 있는 테이블
 */
public class Currency {
    @NotNull
    private final String id; // 외화코드 (Primary Key)

    @NotNull
    private String name; // 외화명
    @NotNull
    private double exchangeRate; // 환율

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;
        private double exchangeRate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder exchangeRate(double exchangeRate) {
            this.exchangeRate = exchangeRate;
            return this;
        }

        public Currency build() {
            return new Currency(this);
        }
    }

    private Currency(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.exchangeRate = builder.exchangeRate;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .exchangeRate(this.exchangeRate);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
