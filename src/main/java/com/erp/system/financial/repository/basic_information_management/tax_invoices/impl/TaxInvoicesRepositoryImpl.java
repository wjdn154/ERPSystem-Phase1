package com.erp.system.financial.repository.basic_information_management.tax_invoices.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoice;
import com.erp.system.financial.repository.basic_information_management.tax_invoices.TaxInvoiceRepository;

@Component
public class TaxInvoicesRepositoryImpl extends GenericRepositoryImpl<TaxInvoice> implements TaxInvoiceRepository {
    private TaxInvoicesRepositoryImpl() {
        super(TaxInvoice.class); // 부모 클래스의 생성자를 호출
    }
}