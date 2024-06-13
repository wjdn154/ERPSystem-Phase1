package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Accounts;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Memos;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.AccountsRepository;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.MemosRepository;

public class MemosRepositoryImpl extends GenericRepositoryImpl<Memos> implements MemosRepository {
    private static volatile MemosRepositoryImpl instance;

    /**
     * 싱글톤 인스턴스 반환.
     * @return MemosRepositoryImpl 인스턴스
     */
    public static synchronized MemosRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new MemosRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private MemosRepositoryImpl() {
        super(Memos.class);
    }

    
}