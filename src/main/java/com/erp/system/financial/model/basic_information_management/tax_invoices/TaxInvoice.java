package com.erp.system.financial.model.basic_information_management.tax_invoices;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

/**
 * 전자 세금 계산서 테이블
 * 전자 세금 계산서 발행 할때 필요한 정보들이 있는 테이블
 */
public class TaxInvoice {
    public enum TaxType { TAXABLE, EXEMPT, ZERO_RATED }
    public enum ReceiptType { RECEIPT, INVOICE }
    public enum IssueStatus { THIRD_PARTY, SELF_ISSUED }
    public enum NTSStatus { TRANSMITTED, PENDING }

    private final String id; // 세금 계산서의 고유 식별자
    private final String code; // 세금 계산서 코드
    private final String vendorCode; // 거래처 코드 참조

    private TaxType type; // 과세유형 (과세, 영세, 면세)
    private ReceiptType receiptType; // 영수증 타입 (영수, 청구)
    private IssueStatus issueStatus; // 발행 상태 (타사발행, 자체발행)
    private NTSStatus ntsTransmissionStatus; // 국세청 전송 상태 (전송 완료, 전송 대기)
    private LocalDate issueDate; // 세금계산서의 작성 일자
    private Boolean attachmentIncluded; // 거래명세서 첨부 여부
    private String itemDescription; // 거래 품목 설명
    private BigDecimal supplyValue; // 공급가액
    private BigDecimal taxAmount; // 세금 금액
    private String approvalNumber; // 승인번호 (국세청 승인 시 부여되는 번호)

    public static int idIndex = 1;
    
    public static class Builder {
        private String id;
        private String code;
        private String vendorCode;

        private TaxType type;
        private ReceiptType receiptType;
        private IssueStatus issueStatus;
        private NTSStatus ntsTransmissionStatus;
        private LocalDate issueDate;
        private Boolean attachmentIncluded;
        private String itemDescription;
        private BigDecimal supplyValue;
        private BigDecimal taxAmount;
        private String approvalNumber;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder vendorCode(String vendorCode) {
            this.vendorCode = vendorCode;
            return this;
        }

        public Builder type(TaxType type) {
            this.type = type;
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

        public Builder issueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder attachmentIncluded(Boolean attachmentIncluded) {
            this.attachmentIncluded = attachmentIncluded;
            return this;
        }

        public Builder itemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
            return this;
        }

        public Builder supplyValue(BigDecimal supplyValue) {
            this.supplyValue = supplyValue;
            return this;
        }

        public Builder taxAmount(BigDecimal taxAmount) {
            this.taxAmount = taxAmount;
            return this;
        }

        public Builder approvalNumber(String approvalNumber) {
            this.approvalNumber = approvalNumber;
            return this;
        }

        public TaxInvoice build() {
            return new TaxInvoice(this);
        }
    }// end of Builder

    private TaxInvoice(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.code = builder.code;
        this.vendorCode = builder.vendorCode;
        this.type = builder.type;
        this.receiptType = builder.receiptType;
        this.issueStatus = builder.issueStatus;
        this.ntsTransmissionStatus = builder.ntsTransmissionStatus;
        this.issueDate = builder.issueDate;
        this.attachmentIncluded = builder.attachmentIncluded;
        this.itemDescription = builder.itemDescription;
        this.supplyValue = builder.supplyValue;
        this.taxAmount = builder.taxAmount;
        this.approvalNumber = builder.approvalNumber;
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .code(this.code)
                .vendorCode(this.vendorCode)
                .type(this.type)
                .receiptType(this.receiptType)
                .issueStatus(this.issueStatus)
                .ntsTransmissionStatus(this.ntsTransmissionStatus)
                .issueDate(this.issueDate)
                .attachmentIncluded(this.attachmentIncluded)
                .itemDescription(this.itemDescription)
                .supplyValue(this.supplyValue)
                .taxAmount(this.taxAmount)
                .approvalNumber(this.approvalNumber);
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public TaxType getType() {
        return type;
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

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public Boolean getAttachmentIncluded() {
        return attachmentIncluded;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public BigDecimal getSupplyValue() {
        return supplyValue;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public String getApprovalNumber() {
        return approvalNumber;
    }

    public static int getIdIndex() {
        return idIndex;
    }
}