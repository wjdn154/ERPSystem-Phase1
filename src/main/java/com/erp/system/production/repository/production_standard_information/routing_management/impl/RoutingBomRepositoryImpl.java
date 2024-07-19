package com.erp.system.production.repository.production_standard_information.routing_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.routing_management.RoutingBom;
import com.erp.system.production.repository.production_standard_information.routing_management.RoutingBomRepository;

@Component
public class RoutingBomRepositoryImpl extends GenericRepositoryImpl<RoutingBom> implements RoutingBomRepository {
    private RoutingBomRepositoryImpl() { super(RoutingBom.class); }
}
