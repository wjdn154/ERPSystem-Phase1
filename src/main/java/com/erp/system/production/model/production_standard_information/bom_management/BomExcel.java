package com.erp.system.production.model.production_standard_information.bom_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.validator.UniqueValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.math.BigDecimal;
import java.time.LocalDate;

/*
 * BOM 엑셀 등록 정보 관리 테이블
 */

public class BomExcel {
    @NotNull
    @Unique
    private final String id; // PK
    @NotNull
    private String name;
    @NotNull
    private BigDecimal netQuantity; // 정미 수량
    @NotNull
    private LocalDate startDate; // 시작 일자
    @NotNull
    private LocalDate endDate; // 종료 일자

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String name;
        private BigDecimal netQuantity;
        private LocalDate startDate;
        private LocalDate endDate;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder netQuantity(BigDecimal netQuantity) {
            this.netQuantity = netQuantity;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public BomExcel build() {
            return new BomExcel(this);
        }
    } // end of Builder

    private BomExcel(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        this.netQuantity = builder.netQuantity;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        NotNullValidator.validateFields(this);
        UniqueValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name)
                .netQuantity(this.netQuantity)
                .startDate(this.startDate)
                .endDate(this.endDate);
    }

    // getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getNetQuantity() {
        return netQuantity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "BomExcel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", netQuantity=" + netQuantity +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
