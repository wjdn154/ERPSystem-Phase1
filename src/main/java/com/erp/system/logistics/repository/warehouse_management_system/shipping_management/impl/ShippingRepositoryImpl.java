package com.erp.system.logistics.repository.warehouse_management_system.shipping_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.warehouse_management_system.shipping_management.Shipping;
import com.erp.system.logistics.repository.warehouse_management_system.shipping_management.ShippingRepository;

@Component
public class ShippingRepositoryImpl extends GenericRepositoryImpl<Shipping> implements ShippingRepository {
    public ShippingRepositoryImpl() {
        super(Shipping.class);
    }
}
