package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.CorporateType;
import com.erp.system.financial.repository.basic_information_management.company_registration.CorporateTypeRepository;

@Component
public class CorporateTypeRepositoryImpl extends GenericRepositoryImpl<CorporateType> implements CorporateTypeRepository {
    private CorporateTypeRepositoryImpl() {
        super(CorporateType.class);
    }
}