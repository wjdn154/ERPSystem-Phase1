package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;
import com.erp.system.financial.repository.basic_information_management.company_registration.CompanyRepository;


@Component
public class CompanyRepositoryImpl extends GenericRepositoryImpl<Company> implements CompanyRepository {
    private CompanyRepositoryImpl() {
        super(Company.class);
    }
}