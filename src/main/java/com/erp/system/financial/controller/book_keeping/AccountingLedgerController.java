package com.erp.system.financial.controller.book_keeping;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.CashBookRepository;
import com.erp.system.financial.repository.book_keeping.accounting_ledger.GeneralLedgerRepository;
import com.erp.system.financial.service.book_keeping.AccountingLedgerService;

import java.util.Collection;
import java.util.Optional;

@Component
public class AccountingLedgerController {
    private final AccountingLedgerService accountingLedgerService;
    private final CashBookRepository cashBookRepository;
    private final GeneralLedgerRepository generalLedgerRepository;

    public AccountingLedgerController(AccountingLedgerService accountingLedgerService,
                                      CashBookRepository cashBookRepository,
                                      GeneralLedgerRepository generalLedgerRepository) {
        this.accountingLedgerService = accountingLedgerService;
        this.cashBookRepository = cashBookRepository;
        this.generalLedgerRepository = generalLedgerRepository;
    }
    /**
     * 현금출납장을 저장함
     * @param cashBook 저장할 현금출납장
     * @throws IllegalArgumentException 저장할 현금출납장이 null일 경우
     */
    public void saveCashBook(CashBook cashBook) {
        cashBookRepository.save(cashBook);
    }

    /**
     * 총계정원장을 저장함
     * @param generalLedger 저장할 총계정원장
     * @throws IllegalArgumentException 저장할 총계정원장이 null일 경우
     */
    public void saveGeneralLedger(GeneralLedger generalLedger) {
        generalLedgerRepository.save(generalLedger);
    }

    /**
     * ID로 현금출납장을 조회함
     * @param id 현금출납장의 ID
     * @return 조회된 현금출납장을 Optional로 반환
     */
    public Optional<CashBook> findCashBookById(String id) {
        return cashBookRepository.findById(id);
    }


    /**
     * ID로 총계정원장을 조회함
     * @param id 총계정원장의 ID
     * @return 조회된 총계정원장을 Optional로 반환
     */
    public Optional<GeneralLedger> findGeneralLedgerById(String id) {
        return generalLedgerRepository.findById(id);
    }

    /**
     * 모든 현금출납장을 조회함
     * @return 저장된 모든 현금출납장의 컬렉션
     */
    public Collection<CashBook> findAllCashBooks() {
        return cashBookRepository.findAll();
    }

    /**
     * 모든 총계정원장을 조회함
     * @return 저장된 모든 총계정원장의 컬렉션
     */
    public Collection<GeneralLedger> findAllGeneralLedgers() {
        return generalLedgerRepository.findAll();
    }
}
