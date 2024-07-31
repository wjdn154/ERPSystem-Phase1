package com.erp.system.production.repository.production_standard_information.routing_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.routing_management.Routing;
import com.erp.system.production.repository.production_standard_information.routing_management.RoutingRepository;

@Component
public class RoutingRepositoryImpl extends GenericRepositoryImpl<Routing> implements RoutingRepository {
    private RoutingRepositoryImpl() { super(Routing.class); }
}
