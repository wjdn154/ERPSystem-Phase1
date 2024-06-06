package com.erp.system.financial.model.basicinformationmanagement.tax_invoices;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * 전자 세금 계산서 테이블
 * 전자 세금 계산서 발행 할때 필요한 정보들이 있는 테이블
 */
public class TaxInvoices {
    public enum TaxType { TAXABLE, EXEMPT, ZERO_RATED }
    public enum ReceiptType { RECEIPT, INVOICE }
    public enum IssueStatus { THIRD_PARTY, SELF_ISSUED }
    public enum NTSStatus { TRANSMITTED, PENDING }

    private final String id; // 세금 계산서의 고유 식별자
    private final String vendor_code; // 거래처 코드 참조
    private TaxType type; // 과세유형 (과세, 영세, 면세)
    private ReceiptType receiptType; // 영수증 타입 (영수, 청구)
    private IssueStatus issueStatus; // 발행 상태 (타사발행, 자체발행)
    private NTSStatus ntsTransmissionStatus; // 국세청 전송 상태 (전송 완료, 전송 대기)
    private Date issue_date; // 세금계산서의 작성 일자
    private Boolean attachment_included; //거래명세서 첨부 여부
    private String item_description; //거래 품목 설명
    private BigDecimal supply_value; //공급가액
    private BigDecimal tax_amount; //세금 금액
    private String approval_number; //승인번호 (국세청 승인 시 부여되는 번호)

    public TaxInvoices(String vendor_code) {
        this.id = UUID.randomUUID().toString();
        this.vendor_code = vendor_code;
    }

    public String getId() {
        return id;
    }

    public String getVendor_code() {
        return vendor_code;
    }

    public TaxType getType() {
        return type;
    }

    public void setType(TaxType type) {
        this.type = type;
    }

    public ReceiptType getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(ReceiptType receiptType) {
        this.receiptType = receiptType;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }

    public NTSStatus getNtsTransmissionStatus() {
        return ntsTransmissionStatus;
    }

    public void setNtsTransmissionStatus(NTSStatus ntsTransmissionStatus) {
        this.ntsTransmissionStatus = ntsTransmissionStatus;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Boolean getAttachment_included() {
        return attachment_included;
    }

    public void setAttachment_included(Boolean attachment_included) {
        this.attachment_included = attachment_included;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public BigDecimal getSupply_value() {
        return supply_value;
    }

    public void setSupply_value(BigDecimal supply_value) {
        this.supply_value = supply_value;
    }

    public BigDecimal getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(BigDecimal tax_amount) {
        this.tax_amount = tax_amount;
    }

    public String getApproval_number() {
        return approval_number;
    }

    public void setApproval_number(String approval_number) {
        this.approval_number = approval_number;
    }
}