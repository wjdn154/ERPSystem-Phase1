package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccounts;
import com.erp.system.financial.model.basic_information_management.account_information.Deposits;
import com.erp.system.financial.repository.basic_information_management.account_information.BankAccountsRepository;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositsRepository;

public class DepositsRepositoryImpl extends GenericRepositoryImpl<Deposits> implements DepositsRepository {
    private static volatile DepositsRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return DepositsRepositoryImpl 인스턴스
     */
    public static synchronized DepositsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DepositsRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private DepositsRepositoryImpl() {
        super(Deposits.class);
    }
}