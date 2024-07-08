package com.erp.system.production.repository.work_performance_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_performance_management.MonthlyReport;
import com.erp.system.production.repository.work_performance_management.MonthlyReportRepository;

@Component
public class MonthlyReportRepositoryImpl extends GenericRepositoryImpl<MonthlyReport> implements MonthlyReportRepository {
    private MonthlyReportRepositoryImpl() { super(MonthlyReport.class);}
}
