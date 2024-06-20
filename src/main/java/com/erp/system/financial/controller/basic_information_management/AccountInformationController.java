package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.service.basic_information_management.AccountInformationService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class AccountInformationController {
    private final AccountInformationService accountInformationService;

    public AccountInformationController(AccountInformationService accountInformationService) {
        this.accountInformationService = accountInformationService;
    }

    /**
     * 은행 계좌를 저장함
     * @param bankAccount 저장할 은행 계좌
     */
    public void saveBankAccount(BankAccount bankAccount) {
        accountInformationService.saveBankAccount(bankAccount);
    }

    /**
     * 은행 거래를 저장함
     * @param bankTransaction 저장할 은행 거래
     */
    public void saveBankTransaction(BankTransaction bankTransaction) {
        accountInformationService.saveBankTransaction(bankTransaction);
    }

    /**
     * 예금을 저장함
     * @param deposit 저장할 예금
     */
    public void saveDeposit(Deposit deposit) {
        accountInformationService.saveDeposit(deposit);
    }

    /**
     * ID로 은행 계좌를 조회함
     * @param id 은행 계좌의 ID
     * @return 조회된 은행 계좌를 Optional로 반환
     */
    public Optional<BankAccount> findBankAccountById(String id) {
        return accountInformationService.findBankAccountById(id);
    }

    /**
     * 코드로 은행 계좌를 조회함
     * @param code 은행 계좌의 코드
     * @return 조회된 은행 계좌를 Optional로 반환
     */
    public Optional<BankAccount> findBankAccountByCode(String code) {
        return accountInformationService.findBankAccountByCode(code);
    }

    /**
     * ID로 은행 거래를 조회함
     * @param id 은행 거래의 ID
     * @return 조회된 은행 거래를 Optional로 반환
     */
    public Optional<BankTransaction> findBankTransactionById(String id) {
        return accountInformationService.findBankTransactionById(id);
    }

    /**
     * 코드로 은행 거래를 조회함
     * @param code 은행 거래의 코드
     * @return 조회된 은행 거래를 Optional로 반환
     */
    public Optional<BankTransaction> findBankTransactionByCode(String code) {
        return accountInformationService.findBankTransactionByCode(code);
    }

    /**
     * ID로 예금을 조회함
     * @param id 예금의 ID
     * @return 조회된 예금을 Optional로 반환
     */
    public Optional<Deposit> findDepositById(String id) {
        return accountInformationService.findDepositById(id);
    }

    /**
     * 코드로 예금을 조회함
     * @param code 예금의 코드
     * @return 조회된 예금을 Optional로 반환
     */
    public Optional<Deposit> findDepositByCode(String code) {
        return accountInformationService.findDepositByCode(code);
    }

    /**
     * 모든 은행 계좌를 조회함
     * @return 저장된 모든 은행 계좌의 컬렉션
     */
    public Collection<BankAccount> findAllBankAccounts() {
        return accountInformationService.findAllBankAccounts();
    }

    /**
     * 모든 은행 거래를 조회함
     * @return 저장된 모든 은행 거래의 컬렉션
     */
    public Collection<BankTransaction> findAllBankTransactions() {
        return accountInformationService.findAllBankTransactions();
    }

    /**
     * 모든 예금을 조회함
     * @return 저장된 모든 예금의 컬렉션
     */
    public Collection<Deposit> findAllDeposits() {
        return accountInformationService.findAllDeposits();
    }
}