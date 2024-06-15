package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankTransaction;
import com.erp.system.financial.repository.basic_information_management.account_information.BankTransactionRepository;


@Component
@Priority(1)
public class BankTransactionsRepositoryImpl extends GenericRepositoryImpl<BankTransaction> implements BankTransactionRepository {
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
        super(BankTransaction.class);
    }
}