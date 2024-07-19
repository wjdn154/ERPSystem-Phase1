package com.erp.system.financial.repository.basic_information_management.vendor_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorTypeRepository;

@Component
public class VendorTypesRepositoryImpl extends GenericRepositoryImpl<VendorType> implements VendorTypeRepository {
    private VendorTypesRepositoryImpl() {
        super(VendorType.class);
    }

    
}