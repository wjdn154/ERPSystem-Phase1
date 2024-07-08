package com.erp.system.production.repository.work_order_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_order_management.RequestBasedPlan;
import com.erp.system.production.repository.work_order_management.RequestBasedPlanRepository;

@Component
public class RequestBasedPlanRepositoryImpl extends GenericRepositoryImpl<RequestBasedPlan> implements RequestBasedPlanRepository {
    private RequestBasedPlanRepositoryImpl() {super(RequestBasedPlan.class);}
}
