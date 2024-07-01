package com.erp.system.hr.Model.basic_information_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

// 직위 테이블

public class Position {
    @NotNull
    private final String id; //  직위 Id

    @NotNull
    private String positionName; // 직위 이름

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String positionName;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder positionName(String positionName) {
            this.positionName = positionName;
            return this;
        }
    }//end of Builder
    private Position(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.positionName = builder.positionName;
        NotNullValidator.safeValidateFields(this);
    }
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .positionName(this.positionName);
    }

    public String getId() {return id;}

    public String getPositionName() {return positionName;}
}
