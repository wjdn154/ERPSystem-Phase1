package com.erp.system.financial.service.basic_information_management;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;

import java.util.Collection;
import java.util.Optional;

public interface PurchaseSalesSlipService {

    void saveEntry(Entry entry);
    void savePurchaseSalesSlip(PurchaseSalesSlip purchaseSalesSlip);
    void saveVatType(VatType vatType);

    Optional<Entry> findEntryById(String id);
    Optional<Entry> findEntryByCode(String code);
    Optional<PurchaseSalesSlip> findPurchaseSalesSlipById(String id);
    Optional<PurchaseSalesSlip> findPurchaseSalesSlipByCode(String code);
    Optional<VatType> findVatTypeById(String id);
    Optional<VatType> findVatTypeByCode(String code);

    Collection<Entry> findAllEntries();
    Collection<PurchaseSalesSlip> findAllPurchaseSalesSlip();
    Collection<VatType> findAllVatTypes();
}