package com.erp.system.production.repository.master_data_management.routing;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.master_data_management.routing.Routing;

/**
 * Routing 엔티티에 대한 리포지토리 인터페이스.
 */
public interface RoutingRepository extends GenericRepository<Routing> {
    @Override
    void save(Routing entity);
}
