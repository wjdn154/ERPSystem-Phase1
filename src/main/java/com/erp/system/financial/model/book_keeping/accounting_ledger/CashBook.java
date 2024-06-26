package com.erp.system.financial.model.book_keeping.accounting_ledger;

import com.erp.system.common.validator.NotNullValidator;
import com.erp.system.common.annotation.EnumMapping;
import com.erp.system.common.annotation.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 현금출납장 테이블
 * 장부관리 탭 현급출납장 데이터 테이블
 */
@EnumMapping
public class CashBook {
    @NotNull
    private final String id; // 고유 식별자
    @NotNull
    private final String transactionId; // 거래코드 참조키
    @NotNull
    private final String memosId; // 적요 코드 참조키
    @NotNull
    private final String vendorId; // 거래처 코드 참조키

    @NotNull
    private BigDecimal debit; // 입금 금액
    @NotNull
    private BigDecimal credit; // 출금 금액
    @NotNull
    private BigDecimal balanceForward; // 이월 금액
    @NotNull
    private LocalDate date; // 거래 날짜

    public static int idIndex = 1; // static 변수 추가

    public static class Builder {
        private String id;
        private String transactionId;
        private String memosId;
        private String vendorId;

        private BigDecimal debit;
        private BigDecimal credit;
        private BigDecimal balanceForward;
        private LocalDate date;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder transactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder memosId(String memosId) {
            this.memosId = memosId;
            return this;
        }

        public Builder vendorId(String vendorId) {
            this.vendorId = vendorId;
            return this;
        }

        public Builder debit(BigDecimal debit) {
            this.debit = debit;
            return this;
        }

        public Builder credit(BigDecimal credit) {
            this.credit = credit;
            return this;
        }

        public Builder balanceForward(BigDecimal balanceForward) {
            this.balanceForward = balanceForward;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public CashBook build() {
            return new CashBook(this);
        }
    }

    private CashBook(Builder builder) {
        this.id = builder.id != null ? builder.id : Integer.toString(idIndex++);
        this.transactionId = builder.transactionId;
        this.memosId = builder.memosId;
        this.vendorId = builder.vendorId;
        this.debit = builder.debit;
        this.credit = builder.credit;
        this.balanceForward = builder.balanceForward;
        this.date = builder.date;
        NotNullValidator.validateFields(this);
    }

    public Builder tobuild() {
        return new Builder()
                .id(this.id)
                .transactionId(this.transactionId)
                .memosId(this.memosId)
                .vendorId(this.vendorId)
                .debit(this.debit)
                .credit(this.credit)
                .balanceForward(this.balanceForward)
                .date(this.date);
    }

    public String getId() {
        return id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMemosId() {
        return memosId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public BigDecimal getBalanceForward() {
        return balanceForward;
    }

    public LocalDate getDate() {
        return date;
    }
}
