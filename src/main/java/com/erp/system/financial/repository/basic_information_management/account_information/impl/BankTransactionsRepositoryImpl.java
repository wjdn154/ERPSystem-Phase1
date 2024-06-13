package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccounts;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransactions;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountsRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionsRepository;

public class BankTransactionsRepositoryImpl extends GenericRepositoryImpl<BankTransactions> implements BankTransactionsRepository {
    private static volatile BankTransactionsRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return BankTransactionsRepositoryImpl 인스턴스
     */
    public static synchronized BankTransactionsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BankTransactionsRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private BankTransactionsRepositoryImpl() {
        super(BankTransactions.class);
    }
}