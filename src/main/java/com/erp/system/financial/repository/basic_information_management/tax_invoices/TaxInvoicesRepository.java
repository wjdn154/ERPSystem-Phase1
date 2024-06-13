package com.erp.system.financial.repository.basic_information_management.tax_invoices;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.tax_invoices.TaxInvoices;

/**
 * 전자 세금 계산서 엔티티에 대한 리포지토리 인터페이스.
 */
public interface TaxInvoicesRepository extends GenericRepository<TaxInvoices> {
    @Override
    void save(TaxInvoices entity);
}