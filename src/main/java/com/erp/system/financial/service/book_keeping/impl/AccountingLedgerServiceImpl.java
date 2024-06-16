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
    /**
     * 현금출납장을 저장함
     * @param cashBook 저장할 현금출납장
     * @throws IllegalArgumentException 저장할 현금출납장이 null일 경우
     */
    @Override
    public void saveCashBook(CashBook cashBook) {
        if (cashBook == null) {
            throw new IllegalArgumentException("저장할 현금출납장는 null일 수 없습니다.");
        }
        cashBookRepository.save(cashBook);
    }

    /**
     * 총계정원장을 저장함
     * @param generalLedger 저장할 총계정원장
     * @throws IllegalArgumentException 저장할 총계정원장이 null일 경우
     */
    @Override
    public void saveGeneralLedger(GeneralLedger generalLedger) {
        if (generalLedger == null) {
            throw new IllegalArgumentException("저장할 총계정원장은 null일 수 없습니다.");
        }
        generalLedgerRepository.save(generalLedger);
    }

    /**
     * ID로 현금출납장를 조회함
     * @param id 현금출납장의 ID
     * @return 조회된 현금출납장를 Optional로 반환
     */
    @Override
    public Optional<CashBook> findCashBookById(String id) {
        return cashBookRepository.findById(id);
    }

    /**
     * 코드로 현금출납장를 조회함
     * @param code 현금출납장의 코드
     * @return 조회된 현금출납장를 Optional로 반환
     */
    @Override
    public Optional<CashBook> findCashBookByCode(String code) {
        return cashBookRepository.findByCode(code);
    }

    /**
     * ID로 총계정원장을 조회함
     * @param id 총계정원장의 ID
     * @return 조회된 총계정원장을 Optional로 반환
     */
    @Override
    public Optional<GeneralLedger> findGeneralLedgerById(String id) {
        return generalLedgerRepository.findById(id);
    }

    /**
     * 코드로 총계정원장을 조회함
     * @param code 총계정원장의 코드
     * @return 조회된 총계정원장을 Optional로 반환
     */
    @Override
    public Optional<GeneralLedger> findGeneralLedgerByCode(String code) {
        return generalLedgerRepository.findByCode(code);
    }

    /**
     * 모든 현금출납장를 조회함
     * @return 저장된 모든 현금출납장의 컬렉션
     */
    @Override
    public Collection<CashBook> findAllCashBooks() {
        return cashBookRepository.findAll();
    }

    /**
     * 모든 총계정원장을 조회함
     * @return 저장된 모든 총계정원장의 컬렉션
     */
    @Override
    public Collection<GeneralLedger> findAllGeneralLedgers() {
        return generalLedgerRepository.findAll();
    }
}
