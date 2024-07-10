package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.TaxOffice;
import com.erp.system.financial.repository.basic_information_management.company_registration.TaxOfficeRepository;

@Component
public class TaxOfficeRepositoryImpl extends GenericRepositoryImpl<TaxOffice> implements TaxOfficeRepository {
    private TaxOfficeRepositoryImpl() {
        super(TaxOffice.class);
    }
}