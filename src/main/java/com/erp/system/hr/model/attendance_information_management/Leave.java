package com.erp.system.hr.model.attendance_information_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.time.LocalDate;

// 휴가 등록 테이블
@EnumMapping
public class Leave {
    private enum LeaveType{SICK_LEAVE, ANNUAL_LEAVE, PAID_LEAVE, UNPAID_LEAVE, MATERNITY_LEAVE, PARENTAL_LEAVE
                            , SPECIAL_LEAVE, PUBLIC_HOLIDAY_LEAVE, TRAINING_LEAVE}
    private enum Status{PENDING, APPROVED, REJECTED, ON_HOLD, COMPLETED, CANCELLED, IN_PROGESS, UNDER_REVIEW, DEFERRED}
    @Unique
    @NotNull
    private final String id; // 휴가 등록 고유 식별자
    @NotNull
    private  final  String employeeId; // 직원 ID 참조

    @NotNull
    private LeaveType leaveType; // 휴가 유형( 예 : 병가, 연차, 유급 휴가, 무급 휴가 출산 휴가, 육아 휴가, 특별 휴가, 공휴일, 교육 휴가)
    @NotNull
    private LocalDate startDate; // 시작일
    @NotNull
    private LocalDate endDate; // 종료일
    @NotNull
    private String reason; // 사유
    @NotNull
    private Status status; // 상태 (예 : 대기, 승인, 거절, 보류, 완료, 취소, 처리 중, 검토 중, 연기됨)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String employeeId;
        private LeaveType leaveType;
        private LocalDate startDate;
        private LocalDate endDate;
        private String reason;
        private Status status;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder leaveType(LeaveType leaveType) {
            this.leaveType = leaveType;
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

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder status(Status status) {
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

    public LeaveType getLeaveType() {return leaveType;}

    public LocalDate getStartDate() {return startDate;}

    public LocalDate getEndDate() {return endDate;}

    public String getReason() {return reason;}

    public Status getStatus() {return status;}

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
