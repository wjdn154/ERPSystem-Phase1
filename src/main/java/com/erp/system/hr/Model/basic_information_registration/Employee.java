package com.erp.system.hr.Model.basic_information_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import org.apache.poi.hpsf.Decimal;

import java.time.LocalDate;
import java.util.Date;

// 직원 테이블

public class Employee {
    @NotNull
    private final String id; // 직원의 고유 식별자
    @NotNull
    private final String departmentId; // 부서 ID 참조
    @NotNull
    private final String positionId; // 직위 ID 참조
    @NotNull
    private final String salaryId; // 급여 ID 참조
    @NotNull
    private final String allowanceId; // 수당 ID 참조

    @NotNull
    private String firstName; // 이름
    @NotNull
    private String lastName; // 성
    @NotNull
    private Date dataOfBirth; // 생년월일
    @NotNull
    private String gender; // 성별
    @NotNull
    private String phoneNumber; // 전화번호
    @NotNull
    private String email; // 이메일
    @NotNull
    private String address; // 주소
    @NotNull
    private String hireDate; // 입사날짜
    @NotNull
    private String employmentType; // 고용 형태

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String departmentId;
        private String positionId;
        private String salaryId;
        private String allowanceId;

        private String firstName;
        private String lastName;
        private Date dataOfBirth;
        private String gender;
        private String phoneNumber;
        private String email;
        private String address;
        private String hireDate;
        private String employmentType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder departmentId(String id) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder positionId(String positionId) {
            this.positionId = positionId;
            return this;
        }

        public Builder salaryId(String salaryID) {
            this.salaryId = salaryId;
            return this;
        }

        public Builder allowanceId(String allowanceId) {
            this.allowanceId = allowanceId;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder dataOfBirth(Date dataOfBirth) {
            this.dataOfBirth = dataOfBirth;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder hireDate(String hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Builder employmentType(String employmentType) {
            this.employmentType = employmentType;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }// end of Builder

        private Employee(Builder builder) {
            this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
            this.departmentId = builder.departmentId;
            this.positionId = builder.positionId;
            this.salaryId = builder.salaryId;
            this.allowanceId = builder.allowanceId;
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.dataOfBirth = builder.dataOfBirth;
            this.gender = builder.gender;
            this.phoneNumber = builder.phoneNumber;
            this.email = builder.email;
            this.address = builder.address;
            this.hireDate = builder.hireDate;
            this.employmentType = builder.employmentType;
            NotNullValidator.safeValidateFields(this);
        }

        public Builder tobuild() {
            return new Builder()
                    .id(this.id)
                    .departmentId(this.departmentId)
                    .positionId(this.positionId)
                    .salaryId(this.salaryId)
                    .allowanceId(this.allowanceId)
                    .firstName(this.firstName)
                    .lastName(this.lastName)
                    .dataOfBirth(this.dataOfBirth)
                    .gender(this.gender)
                    .phoneNumber(this.phoneNumber)
                    .email(this.email)
                    .address(this.address)
                    .hireDate(this.hireDate)
                    .employmentType(this.employmentType);
        }

        public String getId() {return id;}

        public String getPositionId() {return positionId;}

        public String getDepartmentId() {return departmentId;}

        public String getSalaryId() {return salaryId;}

        public String getAllowanceId() {return allowanceId;}

        public String getFirstName() {return firstName;}

        public String getLastName() {return lastName;}

        public Date getDataOfBirth() {return dataOfBirth;}

        public String getGender() {return gender;}

        public String getPhoneNumber() {return phoneNumber;}

        public String getEmail() {return email;}

        public String getAddress() {return address;}

        public String getHireDate() {return hireDate;}

        public String getEmploymentType() {return employmentType;}
}

