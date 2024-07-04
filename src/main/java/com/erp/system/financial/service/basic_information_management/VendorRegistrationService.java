package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.dto.PurchaseSalesSlipRegistrationDto;
import com.erp.system.financial.model.dto.VendorRegistrationDto;

public interface VendorRegistrationService {
    void registerVendor(VendorRegistrationDto dto);
}