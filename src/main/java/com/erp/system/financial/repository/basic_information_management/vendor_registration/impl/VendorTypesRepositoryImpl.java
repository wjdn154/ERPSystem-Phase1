package com.erp.system.financial.repository.basic_information_management.vendor_registration.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorTypes;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorTypesRepository;

public class VendorTypesRepositoryImpl extends GenericRepositoryImpl<VendorTypes> implements VendorTypesRepository {
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
        super(VendorTypes.class);
    }

    
}