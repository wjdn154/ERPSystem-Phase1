package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoice;

import java.util.Collection;
import java.util.Optional;

public interface TaxInvoiceService {
    void saveTaxInvoice(TaxInvoice taxInvoice);

    Optional<TaxInvoice> findTaxInvoiceById(String id);
    Optional<TaxInvoice> findTaxInvoiceByCode(String code);

    Collection<TaxInvoice> findAllTaxInvoices();
}