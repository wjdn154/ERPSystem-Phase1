package com.erp.system.production.repository.production_plan_management.production_plan;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_plan_management.production_plan.AnnualProductionPlan;

/**
 * AnnualProductionPlan 엔티티에 대한 리포지토리 인터페이스.
 */
public interface AnnualProductionPlanRepository extends GenericRepository<AnnualProductionPlan> {
    @Override
    void save(AnnualProductionPlan entity);
}
