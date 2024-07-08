package com.erp.system.production.repository.work_performance_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_performance_management.WorkCenterPerformance;
import com.erp.system.production.repository.work_performance_management.WorkCenterPerformanceRepository;

@Component
public class WorkCenterPerformanceRepositoryImpl extends GenericRepositoryImpl<WorkCenterPerformance> implements WorkCenterPerformanceRepository {
    private WorkCenterPerformanceRepositoryImpl() { super(WorkCenterPerformance.class);}
}
