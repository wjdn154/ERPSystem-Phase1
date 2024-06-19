package com.erp.system.production.repository.master_data_management.product;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.master_data_management.product.Product;

/**
 * Product 엔티티에 대한 리포지토리 인터페이스.
 */
public interface ProductRepository extends GenericRepository<Product> {
    @Override
    void save(Product entity);
}
