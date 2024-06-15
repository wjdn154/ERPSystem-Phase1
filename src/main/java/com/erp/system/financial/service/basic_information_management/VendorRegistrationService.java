package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;

import java.util.Collection;
import java.util.Optional;

public interface VendorRegistrationService {

    void saveVendor(Vendor vendor);
    void saveVendorType(VendorType vendorType);

    Optional<Vendor> findVendorById(String id);
    Optional<Vendor> findVendorByCode(String code);
    Optional<VendorType> findVendorTypeById(String id);
    Optional<VendorType> findVendorTypeByCode(String code);

    Collection<Vendor> findAllVendors();
    Collection<VendorType> findAllVendorTypes();
}