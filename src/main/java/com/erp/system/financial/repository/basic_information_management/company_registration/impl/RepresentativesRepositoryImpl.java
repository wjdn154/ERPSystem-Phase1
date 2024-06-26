package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Representative;
import com.erp.system.financial.repository.basic_information_management.company_registration.RepresentativeRepository;

@Component
public class RepresentativesRepositoryImpl extends GenericRepositoryImpl<Representative> implements RepresentativeRepository {
    private RepresentativesRepositoryImpl() {
        super(Representative.class);
    }
}