package com.erp.system.production.repository.work_order_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_order_management.StockBasedPlan;

import java.util.List;

/**
 * 재고기반 생산계획 리포지토리 엔티티 IF
 */
public interface StockBasedPlanRepository extends GenericRepository<StockBasedPlan> {
    @Override
    void save(StockBasedPlan entity);

    @Override
    List<StockBasedPlan> findAll();
}
