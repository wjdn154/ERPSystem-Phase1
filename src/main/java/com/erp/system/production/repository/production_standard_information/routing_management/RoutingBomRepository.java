package com.erp.system.production.repository.production_standard_information.routing_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.routing_management.RoutingBom;

import java.util.List;

/**
 * Routing 자재명세서 연결 테이블 리포지토리 IF
 */

public interface RoutingBomRepository extends GenericRepository<RoutingBom> {
    @Override
    void save(RoutingBom entity);

    @Override
    List<RoutingBom> findAll();
}
