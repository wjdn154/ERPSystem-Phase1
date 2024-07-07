package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.basic_information_management.company_registration.BusinessItem;
import com.erp.system.financial.repository.basic_information_management.company_registration.BusinessItemRepository;

@Component
public class BusinessItemRepositoryImpl  extends GenericRepositoryImpl<BusinessItem> implements BusinessItemRepository {
    protected BusinessItemRepositoryImpl(Class<BusinessItem> entityClass) {
        super(entityClass);
    }
}
