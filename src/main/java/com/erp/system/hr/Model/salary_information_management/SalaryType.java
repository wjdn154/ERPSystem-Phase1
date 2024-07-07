package com.erp.system.hr.Model.salary_information_management;

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalaryType {
    @Unique
    @NotNull
    private final String id; // 급여 유형 고유 식별자

    @NotNull
    private String typeName; // 급여 유형 이름
    @NotNull
    private String description; // 급여 유형 설명

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String typeName;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder typeName(String typeName) {
            this.typeName = typeName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }
    }//end of Builder
    private SalaryType(Builder builder){
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.typeName = builder.typeName;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild(){
        return new Builder()
                .id(this.id)
                .typeName(this.typeName)
                .description(this.description);
    }

    public String getId() {return id;}

    public String getTypeName() {return typeName;}

    public String getDescription() {return description;}



}
