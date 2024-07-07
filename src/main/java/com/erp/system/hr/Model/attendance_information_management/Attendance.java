package com.erp.system.hr.Model.attendance_information_management;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.sql.Time;
import java.util.Date;


// 근태 기록 등록 테이블

public class Attendance {
    @Unique
    @NotNull
    private final String id; // 근태 기록 식별자
    @NotNull
    private final String employeeId; // 직원  ID 참조

    @NotNull
    private Date date; // 날짜
    @NotNull
    private Time checkTime; // 출근 시간
    @NotNull
    private Time checkoutTime; // 퇴근 시간
    @NotNull
    private String status; // 상태 (예: 출근, 결근, 휴가, 공휴일 등)

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String employeeId;
        private Date date;
        private Time checkTime;
        private Time checkoutTime;
        private String status;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder date(Date date) {
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

        public Builder status(String status) {
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

    public Date getDate() {return date;}

    public Time getCheckTime() {return checkTime;}

    public Time getCheckoutTime() {return checkoutTime;}

    public String getStatus() {return status;}
}
