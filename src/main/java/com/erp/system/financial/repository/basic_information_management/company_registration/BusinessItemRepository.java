package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.basic_information_management.company_registration.BusinessItem;
import com.erp.system.financial.model.basic_information_management.company_registration.Company;

import java.util.List;

public interface BusinessItemRepository extends GenericRepository<BusinessItem> {
    @Override
    void save(BusinessItem entity);

    @Override
    List<BusinessItem> findAll();
}
