package com.erp.system.hr.Model.attendance_information_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.util.Date;

// 휴가 기록 테이블

public class Leave {
    @Unique
    @NotNull
    private final String id; // 휴가 기록 고유 식별자
    @NotNull
    private  final  String employeeId; // 직원 ID 참조

    @NotNull
    private String leaveType; // 휴가 유형( 예 : 병가, 연차, 유급 휴가, 무급 휴가 등)
    @NotNull
    private Date startDate; // 시작일
    @NotNull
    private Date endDate; // 종료일
    @NotNull
    private String reason; // 사유
    @NotNull
    private String status; // 상태 (예 : 대기, 승인, 거절)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String employeeId;
        private String leaveType;
        private Date startDate;
        private Date endDate;
        private String reason;
        private String status;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder leaveType(String leaveType) {
            this.leaveType = leaveType;
            return this;
        }

        public Builder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }
        public Leave build() {return new Leave(this);}
    }// end of Builder

    private Leave(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.employeeId = builder.employeeId;
        this.leaveType = builder.leaveType;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.reason = builder.reason;
        this.status = builder.status;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .employeeId(this.employeeId)
                .leaveType(this.leaveType)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .reason(this.reason)
                .status(this.status);
    }

    public String getId() {return id;}

    public String getLeaveType() {return leaveType;}

    public Date getStartDate() {return startDate;}

    public Date getEndDate() {return endDate;}

    public String getReason() {return reason;}

    public String getStatus() {return status;}

    @Override
    public String toString() {
        return "Leave{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", leaveType='" + leaveType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", reason='" + reason + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
