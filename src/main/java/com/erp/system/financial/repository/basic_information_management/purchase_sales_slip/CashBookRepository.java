package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;

/**
 * 현금출납장 엔티티에 대한 리포지토리 인터페이스.
 */
public interface CashBookRepository extends GenericRepository<CashBook> {
    @Override
    void save(CashBook entity);
}