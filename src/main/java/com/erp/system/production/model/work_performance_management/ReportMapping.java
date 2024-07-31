package com.erp.system.production.model.work_performance_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.production.model.production_standard_information.bom_management.BomMaterial;

import java.math.BigDecimal;

/**
 * 다수의 데일리리포트 먼슬리리포트 연결한다고 만들긴 했는데
 * TODO 생각해보니 계획을 일간/월간으로 찢어서 그걸 참조하면 되는 건가 싶기도 하고,
 * TODO 근데 계획 여부 상관없이 기록하는용으로도 써야 하니까? 이대로 하면 될 것 같기도 하고?
 */

public class ReportMapping {

    @NotNull
    @Unique
    private final String id; // PK
    private final String dailyReportId; // FK
    private final String monthlyReportId; // FK

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String dailyReportId;
        private String monthlyReportId;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder dailyReportId(String dailyReportId) {
            this.dailyReportId = dailyReportId;
            return this;
        }

        public Builder monthlyReportId(String monthlyReportId) {
            this.monthlyReportId = monthlyReportId;
            return this;
        }

        public ReportMapping build() {
            return new ReportMapping(this);
        }
    }

    private ReportMapping(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.dailyReportId = builder.dailyReportId;
        this.monthlyReportId = builder.monthlyReportId;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getDailyReportId() {
        return dailyReportId;
    }

    public String getMonthlyReportId() {
        return monthlyReportId;
    }

    public static int getIdIndex() {
        return idIndex;
    }

    @Override
    public String toString() {
        return "ReportMapping{" +
                "id='" + id + '\'' +
                ", dailyReportId='" + dailyReportId + '\'' +
                ", monthlyReportId='" + monthlyReportId + '\'' +
                '}';
    }
}
