package com.erp.system.financial.service.book_keeping;

import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;

import java.util.Collection;
import java.util.Optional;

public interface AccountingLedgerService {

    void saveCashBook(CashBook cashBook);
    void saveGeneralLedger(GeneralLedger generalLedger);
    Optional<CashBook> findCashBookById(String id);
    Optional<CashBook> findCashBookByCode(String code);
    Optional<GeneralLedger> findGeneralLedgerById(String id);
    Optional<GeneralLedger> findGeneralLedgerByCode(String code);

    Collection<CashBook> findAllCashBooks();
    Collection<GeneralLedger> findAllGeneralLedgers();
}