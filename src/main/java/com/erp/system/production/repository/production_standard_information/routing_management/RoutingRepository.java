package com.erp.system.production.repository.production_standard_information.routing_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.routing_management.Routing;

import java.util.List;

public interface RoutingRepository extends GenericRepository<Routing> {
    @Override
    void save(Routing entity);

    @Override
    List<Routing> findAll();
}
