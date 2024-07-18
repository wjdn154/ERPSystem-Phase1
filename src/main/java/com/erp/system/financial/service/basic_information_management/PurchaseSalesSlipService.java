package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.dto.PurchaseSalesSlipRegistrationDto;

public interface PurchaseSalesSlipService {
    void registerPurchaseSalesSlip(PurchaseSalesSlipRegistrationDto purchaseSalesSlipRegistrationDto);
}