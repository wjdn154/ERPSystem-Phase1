package com.erp.system.production.repository.work_performance_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_performance_management.MonthlyReport;

import java.util.List;

/**
 * 생산월보 엔티티 리포지토리 IF
 */

public interface MonthlyReportRepository extends GenericRepository<MonthlyReport> {
    @Override
    void save(MonthlyReport entity);

    @Override
    List<MonthlyReport> findAll();
}
