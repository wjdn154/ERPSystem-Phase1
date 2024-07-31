package com.erp.system.production.repository.basic_information_management.production_resources.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.basic_information_management.production_resources.ProductionResource;

@Component
public class ProductionResourceRepositoryImpl extends GenericRepositoryImpl<ProductionResource> {
    private ProductionResourceRepositoryImpl() { super(ProductionResource.class); }
}
