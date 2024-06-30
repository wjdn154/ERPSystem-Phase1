package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.TaxOffice;
import com.erp.system.financial.repository.basic_information_management.company_registration.TaxRepository;

@Component
public class TaxRepositoryImpl extends GenericRepositoryImpl<TaxOffice> implements TaxRepository {
    private TaxRepositoryImpl() {
        super(TaxOffice.class);
    }
}