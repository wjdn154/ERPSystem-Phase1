package com.erp.system.production.repository.work_order_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_order_management.WorkcenterOrder;
import com.erp.system.production.repository.work_order_management.WorkcenterOrderRepository;

@Component
public class WorkcenterOrderRepositoryImpl extends GenericRepositoryImpl<WorkcenterOrder> implements WorkcenterOrderRepository {
    private WorkcenterOrderRepositoryImpl() { super(WorkcenterOrder.class);}
}
