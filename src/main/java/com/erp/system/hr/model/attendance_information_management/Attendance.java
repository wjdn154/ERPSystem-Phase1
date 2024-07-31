package com.erp.system.hr.model.attendance_information_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.sql.Time;
import java.time.LocalDate;


// 근태 기록 등록 테이블
@EnumMapping
public class Attendance {
    public enum Status{PRESENT, ABSENT, LEAVE, PUBLIC_HOLIDAY, EARLY_LEAVE,
        LATE, BUSINESS_TRIP, TRAINING, SABBATICAL, SICK_LEAVE, REMOTE_WORK
    , ON_DUTY, OVERTIME, SHIFT_WORK}

    @Unique
    @NotNull
    private final String id; // 근태 기록 식별자
    @NotNull
    private final String employeeId; // 직원  ID 참조

    @NotNull
    private LocalDate date; // 날짜
    @NotNull
    private Time checkTime; // 출근 시간
    @NotNull
    private Time checkoutTime; // 퇴근 시간
    @NotNull
    private Status status; // 상태 (예: 출근, 결근, 휴가, 공휴일, 조퇴, 지각, 출장, 교육, 휴직, 병가, 자택근무, 근무, 야근, 교대 근무)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String employeeId;
        private LocalDate date;
        private Time checkTime;
        private Time checkoutTime;
        private Status status;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder checkTime(Time checkTime) {
            this.checkTime = checkTime;
            return this;
        }

        public Builder checkoutTime(Time checkoutTime) {
            this.checkoutTime = checkoutTime;
            return this;
        }

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Attendance build() {return new Attendance(this);}

    }//end of Builder
    private Attendance(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.employeeId = builder.employeeId;
        this.date = builder.date;
        this.checkTime = builder.checkTime;
        this.checkoutTime = builder.checkoutTime;
        this.status = builder.status;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .employeeId(this.employeeId)
                .date(this.date)
                .checkTime(this.checkTime)
                .checkoutTime(this.checkoutTime)
                .status(this.status);
    }

    public String getId() {return id;}

    public String getEmployeeId() {return employeeId;}

    public LocalDate getDate() {return date;}

    public Time getCheckTime() {return checkTime;}

    public Time getCheckoutTime() {return checkoutTime;}

    public Status getStatus() {return status;}

    @Override
    public String toString() {
        return "Attendance{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", date=" + date +
                ", checkTime=" + checkTime +
                ", checkoutTime=" + checkoutTime +
                ", status='" + status + '\'' +
                '}';
    }
}
