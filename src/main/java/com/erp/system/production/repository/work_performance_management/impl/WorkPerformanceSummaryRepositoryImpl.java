package com.erp.system.production.repository.work_performance_management.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_performance_management.WorkPerformanceSummary;
import com.erp.system.production.repository.work_performance_management.WorkPerformanceSummaryRepository;

public class WorkPerformanceSummaryRepositoryImpl extends GenericRepositoryImpl<WorkPerformanceSummary> implements WorkPerformanceSummaryRepository {
    private WorkPerformanceSummaryRepositoryImpl() { super(WorkPerformanceSummary.class);}
}
