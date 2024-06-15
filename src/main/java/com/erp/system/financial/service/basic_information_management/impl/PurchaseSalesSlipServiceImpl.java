package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
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
@Priority(2)
public class PurchaseSalesSlipServiceImpl implements PurchaseSalesSlipService {
    private final EntryRepository entriesRepository;
    private final PurchaseSalesSlipRepository purchaseSalesSlipRepository;
    private final VatTypeRepository vatTypesRepository;

    public PurchaseSalesSlipServiceImpl(EntryRepository entriesRepository,
                                        PurchaseSalesSlipRepository purchaseSalesSlipRepository,
                                        VatTypeRepository vatTypesRepository) {
        this.entriesRepository = entriesRepository;
        this.purchaseSalesSlipRepository = purchaseSalesSlipRepository;
        this.vatTypesRepository = vatTypesRepository;
    }

    /**
     * 분개 저장
     * @param entry 저장할 분개
     * @throws IllegalArgumentException null 입력 시 예외 발생
     */
    @Override
    public void saveEntry(Entry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("저장할 엔트리는 null일 수 없습니다.");
        }
        entriesRepository.save(entry);
    }

    /**
     * 매입매출전표 저장
     * @param purchaseSalesSlip 저장할 매입매출전표
     * @throws IllegalArgumentException null 입력 시 예외 발생
     */
    @Override
    public void savePurchaseSalesSlip(PurchaseSalesSlip purchaseSalesSlip) {
        if (purchaseSalesSlip == null) {
            throw new IllegalArgumentException("저장할 매입매출전표는 null일 수 없습니다.");
        }
        purchaseSalesSlipRepository.save(purchaseSalesSlip);
    }

    /**
     * 부가세 유형 저장
     * @param vatType 저장할 부가세 유형
     * @throws IllegalArgumentException null 입력 시 예외 발생
     */
    @Override
    public void saveVatType(VatType vatType) {
        if (vatType == null) {
            throw new IllegalArgumentException("저장할 부가세 유형은 null일 수 없습니다.");
        }
        vatTypesRepository.save(vatType);
    }

    /**
     * ID로 분개 검색
     * @param id   분개 ID
     * @return 검색된 분개, 없으면 Optional.empty()
     */
    @Override
    public Optional<Entry> findEntryById(String id) {
        return entriesRepository.findById(id);
    }

    /**
     * 코드로 분개 검색
     * @param code 분개 코드
     * @return 검색된 분개, 없으면 Optional.empty()
     */
    @Override
    public Optional<Entry> findEntryByCode(String code) {
        return entriesRepository.findByCode(code);
    }

    /**
     * ID로 매입매출전표 검색
     * @param id   매입매출전표의 ID
     * @return 검색된 매입매출전표, 없으면 Optional.empty()
     */
    @Override
    public Optional<PurchaseSalesSlip> findPurchaseSalesSlipById(String id) {
        return purchaseSalesSlipRepository.findById(id);
    }

    /**
     * 코드로 매입매출전표 검색
     * @param code 매입매출전표의 코드
     * @return 검색된 매입매출전표, 없으면 Optional.empty()
     */
    @Override
    public Optional<PurchaseSalesSlip> findPurchaseSalesSlipByCode(String code) {
        return purchaseSalesSlipRepository.findByCode(code);
    }

    /**
     * ID로 부가세 유형 검색
     * @param id   부가세 유형의 ID
     * @return 검색된 부가세 유형, 없으면 Optional.empty()
     */
    @Override
    public Optional<VatType> findVatTypeById(String id) {
        return vatTypesRepository.findById(id);
    }

    /**
     * 코드로 부가세 유형 검색
     * @param code 부가세 유형의 코드
     * @return 검색된 부가세 유형, 없으면 Optional.empty()
     */
    @Override
    public Optional<VatType> findVatTypeByCode(String code) {
        return vatTypesRepository.findByCode(code);
    }

    /**
     * 모든 분개 조회
     * @return 모든 분개 리스트
     */
    @Override
    public Collection<Entry> findAllEntries() {
        return entriesRepository.findAll();
    }

    /**
     * 모든 매입매출전표 조회
     * @return 모든 매입매출전표 리스트
     */
    @Override
    public Collection<PurchaseSalesSlip> findAllPurchaseSalesSlip() {
        return purchaseSalesSlipRepository.findAll();
    }

    /**
     * 모든 부가세 유형 조회
     * @return 모든 부가세 유형 리스트
     */
    @Override
    public Collection<VatType> findAllVatTypes() {
        return vatTypesRepository.findAll();
    }
}