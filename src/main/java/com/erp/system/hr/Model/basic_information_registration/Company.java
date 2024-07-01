package com.erp.system.hr.Model.basic_information_registration;

import com.erp.system.common.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

// 회사 테이블
public class Company {
    @NotNull
    private final String id; // 회사 식별자

    @NotNull
    private String companyName; // 회사 이름
    @NotNull
    private String businessRegistrationNumber; // 사업자 등록 번호
    @NotNull
    private String address; // 회사 주소
    @NotNull
    private String contactNumber; // 회사 연락처

    public static int idIndex = 1;

    public static class Builder{
        private String id;

        private String companyName;
        private String businessRegistrationNumber;
        private String address;
        private String contactNumber;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder companyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder businessRegistrationNumber(String businessRegistrationNumber) {
            this.businessRegistrationNumber = businessRegistrationNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder contactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }
    }//end of Builder
    private Company(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.companyName = builder.companyName;
        this.businessRegistrationNumber = builder.businessRegistrationNumber;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
        NotNullValidator.safeValidateFields(this);
    }
    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .companyName(this.companyName)
                .businessRegistrationNumber(this.businessRegistrationNumber)
                .address(this.address)
                .contactNumber(this.contactNumber);
    }

    public String getId() {return id;}

    public String getCompanyName() {return companyName;}

    public String getBusinessRegistrationNumber() {return businessRegistrationNumber;}

    public String getAddress() {return address;}

    public String getContactNumber() {return contactNumber;}
}
