package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.account_information.BankAccounts;
import com.erp.system.financial.model.basic_information_management.company_registration.Representatives;
import com.erp.system.financial.repository.basic_information_management.company_registration.RepresentativesRepository;

public class RepresentativesRepositoryImpl extends GenericRepositoryImpl<Representatives> implements RepresentativesRepository {
    private static volatile RepresentativesRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return RepresentativesRepositoryImpl 인스턴스
     */
    public static synchronized RepresentativesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RepresentativesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private RepresentativesRepositoryImpl() {
        super(Representatives.class);
    }
}