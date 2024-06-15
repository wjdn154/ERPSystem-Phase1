package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypeRepository;

@Component
@Priority(1)
public class VatTypesRepositoryImpl extends GenericRepositoryImpl<VatType> implements VatTypeRepository {
    private static volatile VatTypesRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return VatTypesRepositoryImpl 인스턴스
     */
    public static synchronized VatTypesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new VatTypesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private VatTypesRepositoryImpl() {
        super(VatType.class);
    }

    
}