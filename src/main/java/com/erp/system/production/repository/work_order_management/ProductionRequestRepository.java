package com.erp.system.production.repository.work_order_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_order_management.ProductionRequest;

import java.util.List;

/**
 * 생산요청 엔티티 리포지토리 IF
 */

public interface ProductionRequestRepository extends GenericRepository<ProductionRequest> {
    @Override
    void save(ProductionRequest entity);

    @Override
    List<ProductionRequest> findAll();
}
