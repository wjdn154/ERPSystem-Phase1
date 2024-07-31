package com.erp.system.logistics.repository.basic_information_registration.product_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.basic_information_registration.product_registration.Product;
import com.erp.system.logistics.repository.basic_information_registration.product_registration.ProductRepository;
@Component
public class ProductRepositoryImpl extends GenericRepositoryImpl<Product> implements ProductRepository {
    public ProductRepositoryImpl() {
        super(Product.class);
    }
}
