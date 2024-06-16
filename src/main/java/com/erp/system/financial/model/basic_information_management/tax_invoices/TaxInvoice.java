package com.erp.system.financial.model.basic_information_management.tax_invoices;

import com.erp.system.common.annotation.EnumMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 전자 세금 계산서 테이블
 * 전자 세금 계산서 발행 할때 필요한 정보들이 있는 테이블
 */
@EnumMapping
public class TaxInvoice {
    public enum TaxType { TAXABLE, EXEMPT, ZERO_RATED }
    public enum ReceiptType { RECEIPT, INVOICE }
    public enum IssueStatus { THIRD_PARTY, SELF_ISSUED }
    public enum NTSStatus { TRANSMITTED, PENDING }

    private final String id; // 세금 계산서의 고유 식별자
    private final String code; // 세금 계산서 코드
    private final String vendor_code; // 거래처 코드 참조

    private TaxType taxType; // 과세유형 (과세, 영세, 면세)
    private ReceiptType receiptType; // 영수증 타입 (영수, 청구)
    private IssueStatus issueStatus; // 발행 상태 (타사발행, 자체발행)
    private NTSStatus ntsTransmissionStatus; // 국세청 전송 상태 (전송 완료, 전송 대기)
    private Date issue_date; // 세금계산서의 작성 일자
    private Boolean attachment_included; //거래명세서 첨부 여부
    private String item_description; //거래 품목 설명
    private BigDecimal supply_value; //공급가액
    private BigDecimal tax_amount; //세금 금액
    private String approval_number; //승인번호 (국세청 승인 시 부여되는 번호)
    
    public static class Builder {
        private final String id;
        private final String code;
        private final String vendor_code;

        private TaxType taxType;
        private ReceiptType receiptType;
        private IssueStatus issueStatus;
        private NTSStatus ntsTransmissionStatus;
        private Date issue_date;
        private Boolean attachment_included;
        private String item_description;
        private BigDecimal supply_value;
        private BigDecimal tax_amount;
        private String approval_number;

        public Builder(String code, String vendor_code) {
            this.id = UUID.randomUUID().toString();
            this.code = code;
            this.vendor_code = vendor_code;
        }

        public Builder taxType(TaxType taxType) {
            this.taxType = taxType;
            return this;
        }

        public Builder receiptType(ReceiptType receiptType) {
            this.receiptType = receiptType;
            return this;
        }

        public Builder issueStatus(IssueStatus issueStatus) {
            this.issueStatus = issueStatus;
            return this;
        }

        public Builder ntsTransmissionStatus(NTSStatus ntsTransmissionStatus) {
            this.ntsTransmissionStatus = ntsTransmissionStatus;
            return this;
        }

        public Builder issue_date(Date issue_date) {
            this.issue_date = issue_date;
            return this;
        }

        public Builder attachment_included(Boolean attachment_included) {
            this.attachment_included = attachment_included;
            return this;
        }

        public Builder item_description(String item_description) {
            this.item_description = item_description;
            return this;
        }

        public Builder supply_value(BigDecimal supply_value) {
            this.supply_value = supply_value;
            return this;
        }

        public Builder tax_amount(BigDecimal tax_amount) {
            this.tax_amount = tax_amount;
            return this;
        }

        public Builder approval_number(String approval_number) {
            this.approval_number = approval_number;
            return this;
        }

        public TaxInvoice build() {
            return new TaxInvoice(this);
        }
    }// end of Builder

    private TaxInvoice(Builder builder) {
        this.id = builder.id;
        this.code = builder.code;
        this.vendor_code = builder.vendor_code;
        this.taxType = builder.taxType;
        this.receiptType = builder.receiptType;
        this.issueStatus = builder.issueStatus;
        this.ntsTransmissionStatus = builder.ntsTransmissionStatus;
        this.issue_date = builder.issue_date;
        this.attachment_included = builder.attachment_included;
        this.item_description = builder.item_description;
        this.supply_value = builder.supply_value;
        this.tax_amount = builder.tax_amount;
        this.approval_number = builder.approval_number;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getVendor_code() {
        return vendor_code;
    }


    public TaxType getTaxType() {
        return taxType;
    }

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public NTSStatus getNtsTransmissionStatus() {
        return ntsTransmissionStatus;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public Boolean getAttachment_included() {
        return attachment_included;
    }

    public String getItem_description() {
        return item_description;
    }

    public BigDecimal getSupply_value() {
        return supply_value;
    }

    public BigDecimal getTax_amount() {
        return tax_amount;
    }

    public String getApproval_number() {
        return approval_number;
    }
}