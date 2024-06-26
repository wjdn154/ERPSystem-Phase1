package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypeRepository;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;

import java.util.Collection;
import java.util.Optional;

@Component
public class PurchaseSalesSlipController {
    private final PurchaseSalesSlipService purchaseSalesSlipService;
    private final EntryRepository entryRepository;
    private final PurchaseSalesSlipRepository purchaseSalesSlipRepository;
    private final VatTypeRepository vatTypeRepository;

    public PurchaseSalesSlipController(PurchaseSalesSlipService purchaseSalesSlipService,
                                       EntryRepository entryRepository,
                                       PurchaseSalesSlipRepository purchaseSalesSlipRepository,
                                       VatTypeRepository vatTypeRepository) {
        this.purchaseSalesSlipService = purchaseSalesSlipService;
        this.entryRepository = entryRepository;
        this.purchaseSalesSlipRepository = purchaseSalesSlipRepository;
        this.vatTypeRepository = vatTypeRepository;
    }

    /**
     * 엔트리를 저장함
     * @param entry 저장할 엔트리
     */
    public void saveEntry(Entry entry) {
        entryRepository.save(entry);
    }

    /**
     * 매입매출전표를 저장함
     * @param purchaseSalesSlip 저장할 매입매출전표
     */
    public void savePurchaseSalesSlip(PurchaseSalesSlip purchaseSalesSlip) {
        purchaseSalesSlipRepository.save(purchaseSalesSlip);
    }

    /**
     * 부가세 유형을 저장함
     * @param vatType 저장할 부가세 유형
     */
    public void saveVatType(VatType vatType) {
        vatTypeRepository.save(vatType);
    }

    /**
     * ID로 엔트리를 조회함
     * @param id 엔트리의 ID
     * @return 조회된 엔트리를 Optional로 반환
     */
    public Optional<Entry> findEntryById(String id) {
        return entryRepository.findById(id);
    }

    /**
     * ID로 매입매출전표를 조회함
     * @param id 매입매출전표의 ID
     * @return 조회된 매입매출전표를 Optional로 반환
     */
    public Optional<PurchaseSalesSlip> findPurchaseSalesSlipById(String id) {
        return purchaseSalesSlipRepository.findById(id);
    }

    /**
     * ID로 부가세 유형을 조회함
     * @param id 부가세 유형의 ID
     * @return 조회된 부가세 유형을 Optional로 반환
     */
    public Optional<VatType> findVatTypeById(String id) {
        return vatTypeRepository.findById(id);
    }


    /**
     * 모든 엔트리를 조회함
     * @return 저장된 모든 엔트리의 컬렉션
     */
    public Collection<Entry> findAllEntries() {
        return entryRepository.findAll();
    }

    /**
     * 모든 매입매출전표를 조회함
     * @return 저장된 모든 매입매출전표의 컬렉션
     */
    public Collection<PurchaseSalesSlip> findAllPurchaseSalesSlip() {
        return purchaseSalesSlipRepository.findAll();
    }

    /**
     * 모든 부가세 유형을 조회함
     * @return 저장된 모든 부가세 유형의 컬렉션
     */
    public Collection<VatType> findAllVatTypes() {
        return vatTypeRepository.findAll();
    }
}