package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Memo;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.MemoRepository;

@Component
@Priority(1)
public class MemosRepositoryImpl extends GenericRepositoryImpl<Memo> implements MemoRepository {
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
        super(Memo.class);
    }

    
}