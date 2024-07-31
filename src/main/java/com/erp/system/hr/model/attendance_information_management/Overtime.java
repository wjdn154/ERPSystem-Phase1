package com.erp.system.hr.model.attendance_information_management;


// 초과 근무 정보 테이블

import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.sql.Time;
import java.time.LocalDate;

public class Overtime {
    @Unique
    @NotNull
    private final String id; // 초과 근무 정보 식별자
    @NotNull
    private final String employeeId; // 직원 ID 참조
    @NotNull
    private final String managerId; // 부서 관리자 ID 참조 // ->  승인을 직원이 하면 이거 필요없음.

    @NotNull
    private LocalDate date; // 초과 근무 날짜
    @NotNull
    private Time hours; // 초과 근무 시간
    @NotNull
    private Time startTime; // 초과 근무 시작 시간
    @NotNull
    private Time endTime; // 초과 근무 종료 시간
    @NotNull
    private String reason; // 초과 근무 사유

    public static int idIndex = 1;

    public static  class Builder {
        private String id;
        private String employeeId;
        private String managerId;
        private LocalDate date;
        private Time hours;
        private Time startTime;
        private Time endTime;
        private String reason;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public Builder managerId(String managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder hours(Time hours) {
            this.hours = hours;
            return this;
        }
        public Builder startTime(Time startTime) {
            this.startTime = startTime;
            return this;
        }
        public Builder endTime(Time endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Overtime build() {return new Overtime(this);}

    }// end of Builder

    public Overtime(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.employeeId = builder.employeeId;
        this.managerId = builder.managerId;
        this.date = builder.date;
        this.hours = builder.hours;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.reason = builder.reason;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .employeeId(this.employeeId)
                .managerId(this.managerId)
                .date(this.date)
                .hours(this.hours)
                .startTime(this.startTime)
                .endTime(this.endTime)
                .reason(this.reason);
    }

    public String getId() {return id;}

    public String getEmployeeId() {return employeeId;}

    public String getManagerId() {return managerId;}

    public LocalDate getDate() {return date;}

    public Time getHours() {return hours;}

    public Time getStartTime() {return startTime;}

    public Time getEndTime() {return endTime;}

    public String getReason() {return reason;}

    @Override
    public String toString() {
        return "Overtime{" +
                "id='" + id + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", managerId='" + managerId + '\'' +
                ", date=" + date +
                ", hours=" + hours +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", reason='" + reason + '\'' +
                '}';
    }
}

