package com.erp.system.logistics.repository.basic_information_registration.product_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.basic_information_registration.product_registration.ProductGroup;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductGroupRepository;

@Component
public class ProductGroupRepositoryImpl extends GenericRepositoryImpl<ProductGroup> implements ProductGroupRepository {
    public ProductGroupRepositoryImpl() {
        super(ProductGroup.class);
    }
}
