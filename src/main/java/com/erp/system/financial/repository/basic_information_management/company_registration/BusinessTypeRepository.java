package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.company_registration.BusinessItem;
import com.erp.system.financial.model.basic_information_management.company_registration.BusinessType;

import java.util.List;

public interface BusinessTypeRepository extends GenericRepository<BusinessType> {
    @Override
    void save(BusinessType entity);

    @Override
    List<BusinessType> findAll();
}
