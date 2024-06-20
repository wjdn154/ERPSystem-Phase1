package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Voucher;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherRepository;

@Component
@Priority(1)
public class VouchersRepositoryImpl extends GenericRepositoryImpl<Voucher> implements VoucherRepository {
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
        super(Voucher.class);
    }

    
}