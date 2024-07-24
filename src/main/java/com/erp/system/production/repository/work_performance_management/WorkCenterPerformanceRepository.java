package com.erp.system.production.repository.work_performance_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_performance_management.WorkCenterPerformance;

import java.util.List;

/**
 * 작업장별 작업실적 엔티티 리포지토리 IF
 */

public interface WorkCenterPerformanceRepository extends GenericRepository<WorkCenterPerformance> {
    @Override
    void save(WorkCenterPerformance entity);

    @Override
    List<WorkCenterPerformance> findAll();
}
