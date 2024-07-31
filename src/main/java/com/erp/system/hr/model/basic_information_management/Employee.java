package com.erp.system.hr.model.basic_information_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;

import java.time.LocalDate;
import java.util.Date;

// 직원 테이블
@EnumMapping
public class Employee {
    public enum EmploymentType{FULLTIME, CONTRACT, PARTTIME, TEMPORARY, INTERN}
    @Unique
    @NotNull
    private final String id; // 직원의 고유 식별자+
    @NotNull
    private final String departmentId; // 부서 ID 참조
    @NotNull
    private final String positionId; // 직위 ID 참조
    @NotNull
    private final String salaryId; // 급여 ID 참조
    @NotNull
    private final String allowanceId; // 수당 ID 참조
    @NotNull
    private final String benefitId; // 복리후생 ID 참조
    @NotNull
    private final String deductionId; // 공제 ID 참조
    @NotNull
    private final String payrollStatementId; // 급여 명세서 ID 참조
    @NotNull
    private final String insuranceId; // 보험 ID 참조

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
    @Unique
    private String email; // 이메일
    @NotNull
    private String address; // 주소
    @NotNull
    private LocalDate hireDate; // 입사날짜
    @NotNull
    private EmploymentType employmentType; // 고용 형태 ( 예 : 정규직, 계약직, 파트타임, 임시직, 인턴 )

    public static int idIndex = 1;

    public static class Builder {
        private String id;
        private String departmentId;
        private String positionId;
        private String salaryId;
        private String allowanceId;
        private String benefitId;
        private String deductionId;
        private String payrollStatementId;
        private String insuranceId;

        private String firstName;
        private String lastName;
        private Date dataOfBirth;
        private String gender;
        private String phoneNumber;
        private String email;
        private String address;
        private LocalDate hireDate;
        private EmploymentType employmentType;

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

        public Builder benefitId(String benefitId) {
            this.benefitId = benefitId;
            return this;
        }

        public Builder deductionId(String deductionId) {
            this.deductionId = deductionId;
            return this;
        }

        public Builder payrollStatementId(String payrollStatementId) {
            this.payrollStatementId = payrollStatementId;
            return this;
        }

        public Builder insuranceId(String insuranceId) {
            this.insuranceId = insuranceId;
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

        public Builder hireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
            return this;
        }

        public Builder employmentType(EmploymentType employmentType) {
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
            this.benefitId = builder.benefitId;
            this.deductionId = builder.deductionId;
            this.payrollStatementId = builder.payrollStatementId;
            this.insuranceId = builder.insuranceId;

            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.dataOfBirth = builder.dataOfBirth;
            this.gender = builder.gender;
            this.phoneNumber = builder.phoneNumber;
            this.email = builder.email;
            this.address = builder.address;
            this.hireDate = builder.hireDate;
            this.employmentType = builder.employmentType;
            NotNullValidator.validateFields(this);
        }

        public Builder tobuild() {
            return new Builder()
                    .id(this.id)
                    .departmentId(this.departmentId)
                    .positionId(this.positionId)
                    .salaryId(this.salaryId)
                    .allowanceId(this.allowanceId)
                    .benefitId(this.benefitId)
                    .deductionId(this.deductionId)
                    .payrollStatementId(this.payrollStatementId)
                    .insuranceId(this.insuranceId)

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

        public String getBenefitId() {return benefitId;}

        public String getDeductionId() {return deductionId;}

        public String getPayrollStatementId() {return payrollStatementId;}

        public String getInsuranceId() {return insuranceId;}

        public String getFirstName() {return firstName;}

        public String getLastName() {return lastName;}

        public Date getDataOfBirth() {return dataOfBirth;}

        public String getGender() {return gender;}

        public String getPhoneNumber() {return phoneNumber;}

        public String getEmail() {return email;}

        public String getAddress() {return address;}

        public LocalDate getHireDate() {return hireDate;}

        public EmploymentType getEmploymentType() {return employmentType;}

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", positionId='" + positionId + '\'' +
                ", salaryId='" + salaryId + '\'' +
                ", allowanceId='" + allowanceId + '\'' +
                ", benefitId='" + benefitId + '\'' +
                ", deductionId='" + deductionId + '\'' +
                ", payrollStatementId='" + payrollStatementId + '\'' +
                ", insuranceId='" + insuranceId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dataOfBirth=" + dataOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", hireDate=" + hireDate +
                ", employmentType=" + employmentType +
                '}';
    }
}

