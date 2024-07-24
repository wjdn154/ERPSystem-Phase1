package com.erp.system.hr.Model.salary_information_management;


import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

import java.math.BigDecimal;

// 복리후생 종류 테이블
public class BenefitType {
    @Unique
    @NotNull
    private final String id; // 복리후생 종류 고유 식별자
    @NotNull
    private String name; // 복리후생 종류 이름( 예 : 휴가비, 경조사비 등)

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
    }//end of Builder
    private BenefitType(Builder builder){
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.name = builder.name;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .name(this.name);
    }

    public String getId() {return id;}

    public String getName() {return name;}

    @Override
    public String toString() {
        return "BenefitType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
