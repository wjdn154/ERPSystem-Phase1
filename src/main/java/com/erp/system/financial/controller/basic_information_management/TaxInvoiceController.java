package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoice;
import com.erp.system.financial.service.basic_information_management.TaxInvoiceService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class TaxInvoiceController {
    private final TaxInvoiceService taxInvoiceService;

    public TaxInvoiceController(TaxInvoiceService taxInvoiceService) {
        this.taxInvoiceService = taxInvoiceService;
    }

    /**
     * 세금 계산서를 저장함
     * @param taxInvoice 저장할 세금 계산서
     */
    public void saveTaxInvoice(TaxInvoice taxInvoice) {
        taxInvoiceService.saveTaxInvoice(taxInvoice);
    }

    /**
     * ID로 세금 계산서를 조회함
     * @param id 세금 계산서의 ID
     * @return 조회된 세금 계산서를 Optional로 반환
     */
    public Optional<TaxInvoice> findTaxInvoiceById(String id) {
        return taxInvoiceService.findTaxInvoiceById(id);
    }

    /**
     * 코드로 세금 계산서를 조회함
     * @param code 세금 계산서의 코드
     * @return 조회된 세금 계산서를 Optional로 반환
     */
    public Optional<TaxInvoice> findTaxInvoiceByCode(String code) {
        return taxInvoiceService.findTaxInvoiceByCode(code);
    }

    /**
     * 모든 세금 계산서를 조회함
     * @return 저장된 모든 세금 계산서의 컬렉션
     */
    public Collection<TaxInvoice> findAllTaxInvoices() {
        return taxInvoiceService.findAllTaxInvoices();
    }
}