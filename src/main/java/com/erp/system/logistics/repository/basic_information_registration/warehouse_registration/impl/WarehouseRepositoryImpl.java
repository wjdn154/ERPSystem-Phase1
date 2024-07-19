package com.erp.system.logistics.repository.basic_information_registration.warehouse_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.basic_information_registration.warehouse_registration.Warehouse;
import com.erp.system.logistics.repository.basic_information_registration.warehouse_registration.WarehouseRepository;

@Component
public class WarehouseRepositoryImpl extends GenericRepositoryImpl<Warehouse> implements WarehouseRepository {
    public WarehouseRepositoryImpl() {
        super(Warehouse.class);
    }
}
