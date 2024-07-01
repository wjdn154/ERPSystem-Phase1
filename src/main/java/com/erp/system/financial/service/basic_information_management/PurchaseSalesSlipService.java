package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.model.dto.CompanyRegistrationDto;
import com.erp.system.financial.model.dto.PurchaseSalesSlipDto;

import java.util.Collection;
import java.util.Optional;

public interface PurchaseSalesSlipService {
    void registerPurchaseSalesSlip(PurchaseSalesSlipDto purchaseSalesSlipDto);
}