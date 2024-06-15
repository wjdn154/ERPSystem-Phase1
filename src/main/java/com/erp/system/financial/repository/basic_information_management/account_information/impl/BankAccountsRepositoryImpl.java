package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccount;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountRepository;


@Component
@Priority(1)
public class BankAccountsRepositoryImpl extends GenericRepositoryImpl<BankAccount> implements BankAccountRepository {
    private static volatile BankAccountsRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return BankAccountsRepositoryImpl 인스턴스
     */
    public static synchronized BankAccountsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BankAccountsRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private BankAccountsRepositoryImpl() {
        super(BankAccount.class);
    }
}