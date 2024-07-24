package com.erp.system.production.repository.work_order_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_order_management.StockBasedPlan;
import com.erp.system.production.repository.work_order_management.StockBasedPlanRepository;

@Component
public class StockBasedPlanRepositoryImpl extends GenericRepositoryImpl<StockBasedPlan> implements StockBasedPlanRepository {
    private StockBasedPlanRepositoryImpl() { super(StockBasedPlan.class); }
}
