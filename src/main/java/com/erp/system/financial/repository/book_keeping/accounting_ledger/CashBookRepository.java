package com.erp.system.financial.repository.book_keeping.accounting_ledger;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;

import java.util.List;

/**
 * 현금출납장 엔티티에 대한 리포지토리 인터페이스.
 */
public interface CashBookRepository extends GenericRepository<CashBook> {
    @Override
    void save(CashBook entity);

    @Override
    List<CashBook> findAll();
}