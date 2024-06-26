package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.VoucherType;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherTypeRepository;

@Component
public class VoucherTypesRepositoryImpl extends GenericRepositoryImpl<VoucherType> implements VoucherTypeRepository {
    private VoucherTypesRepositoryImpl() {
        super(VoucherType.class);
    }

    
}