package com.erp.system.production.repository.work_order_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_order_management.WorkcenterOrder;

import java.util.List;

/**
 * 작업장별 작업지시 리포지토리 IF
 */

public interface WorkcenterOrderRepository extends GenericRepository<WorkcenterOrder> {
    @Override
    void save(WorkcenterOrder entity);

    @Override
    List<WorkcenterOrder> findAll();
}
