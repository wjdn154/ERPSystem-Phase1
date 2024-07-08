package com.erp.system.production.repository.work_performance_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_performance_management.ReportMapping;
import com.erp.system.production.repository.work_performance_management.ReportMappingRepository;

@Component
public class ReportMappingRepositoryImpl extends GenericRepositoryImpl<ReportMapping> implements ReportMappingRepository {
    private ReportMappingRepositoryImpl() { super(ReportMapping.class);}
}
