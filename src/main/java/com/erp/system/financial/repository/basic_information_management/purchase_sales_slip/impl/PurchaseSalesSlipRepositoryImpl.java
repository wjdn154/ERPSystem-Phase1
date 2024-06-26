package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;

@Component
public class PurchaseSalesSlipRepositoryImpl extends GenericRepositoryImpl<PurchaseSalesSlip> implements PurchaseSalesSlipRepository {
    private PurchaseSalesSlipRepositoryImpl() {
        super(PurchaseSalesSlip.class);
    }
}