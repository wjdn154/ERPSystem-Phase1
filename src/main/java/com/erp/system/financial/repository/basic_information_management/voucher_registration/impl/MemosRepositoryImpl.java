package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Memo;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.MemoRepository;

@Component
public class MemosRepositoryImpl extends GenericRepositoryImpl<Memo> implements MemoRepository {
    private MemosRepositoryImpl() {
        super(Memo.class);
    }

    
}