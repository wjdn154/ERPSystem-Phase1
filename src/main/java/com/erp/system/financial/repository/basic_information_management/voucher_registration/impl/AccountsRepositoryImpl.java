package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorTypes;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Accounts;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorTypesRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountsRepository;

public class AccountsRepositoryImpl extends GenericRepositoryImpl<Accounts> implements AccountsRepository {
    private static volatile AccountsRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return AccountsRepositoryImpl 인스턴스
     */
    public static synchronized AccountsRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new AccountsRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private AccountsRepositoryImpl() {
        super(Accounts.class);
    }

    
}