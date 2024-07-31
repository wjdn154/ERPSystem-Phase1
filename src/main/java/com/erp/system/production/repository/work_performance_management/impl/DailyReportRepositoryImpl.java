package com.erp.system.production.repository.work_performance_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_performance_management.DailyReport;
import com.erp.system.production.repository.work_performance_management.DailyReportRepository;

@Component
public class DailyReportRepositoryImpl extends GenericRepositoryImpl<DailyReport> implements DailyReportRepository {
    private DailyReportRepositoryImpl() { super(DailyReport.class);}
}
