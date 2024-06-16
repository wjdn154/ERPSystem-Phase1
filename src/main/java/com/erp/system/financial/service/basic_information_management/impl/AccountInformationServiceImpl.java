package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
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
@Priority(2)
public class AccountInformationServiceImpl implements AccountInformationService {
    private final BankAccountRepository bankAccountsRepository;
    private final BankTransactionRepository bankTransactionsRepository;
    private final DepositRepository depositsRepository;

    public AccountInformationServiceImpl(BankAccountRepository bankAccountsRepository,
                                         BankTransactionRepository bankTransactionsRepository,
                                         DepositRepository depositsRepository) {
        this.bankAccountsRepository = bankAccountsRepository;
        this.bankTransactionsRepository = bankTransactionsRepository;
        this.depositsRepository = depositsRepository;
    }

    /**
     * 은행 계좌 저장
     * @param bankAccount 저장할 은행 계좌
     * @throws IllegalArgumentException null 입력 시 예외 발생
     */
    @Override
    public void saveBankAccount(BankAccount bankAccount) {
        if (bankAccount == null) {
            throw new IllegalArgumentException("저장할 은행 계좌는 null일 수 없습니다.");
        }
        bankAccountsRepository.save(bankAccount);
    }

    /**
     * 은행 거래 저장
     * @param bankTransaction 저장할 은행 거래
     * @throws IllegalArgumentException null 입력 시 예외 발생
     */
    @Override
    public void saveBankTransaction(BankTransaction bankTransaction) {
        if (bankTransaction == null) {
            throw new IllegalArgumentException("저장할 은행 거래는 null일 수 없습니다.");
        }
        bankTransactionsRepository.save(bankTransaction);
    }

    /**
     * 예금 저장
     * @param deposit 저장할 예금
     * @throws IllegalArgumentException null 입력 시 예외 발생
     */
    @Override
    public void saveDeposit(Deposit deposit) {
        if (deposit == null) {
            throw new IllegalArgumentException("저장할 예금은 null일 수 없습니다.");
        }
        depositsRepository.save(deposit);
    }

    /**
     * ID로 은행 계좌 검색
     * @param id   은행 계좌 ID
     * @return 검색된 은행 계좌, 없으면 Optional.empty()
     */
    @Override
    public Optional<BankAccount> findBankAccountById(String id) {
        return bankAccountsRepository.findById(id);
    }

    /**
     * 코드로 은행 계좌 검색
     * @param code 은행 계좌 ID
     * @return 검색된 은행 계좌, 없으면 Optional.empty()
     */
    @Override
    public Optional<BankAccount> findBankAccountByCode(String code) {
        return bankAccountsRepository.findById(code);
    }


    /**
     * 코드로 은행 거래 검색
     * @param code 은행 거래 코드
     * @return 검색된 은행 거래, 없으면 Optional.empty()
     */
    @Override
    public Optional<BankTransaction> findBankTransactionByCode(String code) {
        return bankTransactionsRepository.findByCode(code);
    }

    /**
     * 코드로 은행 거래 검색
     * @param id 은행 거래 코드
     * @return 검색된 은행 거래, 없으면 Optional.empty()
     */
    @Override
    public Optional<BankTransaction> findBankTransactionById(String id) {
        return bankTransactionsRepository.findById(id);
    }

    /**
     * ID로 예금 검색
     * @param id   예금 ID
     * @return 검색된 예금, 없으면 Optional.empty()
     */
    @Override
    public Optional<Deposit> findDepositById(String id) {
        return depositsRepository.findById(id);
    }

    /**
     * 코드로 예금 검색
     * @param code 예금 코드
     * @return 검색된 예금, 없으면 Optional.empty()
     */
    @Override
    public Optional<Deposit> findDepositByCode(String code) {
        return depositsRepository.findByCode(code);
    }

    /**
     * 모든 은행 계좌 조회
     * @return 모든 은행 계좌 리스트
     */
    @Override
    public Collection<BankAccount> findAllBankAccounts() {
        return bankAccountsRepository.findAll();
    }

    /**
     * 모든 은행 거래 조회
     * @return 모든 은행 거래 리스트
     */
    @Override
    public Collection<BankTransaction> findAllBankTransactions() {
        return bankTransactionsRepository.findAll();
    }

    /**
     * 모든 예금 조회
     * @return 모든 예금 리스트
     */
    @Override
    public Collection<Deposit> findAllDeposits() {
        return depositsRepository.findAll();
    }
}