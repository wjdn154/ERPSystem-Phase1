package com.erp.system.production.repository.work_order_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_order_management.RequestBasedPlan;

import java.util.List;

/**
 * 생산요청기반 생산계획 리포지토리 엔티티 IF
 */
public interface RequestBasedPlanRepository extends GenericRepository<RequestBasedPlan> {
    @Override
    void save(RequestBasedPlan entity);

    @Override
    List<RequestBasedPlan> findAll();
}
