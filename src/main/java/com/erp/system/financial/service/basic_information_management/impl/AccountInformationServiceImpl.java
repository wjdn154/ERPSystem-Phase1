package com.erp.system.financial.service.basic_information_management.impl;

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

}