package com.erp.system.production.repository.work_performance_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_performance_management.DailyReport;

import java.util.List;

/**
 * 생산일보 엔티티 리포지토리 IF
 */

public interface DailyReportRepository extends GenericRepository<DailyReport> {
    @Override
    void save(DailyReport entity);

    @Override
    List<DailyReport> findAll();
}
