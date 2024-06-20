package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.CorporateKind;
import com.erp.system.financial.repository.basic_information_management.company_registration.CorporateKindRepository;

@Component
@Priority(1)
public class CorporateKindsRepositoryImpl extends GenericRepositoryImpl<CorporateKind> implements CorporateKindRepository {
    private static volatile CorporateKindsRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return CorporateKindsRepositoryImpl 인스턴스
     */
    public static synchronized CorporateKindsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CorporateKindsRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private CorporateKindsRepositoryImpl() {
        super(CorporateKind.class);
    }
}