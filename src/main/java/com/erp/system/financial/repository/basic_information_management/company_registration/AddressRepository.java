package com.erp.system.financial.repository.basic_information_management.company_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.account_information.Deposit;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;

import java.util.List;

/**
 * 주소 정보 엔티티에 대한 리포지토리 인터페이스.
 */
public interface AddressRepository extends GenericRepository<Address> {
    @Override
    void save(Address entity);

    @Override
    List<Address> findAll();
}