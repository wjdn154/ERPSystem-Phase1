package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Tax;
import com.erp.system.financial.repository.basic_information_management.company_registration.TaxRepository;

@Component
public class TaxRepositoryImpl extends GenericRepositoryImpl<Tax> implements TaxRepository {
    private TaxRepositoryImpl() {
        super(Tax.class);
    }
}