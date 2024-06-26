package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypeRepository;

@Component
public class VatTypesRepositoryImpl extends GenericRepositoryImpl<VatType> implements VatTypeRepository {
    private VatTypesRepositoryImpl() {
        super(VatType.class);
    }

    
}