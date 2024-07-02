package com.erp.system.financial.model.basic_information_management.company_registration;

import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.NotNull;

/**
 * 연락처 정보 테이블
 * 회사 등록 시 필요한 연락처 데이터 테이블
 *
 */
public class Contact {
    @Unique
    @NotNull
    private final String id; // 고유식별자

    @NotNull
    private String businessPhone; // 사업장 전화번호
    private String fax; // 팩스번호

    public static int idIndex = 1;

    public static class Builder {
        private String id;

        private String businessPhone;
        private String fax;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder businessPhone(String businessPhone) {
            this.businessPhone = businessPhone;
            return this;
        }

        public Builder fax(String fax) {
            this.fax = fax;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }// end of Builder

    private Contact(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.businessPhone = builder.businessPhone;
        this.fax = builder.fax;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .businessPhone(this.businessPhone)
                .fax(this.fax);
    }

    public String getId() {
        return id;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public String getFax() {
        return fax;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", businessPhone='" + businessPhone + '\'' +
                ", fax='" + fax + '\'' +
                '}';
    }
}