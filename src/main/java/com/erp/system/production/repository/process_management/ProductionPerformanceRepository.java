package com.erp.system.production.repository.process_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.process_management.ProductionPerformance;

/**
 * ProductionPerformance 엔티티에 대한 리포지토리 인터페이스.
 */
public interface ProductionPerformanceRepository extends GenericRepository<ProductionPerformance> {
    @Override
    void save(ProductionPerformance entity);
}
