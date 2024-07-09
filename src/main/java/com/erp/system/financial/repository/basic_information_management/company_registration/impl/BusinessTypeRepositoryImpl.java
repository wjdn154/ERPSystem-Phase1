package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.basic_information_management.company_registration.BusinessType;
import com.erp.system.financial.repository.basic_information_management.company_registration.BusinessTypeRepository;

@Component
public class BusinessTypeRepositoryImpl extends GenericRepositoryImpl<BusinessType> implements BusinessTypeRepository {
    private BusinessTypeRepositoryImpl() {
        super(BusinessType.class);
    }
}
