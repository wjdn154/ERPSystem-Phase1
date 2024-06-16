package com.erp.system.financial.repository.basic_information_management.voucher_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.voucher_registration.VoucherType;
import com.erp.system.financial.repository.basic_information_management.voucher_registration.VoucherTypeRepository;

@Component
@Priority(1)
public class VoucherTypesRepositoryImpl extends GenericRepositoryImpl<VoucherType> implements VoucherTypeRepository {
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
        super(VoucherType.class);
    }

    
}