package com.erp.system.financial.repository.basic_information_management.vendor_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;

/**
 * 거래처 엔티티에 대한 리포지토리 인터페이스.
 */
public interface VendorRepository extends GenericRepository<Vendor> {
    @Override
    void save(Vendor entity);
}