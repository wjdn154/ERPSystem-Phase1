package com.erp.system.financial.repository.book_keeping.accounting_ledger;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;

import java.util.List;

/**
 * 총계정원장 엔티티에 대한 리포지토리 인터페이스.
 */
public interface GeneralLedgerRepository extends GenericRepository<GeneralLedger> {
    @Override
    void save(GeneralLedger entity);

    @Override
    List<GeneralLedger> findAll();
}