package com.erp.system.production.repository.work_order_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.work_order_management.ProductionRequest;
import com.erp.system.production.repository.work_order_management.ProductionRequestRepository;

@Component
public class ProductionRequestRepositoryImpl extends GenericRepositoryImpl<ProductionRequest> implements ProductionRequestRepository {
    private ProductionRequestRepositoryImpl() { super(ProductionRequest.class);}
}
