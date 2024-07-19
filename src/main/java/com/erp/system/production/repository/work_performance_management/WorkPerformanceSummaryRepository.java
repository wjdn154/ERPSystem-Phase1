package com.erp.system.production.repository.work_performance_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_performance_management.WorkPerformanceSummary;

import java.util.List;

/**
 * 작업실적현황 엔티티 리포지토리 IF
 */

public interface WorkPerformanceSummaryRepository extends GenericRepository<WorkPerformanceSummary> {
    @Override
    void save(WorkPerformanceSummary entity);

    @Override
    List<WorkPerformanceSummary> findAll();
}
