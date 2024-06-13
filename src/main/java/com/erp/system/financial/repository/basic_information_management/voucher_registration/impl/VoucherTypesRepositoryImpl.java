package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Accounts;
import com.erp.system.financial.model.basic_information_management.voucher_registration.VoucherTypes;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountsRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherTypesRepository;

public class VoucherTypesRepositoryImpl extends GenericRepositoryImpl<VoucherTypes> implements VoucherTypesRepository {
    private static volatile VoucherTypesRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return VoucherTypesRepositoryImpl 인스턴스
     */
    public static synchronized VoucherTypesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new VoucherTypesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private VoucherTypesRepositoryImpl() {
        super(VoucherTypes.class);
    }

    
}