package com.erp.system.logistics.repository.purchase_management.purchase_registration.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.logistics.model.purchase_management.purchase_registration.PurchaseRequest;
import com.erp.system.logistics.repository.purchase_management.purchase_registration.PurchaseRequestRepository;

@Component
public class PurchaseRequestRepositoryImpl extends GenericRepositoryImpl<PurchaseRequest> implements PurchaseRequestRepository {
    public PurchaseRequestRepositoryImpl() {
        super(PurchaseRequest.class);
    }
}
