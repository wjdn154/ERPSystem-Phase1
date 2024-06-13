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
    Optional<Entry> findPurchaseSalesSlipEntryByIdOrCode(String id, String code);
    Optional<PurchaseSalesSlip> findByIdOrCode(String id, String code);
    Optional<VatType> findVatTypeByIdOrCode(String id, String code);
    void updateEntry(Entry entry);
    void updatePurchaseSalesSlip(PurchaseSalesSlip purchaseSalesSlip);
    void updateVatType(VatType vatType);
    void deleteEntry(String id);
    void deletePurchaseSalesSlip(String id);
    void deleteVatType(String id);
    Collection<Entry> findAllEntries();
    Collection<PurchaseSalesSlip> findAllPurchaseSalesSlip();
    Collection<VatType> findAllVatTypes();
}