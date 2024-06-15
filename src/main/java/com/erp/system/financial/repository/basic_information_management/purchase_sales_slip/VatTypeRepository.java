package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;

/**
 * 부가세유형 엔티티에 대한 리포지토리 인터페이스.
 */
public interface VatTypeRepository extends GenericRepository<VatType> {
    @Override
    void save(VatType entity);
}