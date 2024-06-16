package com.erp.system.financial.repository.basic_information_management.company_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.repository.basic_information_management.company_registration.AddressRepository;


@Component
@Priority(1)
public class AddressesRepositoryImpl extends GenericRepositoryImpl<Address> implements AddressRepository {
    private static volatile AddressesRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return AddressesRepositoryImpl 인스턴스
     */
    public static synchronized AddressesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new AddressesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private AddressesRepositoryImpl() {
        super(Address.class);
    }
}