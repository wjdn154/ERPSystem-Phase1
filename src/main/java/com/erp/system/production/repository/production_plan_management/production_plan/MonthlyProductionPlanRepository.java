package com.erp.system.production.repository.production_plan_management.production_plan;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_plan_management.production_plan.MonthlyProductionPlan;

/**
 * MonthlyProductionPlan 엔티티에 대한 리포지토리 인터페이스.
 */
public interface MonthlyProductionPlanRepository extends GenericRepository<MonthlyProductionPlan> {
    @Override
    void save(MonthlyProductionPlan entity);
}
