package com.erp.system.financial.controller.book_keeping;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Account;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Memo;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.model.basic_information_management.voucher_registration.VoucherType;
import com.erp.system.financial.model.book_keeping.accounting_ledger.CashBook;
import com.erp.system.financial.model.book_keeping.accounting_ledger.GeneralLedger;
import com.erp.system.financial.service.basic_information_management.VoucherRegistrationService;
import com.erp.system.financial.service.book_keeping.AccountingLedgerService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class AccountingLedgerController {
    private final AccountingLedgerService accountingLedgerService;

    public AccountingLedgerController(AccountingLedgerService accountingLedgerService) {
        this.accountingLedgerService = accountingLedgerService;
    }
    /**
     * 현금출납장을 저장함
     * @param cashBook 저장할 현금출납장
     * @throws IllegalArgumentException 저장할 현금출납장이 null일 경우
     */
    public void saveCashBook(CashBook cashBook) {
        accountingLedgerService.saveCashBook(cashBook);
    }

    /**
     * 총계정원장을 저장함
     * @param generalLedger 저장할 총계정원장
     * @throws IllegalArgumentException 저장할 총계정원장이 null일 경우
     */
    public void saveGeneralLedger(GeneralLedger generalLedger) {
        accountingLedgerService.saveGeneralLedger(generalLedger);
    }

    /**
     * ID로 현금출납장을 조회함
     * @param id 현금출납장의 ID
     * @return 조회된 현금출납장을 Optional로 반환
     */
    public Optional<CashBook> findCashBookById(String id) {
        return accountingLedgerService.findCashBookById(id);
    }

    /**
     * 코드로 현금출납장을 조회함
     * @param code 현금출납장의 코드
     * @return 조회된 현금출납장을 Optional로 반환
     */
    public Optional<CashBook> findCashBookByCode(String code) {
        return accountingLedgerService.findCashBookByCode(code);
    }

    /**
     * ID로 총계정원장을 조회함
     * @param id 총계정원장의 ID
     * @return 조회된 총계정원장을 Optional로 반환
     */
    public Optional<GeneralLedger> findGeneralLedgerById(String id) {
        return accountingLedgerService.findGeneralLedgerById(id);
    }

    /**
     * 코드로 총계정원장을 조회함
     * @param code 총계정원장의 코드
     * @return 조회된 총계정원장을 Optional로 반환
     */
    public Optional<GeneralLedger> findGeneralLedgerByCode(String code) {
        return accountingLedgerService.findGeneralLedgerByCode(code);
    }

    /**
     * 모든 현금출납장을 조회함
     * @return 저장된 모든 현금출납장의 컬렉션
     */
    public Collection<CashBook> findAllCashBooks() {
        return accountingLedgerService.findAllCashBooks();
    }

    /**
     * 모든 총계정원장을 조회함
     * @return 저장된 모든 총계정원장의 컬렉션
     */
    public Collection<GeneralLedger> findAllGeneralLedgers() {
        return accountingLedgerService.findAllGeneralLedgers();
    }
}
