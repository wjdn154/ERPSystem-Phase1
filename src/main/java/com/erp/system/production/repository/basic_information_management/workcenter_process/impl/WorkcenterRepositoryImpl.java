package com.erp.system.production.repository.basic_information_management.workcenter_process.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.basic_information_management.workcenter_process.Workcenter;
import com.erp.system.production.repository.basic_information_management.workcenter_process.WorkcenterRepository;

@Component
public class WorkcenterRepositoryImpl extends GenericRepositoryImpl<Workcenter> implements WorkcenterRepository {
    private WorkcenterRepositoryImpl() { super(Workcenter.class); }
}
