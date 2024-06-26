package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoice;
import com.erp.system.financial.repository.basic_information_management.tax_invoices.TaxInvoiceRepository;
import com.erp.system.financial.service.basic_information_management.TaxInvoiceService;

import java.util.Collection;
import java.util.Optional;

@Component
public class TaxInvoiceServiceImpl implements TaxInvoiceService {
    private final TaxInvoiceRepository taxInvoiceRepository;

    public TaxInvoiceServiceImpl(TaxInvoiceRepository taxInvoiceRepository) {
        this.taxInvoiceRepository = taxInvoiceRepository;
    }

}