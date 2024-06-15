package com.erp.system.financial.repository.basic_information_management.vendor_registration.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorTypeRepository;

@Component
@Priority(1)
public class VendorTypesRepositoryImpl extends GenericRepositoryImpl<VendorType> implements VendorTypeRepository {
    private static volatile VendorTypesRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return VendorsTypesRepositoryImpl 인스턴스
     */
    public static synchronized VendorTypesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new VendorTypesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private VendorTypesRepositoryImpl() {
        super(VendorType.class);
    }

    
}