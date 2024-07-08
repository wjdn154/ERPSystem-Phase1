package com.erp.system.production.repository.production_standard_information.routing_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.routing_management.RoutingStep;
import com.erp.system.production.repository.production_standard_information.routing_management.RoutingStepRepository;

@Component
public class RoutingStepRepositoryImpl extends GenericRepositoryImpl<RoutingStep> implements RoutingStepRepository {
    private RoutingStepRepositoryImpl() { super(RoutingStep.class); }
}
