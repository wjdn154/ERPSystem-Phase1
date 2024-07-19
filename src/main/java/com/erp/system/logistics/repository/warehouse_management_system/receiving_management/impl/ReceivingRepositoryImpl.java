package com.erp.system.logistics.repository.warehouse_management_system.receiving_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.warehouse_management_system.receiving_management.Receiving;
import com.erp.system.logistics.repository.warehouse_management_system.receiving_management.ReceivingRepository;

@Component
public class ReceivingRepositoryImpl extends GenericRepositoryImpl<Receiving> implements ReceivingRepository {
    public ReceivingRepositoryImpl() {
        super(Receiving.class);
    }
}
