package com.erp.system.production.repository.production_standard_information.routing_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.routing_management.RoutingStep;

import java.util.List;

/**
 * Routing 각 단계 정보 리포지토리 IF
 */

public interface RoutingStepRepository extends GenericRepository<RoutingStep> {
    @Override
    void save(RoutingStep entity);

    @Override
    List<RoutingStep> findAll();
}
