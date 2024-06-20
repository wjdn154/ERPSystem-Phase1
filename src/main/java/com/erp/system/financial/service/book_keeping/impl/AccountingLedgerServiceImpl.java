package com.erp.system.financial.service.book_keeping.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.CashBookRepository;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.GeneralLedgerRepository;
import com.erp.system.financial.service.book_keeping.AccountingLedgerService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(2)
public class AccountingLedgerServiceImpl implements AccountingLedgerService {
    private final CashBookRepository cashBookRepository;
    private final GeneralLedgerRepository generalLedgerRepository;

    public AccountingLedgerServiceImpl(CashBookRepository cashBookRepository,
                                       GeneralLedgerRepository generalLedgerRepository) {
        this.cashBookRepository = cashBookRepository;
        this.generalLedgerRepository = generalLedgerRepository;
    }
}
