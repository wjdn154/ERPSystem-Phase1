package com.erp.system.financial.repository.basic_information_management.vendor_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;

@Component
public class VendorsRepositoryImpl extends GenericRepositoryImpl<Vendor> implements VendorRepository {
    private VendorsRepositoryImpl() {
        super(Vendor.class);
    }

    
}