package com.erp.system.financial.repository.basic_information_management.account_information.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.repository.basic_information_management.account_information.DepositRepository;


@Component
@Priority(1)
public class DepositsRepositoryImpl extends GenericRepositoryImpl<Deposit> implements DepositRepository {
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
        super(Deposit.class);
    }
}