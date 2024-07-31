package com.erp.system.hr.model.salary_information_management;

import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;
import com.erp.system.common.annotation.Unique;
import com.erp.system.common.validator.NotNullValidator;

// 수당 상태 테이블
@EnumMapping
public class AllowanceStatus {
    private enum ApprovalStatus{PENDING, APPROVED, REJECTED, PAID, CANCELLED, IN_PROGESS, UNDER_REVIEW, DEFERRED, NEEDS_REVISION, NEEDS_CONFIRMATION}
    @Unique
    @NotNull
    private final String id; // 수당 상태 고유 식별자
    @NotNull
    private final String allowanceId; // 수당 등록 ID 참조

    private ApprovalStatus approvalStatus; // 수당 상태{ 대기, 승인, 거절, 보류, 지급완료, 취소, 처리 중, 검토 중, 연기됨, 수정 필요, 확인 필요)

    public static int idIndex = 1;


    public static  class Builder {
        private String id;
        private String allowanceId;
        private ApprovalStatus approvalStatus;


        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder allowanceId(String allowanceId) {
            this.allowanceId = allowanceId;
            return this;
        }

        public Builder approvalStatus(ApprovalStatus approvalStatus) {
            this.approvalStatus = approvalStatus;
            return this;
        }

        public AllowanceStatus build() {
            return new AllowanceStatus(this);
        }
    } //end of Builder

    public AllowanceStatus(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.allowanceId = builder.allowanceId;
        this.approvalStatus = builder.approvalStatus;
        NotNullValidator.validateFields(this);
    }
    public Builder tobuild(){
        return new Builder()
                .id(this.id)
                .allowanceId(this.allowanceId)
                .approvalStatus(this.approvalStatus);
    }

    public String getId() {return id;}

    public String getAllowanceId() {return allowanceId;}

    public ApprovalStatus getApprovalStatus() {return approvalStatus;}

    @Override
    public String toString() {
        return "AllowanceStatus{" +
                ", id='" + id + '\'' +
                "allowanceId='" + allowanceId + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
