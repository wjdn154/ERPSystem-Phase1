package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.CorporateType;
import com.erp.system.financial.repository.basic_information_management.company_registration.CorporateTypeRepository;

@Component
@Priority(1)
public class CorporateTypesRepositoryImpl extends GenericRepositoryImpl<CorporateType> implements CorporateTypeRepository {
    private static volatile CorporateTypesRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return CorporateTypesRepositoryImpl 인스턴스
     */
    public static synchronized CorporateTypesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CorporateTypesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private CorporateTypesRepositoryImpl() {
        super(CorporateType.class);
    }
}