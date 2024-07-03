package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Account;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountRepository;

@Component
public class AccountsRepositoryImpl extends GenericRepositoryImpl<Account> implements AccountRepository {
    private AccountsRepositoryImpl() {
        super(Account.class);
    }

    
}