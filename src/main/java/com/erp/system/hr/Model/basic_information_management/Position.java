package com.erp.system.hr.Model.basic_information_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

// 직위 테이블

public class Position {
    @Unique
    @NotNull
    private final String id; //  직위 Id

    @NotNull
    private String positionName; // 직위 이름
    private String description; // 직위 설명 (예 : 부서 운영을 총괄하는 책임자 )

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String positionName;
        private String description;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder positionName(String positionName) {
            this.positionName = positionName;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
    }//end of Builder
    private Position(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.positionName = builder.positionName;
        this.description = builder.description;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .positionName(this.positionName)
                .description(this.description);
    }

    public String getId() {return id;}

    public String getPositionName() {return positionName;}

    public String getDescription() {return description;}

    @Override
    public String toString() {
        return "Position{" +
                "id='" + id + '\'' +
                ", positionName='" + positionName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
