package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoice;
import com.erp.system.financial.repository.basic_information_management.tax_invoices.TaxInvoiceRepository;
import com.erp.system.financial.service.basic_information_management.TaxInvoiceService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(2)
public class TaxInvoiceServiceImpl implements TaxInvoiceService {
    private final TaxInvoiceRepository taxInvoiceRepository;

    public TaxInvoiceServiceImpl(TaxInvoiceRepository taxInvoiceRepository) {
        this.taxInvoiceRepository = taxInvoiceRepository;
    }

    /**
     * 세금 계산서를 저장함
     * @param taxInvoice 저장할 세금 계산서
     * @throws IllegalArgumentException 저장할 세금 계산서가 null일 경우
     */
    @Override
    public void saveTaxInvoice(TaxInvoice taxInvoice) {
        if (taxInvoice == null) {
            throw new IllegalArgumentException("저장할 세금 계산서는 null일 수 없습니다.");
        }
        taxInvoiceRepository.save(taxInvoice);
    }

    /**
     * ID로 세금 계산서를 조회함
     * @param id 세금 계산서의 ID
     * @return 조회된 세금 계산서를 Optional로 반환
     */
    @Override
    public Optional<TaxInvoice> findTaxInvoiceById(String id) {
        return taxInvoiceRepository.findById(id);
    }

    /**
     * 코드로 세금 계산서를 조회함
     * @param code 세금 계산서의 코드
     * @return 조회된 세금 계산서를 Optional로 반환
     */
    @Override
    public Optional<TaxInvoice> findTaxInvoiceByCode(String code) {
        return taxInvoiceRepository.findByCode(code);
    }

    /**
     * 모든 세금 계산서를 조회함
     * @return 저장된 모든 세금 계산서의 컬렉션
     */
    @Override
    public Collection<TaxInvoice> findAllTaxInvoices() {
        return taxInvoiceRepository.findAll();
    }
}