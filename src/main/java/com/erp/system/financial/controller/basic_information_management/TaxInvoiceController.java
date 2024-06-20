package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoice;
import com.erp.system.financial.repository.basic_information_management.tax_invoices.TaxInvoiceRepository;
import com.erp.system.financial.service.basic_information_management.TaxInvoiceService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class TaxInvoiceController {
    private final TaxInvoiceService taxInvoiceService;
    private final TaxInvoiceRepository taxInvoiceRepository;

    public TaxInvoiceController(TaxInvoiceService taxInvoiceService,
                                TaxInvoiceRepository taxInvoiceRepository) {
        this.taxInvoiceService = taxInvoiceService;
        this.taxInvoiceRepository = taxInvoiceRepository;
    }

    /**
     * 세금 계산서를 저장함
     * @param taxInvoice 저장할 세금 계산서
     */
    public void saveTaxInvoice(TaxInvoice taxInvoice) {
        taxInvoiceRepository.save(taxInvoice);
    }

    /**
     * ID로 세금 계산서를 조회함
     * @param id 세금 계산서의 ID
     * @return 조회된 세금 계산서를 Optional로 반환
     */
    public Optional<TaxInvoice> findTaxInvoiceById(String id) {
        return taxInvoiceRepository.findById(id);
    }

    /**
     * 모든 세금 계산서를 조회함
     * @return 저장된 모든 세금 계산서의 컬렉션
     */
    public Collection<TaxInvoice> findAllTaxInvoices() {
        return taxInvoiceRepository.findAll();
    }
}