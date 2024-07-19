package com.erp.system.logistics.repository.basic_information_registration.product_registration;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.logistics.model.basic_information_registration.product_registration.ProductGroup;

import java.util.List;

/**
 * 품목 그룹 엔티티에 대한 리포지토리 인터페이스
 */
public interface ProductGroupRepository extends GenericRepository<ProductGroup> {
    @Override
    void save(ProductGroup productGroup);

    @Override
    List<ProductGroup> findAll();
}
