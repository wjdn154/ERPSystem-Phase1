package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositRepository;
import com.erp.system.financial.service.basic_information_management.AccountInformationService;

import java.util.Collection;
import java.util.Optional;

@Component
public class AccountInformationController {
    private final AccountInformationService accountInformationService;
    private final BankAccountRepository bankAccountRepository;
    private final BankTransactionRepository bankTransactionRepository;
    private final DepositRepository depositRepository;
    
    public AccountInformationController(AccountInformationService accountInformationService,
                                        BankAccountRepository bankAccountRepository,
                                        BankTransactionRepository bankTransactionRepository,
                                        DepositRepository depositRepository) {
        this.accountInformationService = accountInformationService;
        this.bankAccountRepository = bankAccountRepository;
        this.bankTransactionRepository = bankTransactionRepository;
        this.depositRepository = depositRepository;
    }

    /**
     * 은행 계좌를 저장함
     * @param bankAccount 저장할 은행 계좌
     */
    public void saveBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    /**
     * 은행 거래를 저장함
     * @param bankTransaction 저장할 은행 거래
     */
    public void saveBankTransaction(BankTransaction bankTransaction) {
        bankTransactionRepository.save(bankTransaction);
    }

    /**
     * 예금을 저장함
     * @param deposit 저장할 예금
     */
    public void saveDeposit(Deposit deposit) {
        depositRepository.save(deposit);
    }

    /**
     * ID로 은행 계좌를 조회함
     * @param id 은행 계좌의 ID
     * @return 조회된 은행 계좌를 Optional로 반환
     */
    public Optional<BankAccount> findBankAccountById(String id) {
        return bankAccountRepository.findById(id);
    }

    /**
     * ID로 은행 거래를 조회함
     * @param id 은행 거래의 ID
     * @return 조회된 은행 거래를 Optional로 반환
     */
    public Optional<BankTransaction> findBankTransactionById(String id) {
        return bankTransactionRepository.findById(id);
    }

    /**
     * ID로 예금을 조회함
     * @param id 예금의 ID
     * @return 조회된 예금을 Optional로 반환
     */
    public Optional<Deposit> findDepositById(String id) {
        return depositRepository.findById(id);
    }

    /**
     * 모든 은행 계좌를 조회함
     * @return 저장된 모든 은행 계좌의 컬렉션
     */
    public Collection<BankAccount> findAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    /**
     * 모든 은행 거래를 조회함
     * @return 저장된 모든 은행 거래의 컬렉션
     */
    public Collection<BankTransaction> findAllBankTransactions() {
        return bankTransactionRepository.findAll();
    }

    /**
     * 모든 예금을 조회함
     * @return 저장된 모든 예금의 컬렉션
     */
    public Collection<Deposit> findAllDeposits() {
        return depositRepository.findAll();
    }
}