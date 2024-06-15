package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class PurchaseSalesSlipController {
    private final PurchaseSalesSlipService purchaseSalesSlipService;

    public PurchaseSalesSlipController(PurchaseSalesSlipService purchaseSalesSlipService) {
        this.purchaseSalesSlipService = purchaseSalesSlipService;
    }

    /**
     * 엔트리를 저장함
     * @param entry 저장할 엔트리
     */
    public void saveEntry(Entry entry) {
        purchaseSalesSlipService.saveEntry(entry);
    }

    /**
     * 매입매출전표를 저장함
     * @param purchaseSalesSlip 저장할 매입매출전표
     */
    public void savePurchaseSalesSlip(PurchaseSalesSlip purchaseSalesSlip) {
        purchaseSalesSlipService.savePurchaseSalesSlip(purchaseSalesSlip);
    }

    /**
     * 부가세 유형을 저장함
     * @param vatType 저장할 부가세 유형
     */
    public void saveVatType(VatType vatType) {
        purchaseSalesSlipService.saveVatType(vatType);
    }

    /**
     * ID로 엔트리를 조회함
     * @param id 엔트리의 ID
     * @return 조회된 엔트리를 Optional로 반환
     */
    public Optional<Entry> findEntryById(String id) {
        return purchaseSalesSlipService.findEntryById(id);
    }

    /**
     * 코드로 엔트리를 조회함
     * @param code 엔트리의 코드
     * @return 조회된 엔트리를 Optional로 반환
     */
    public Optional<Entry> findEntryByCode(String code) {
        return purchaseSalesSlipService.findEntryByCode(code);
    }

    /**
     * ID로 매입매출전표를 조회함
     * @param id 매입매출전표의 ID
     * @return 조회된 매입매출전표를 Optional로 반환
     */
    public Optional<PurchaseSalesSlip> findPurchaseSalesSlipById(String id) {
        return purchaseSalesSlipService.findPurchaseSalesSlipById(id);
    }

    /**
     * 코드로 매입매출전표를 조회함
     * @param code 매입매출전표의 코드
     * @return 조회된 매입매출전표를 Optional로 반환
     */
    public Optional<PurchaseSalesSlip> findPurchaseSalesSlipByCode(String code) {
        return purchaseSalesSlipService.findPurchaseSalesSlipByCode(code);
    }

    /**
     * ID로 부가세 유형을 조회함
     * @param id 부가세 유형의 ID
     * @return 조회된 부가세 유형을 Optional로 반환
     */
    public Optional<VatType> findVatTypeById(String id) {
        return purchaseSalesSlipService.findVatTypeById(id);
    }

    /**
     * 코드로 부가세 유형을 조회함
     * @param code 부가세 유형의 코드
     * @return 조회된 부가세 유형을 Optional로 반환
     */
    public Optional<VatType> findVatTypeByCode(String code) {
        return purchaseSalesSlipService.findVatTypeByCode(code);
    }

    /**
     * 모든 엔트리를 조회함
     * @return 저장된 모든 엔트리의 컬렉션
     */
    public Collection<Entry> findAllEntries() {
        return purchaseSalesSlipService.findAllEntries();
    }

    /**
     * 모든 매입매출전표를 조회함
     * @return 저장된 모든 매입매출전표의 컬렉션
     */
    public Collection<PurchaseSalesSlip> findAllPurchaseSalesSlip() {
        return purchaseSalesSlipService.findAllPurchaseSalesSlip();
    }

    /**
     * 모든 부가세 유형을 조회함
     * @return 저장된 모든 부가세 유형의 컬렉션
     */
    public Collection<VatType> findAllVatTypes() {
        return purchaseSalesSlipService.findAllVatTypes();
    }
}