package com.erp.system.production.repository.work_performance_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.work_performance_management.ReportMapping;

import java.util.List;

/**
 * 생산일보, 월보 매핑 리포지토리 인터페이스
 */

public interface ReportMappingRepository extends GenericRepository<ReportMapping> {
    @Override
    void save(ReportMapping entity);

    @Override
    List<ReportMapping> findAll();
}
