package com.erp.system.production.repository.process_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.process_management.ProductionStock;

/**
 * ProductionStock 엔티티에 대한 리포지토리 인터페이스.
 */
public interface ProductionStockRepository extends GenericRepository<ProductionStock> {
    @Override
    void save(ProductionStock entity);
}
