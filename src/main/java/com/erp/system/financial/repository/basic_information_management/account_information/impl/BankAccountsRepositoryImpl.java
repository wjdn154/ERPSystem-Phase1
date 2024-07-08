package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;


@Component
public class BankAccountsRepositoryImpl extends GenericRepositoryImpl<BankAccount> implements BankAccountRepository {
    private BankAccountsRepositoryImpl() {
        super(BankAccount.class);
    }
}