package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionRepository;


@Component
public class BankTransactionsRepositoryImpl extends GenericRepositoryImpl<BankTransaction> implements BankTransactionRepository {
    private BankTransactionsRepositoryImpl() {
        super(BankTransaction.class);
    }
}