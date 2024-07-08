package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherRepository;

@Component
public class VouchersRepositoryImpl extends GenericRepositoryImpl<Voucher> implements VoucherRepository {
    private VouchersRepositoryImpl() {
        super(Voucher.class);
    }

    
}