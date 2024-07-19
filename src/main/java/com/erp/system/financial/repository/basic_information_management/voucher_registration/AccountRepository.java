package com.erp.system.financial.repository.basic_information_management.voucher_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;
import com.erp.system.financial.model.basic_information_management.voucher_registration.Account;

import java.util.List;

/**
 * 계정과목 엔티티에 대한 리포지토리 인터페이스.
 */
public interface AccountRepository extends GenericRepository<Account> {
    @Override
    void save(Account entity);

    @Override
    List<Account> findAll();
}