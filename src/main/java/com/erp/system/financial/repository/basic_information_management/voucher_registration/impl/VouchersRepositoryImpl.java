package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Accounts;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Vouchers;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountsRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VouchersRepository;

public class VouchersRepositoryImpl extends GenericRepositoryImpl<Vouchers> implements VouchersRepository {
    private static volatile VouchersRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return VouchersRepositoryImpl 인스턴스
     */
    public static synchronized VouchersRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new VouchersRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private VouchersRepositoryImpl() {
        super(Vouchers.class);
    }

    
}