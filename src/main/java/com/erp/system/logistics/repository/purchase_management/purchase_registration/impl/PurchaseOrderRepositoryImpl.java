package com.erp.system.logistics.repository.purchase_management.purchase_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.purchase_management.purchase_registration.PurchaseOrder;
import com.erp.system.logistics.repository.purchase_management.purchase_registration.PurchaseOrderRepository;

@Component
public class PurchaseOrderRepositoryImpl extends GenericRepositoryImpl<PurchaseOrder> implements PurchaseOrderRepository {
    public PurchaseOrderRepositoryImpl() {
        super(PurchaseOrder.class);
    }
}
