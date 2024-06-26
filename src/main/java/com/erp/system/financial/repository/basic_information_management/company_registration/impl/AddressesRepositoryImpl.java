package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.repository.basic_information_management.company_registration.AddressRepository;


@Component
public class AddressesRepositoryImpl extends GenericRepositoryImpl<Address> implements AddressRepository {
    private AddressesRepositoryImpl() {
        super(Address.class);
    }
}