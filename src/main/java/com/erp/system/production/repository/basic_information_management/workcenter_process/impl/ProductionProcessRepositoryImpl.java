package com.erp.system.production.repository.basic_information_management.workcenter_process.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.basic_information_management.workcenter_process.ProductionProcess;
import com.erp.system.production.repository.basic_information_management.workcenter_process.ProductionProcessRepository;

@Component
public class ProductionProcessRepositoryImpl extends GenericRepositoryImpl<ProductionProcess> implements ProductionProcessRepository {
    private ProductionProcessRepositoryImpl() { super(ProductionProcess.class);}
}