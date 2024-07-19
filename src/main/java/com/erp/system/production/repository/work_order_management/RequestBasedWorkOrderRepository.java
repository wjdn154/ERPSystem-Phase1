package com.erp.system.production.repository.work_order_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_order_management.RequestBasedPlan;
import com.erp.system.production.model.work_order_management.RequestBasedWorkOrder;

import java.util.List;

/**
 * 생산요청기반 작업지시 엔티티 리포지터리 IF
 */

public interface RequestBasedWorkOrderRepository extends GenericRepository<RequestBasedWorkOrder> {
    @Override
    void save(RequestBasedWorkOrder entity);

    @Override
    List<RequestBasedWorkOrder> findAll();
}
