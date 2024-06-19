package com.erp.system.production.repository.production_plan_management.material_requirement_planning;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_plan_management.material_requirement_planning.Mrp;

/**
 * Mrp 엔티티에 대한 리포지토리 인터페이스.
 */
public interface MrpRepository extends GenericRepository<Mrp> {
    @Override
    void save(Mrp entity);
}
