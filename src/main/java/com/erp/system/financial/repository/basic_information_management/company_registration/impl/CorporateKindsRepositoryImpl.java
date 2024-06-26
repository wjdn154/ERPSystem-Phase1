package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.CorporateKind;
import com.erp.system.financial.repository.basic_information_management.company_registration.CorporateKindRepository;

@Component
public class CorporateKindsRepositoryImpl extends GenericRepositoryImpl<CorporateKind> implements CorporateKindRepository {
    private CorporateKindsRepositoryImpl() {
        super(CorporateKind.class);
    }
}