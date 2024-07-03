package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.repository.basic_information_management.company_registration.AddressRepository;


@Component
public class AddressRepositoryImpl extends GenericRepositoryImpl<Address> implements AddressRepository {
    private AddressRepositoryImpl() {
        super(Address.class);
    }
}