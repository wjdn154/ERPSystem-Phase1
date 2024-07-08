package com.erp.system.financial.repository.basic_information_management.vendor_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;

import java.util.List;

/**
 * 거래처 유형 엔티티에 대한 리포지토리 인터페이스.
 */
public interface VendorTypeRepository extends GenericRepository<VendorType> {
    @Override
    void save(VendorType entity);

    @Override
    List<VendorType> findAll();
}