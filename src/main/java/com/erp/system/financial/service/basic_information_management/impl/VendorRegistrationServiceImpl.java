package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorTypeRepository;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(2)
public class VendorRegistrationServiceImpl implements VendorRegistrationService {
    private final VendorRepository vendorRepository;
    private final VendorTypeRepository vendorTypeRepository;

    public VendorRegistrationServiceImpl(VendorRepository vendorRepository,
                                         VendorTypeRepository vendorTypeRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorTypeRepository = vendorTypeRepository;
    }

}