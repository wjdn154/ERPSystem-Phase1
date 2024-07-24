package com.erp.system.production.repository.work_order_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_order_management.RequestBasedWorkOrder;
import com.erp.system.production.repository.work_order_management.RequestBasedWorkOrderRepository;

@Component
public class RequestBasedWorkOrderRepositoryImpl extends GenericRepositoryImpl<RequestBasedWorkOrder> implements RequestBasedWorkOrderRepository {
    private RequestBasedWorkOrderRepositoryImpl() { super(RequestBasedWorkOrder.class);}
}
