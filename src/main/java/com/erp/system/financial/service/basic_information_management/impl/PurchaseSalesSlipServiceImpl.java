package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatType;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.PurchaseSalesSlipRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypesRepository;
import com.erp.system.financial.service.basic_information_management.PurchaseSalesSlipService;

import java.util.Collection;
import java.util.Optional;

public class PurchaseSalesSlipServiceImpl implements PurchaseSalesSlipService {
    EntriesRepository entriesRepository;
    PurchaseSalesSlipRepository purchaseSalesSlipRepository;
    VatTypesRepository vatTypesRepository;

    /**
     * 생성자를 통한 의존성 주입
     *
     * @param entriesRepository           엔트리 관련 데이터 접근을 담당하는 리포지토리
     * @param purchaseSalesSlipRepository 매입매출전표 데이터 접근을 담당하는 리포지토리
     * @param vatTypesRepository          부가세 유형 데이터 접근을 담당하는 리포지토리
     */
    public PurchaseSalesSlipServiceImpl(EntriesRepository entriesRepository,
                                        PurchaseSalesSlipRepository purchaseSalesSlipRepository,
                                        VatTypesRepository vatTypesRepository) {
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
     * ID 또는 코드로 분개 검색
     * @param id   분개 ID
     * @param code 분개 코드
     * @return 검색된 분개, 없으면 Optional.empty()
     */
    @Override
    public Optional<Entry> findPurchaseSalesSlipEntryByIdOrCode(String id, String code) {
        return entriesRepository.findByIdOrCode(id, code);
    }

    /**
     * ID 또는 코드로 매입매출전표 검색
     * @param id   매입매출전표의 ID
     * @param code 매입매출전표의 코드
     * @return 검색된 매입매출전표, 없으면 Optional.empty()
     */
    @Override
    public Optional<PurchaseSalesSlip> findByIdOrCode(String id, String code) {
        return purchaseSalesSlipRepository.findByIdOrCode(id, code);
    }

    /**
     * ID 또는 코드로 부가세 유형 검색
     * @param id   부가세 유형의 ID
     * @param code 부가세 유형의 코드
     * @return 검색된 부가세 유형, 없으면 Optional.empty()
     */
    @Override
    public Optional<VatType> findVatTypeByIdOrCode(String id, String code) {
        return vatTypesRepository.findByIdOrCode(id, code);
    }

    /**
     * 엔트리를 업데이트함
     * @param entry 업데이트할 엔트리 객체
     * @throws IllegalArgumentException null 값이 입력된 경우
     */
    @Override
    public void updateEntry(Entry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("업데이트할 엔트리는 null일 수 없습니다.");
        }
        entriesRepository.update(entry);
    }

    /**
     * 매입매출전표를 업데이트함
     * @param purchaseSalesSlip 업데이트할 매입매출전표 객체
     * @throws IllegalArgumentException null 값이 입력된 경우
     */
    @Override
    public void updatePurchaseSalesSlip(PurchaseSalesSlip purchaseSalesSlip) {
        if (purchaseSalesSlip == null) {
            throw new IllegalArgumentException("업데이트할 매입매출전표는 null일 수 없습니다.");
        }
        purchaseSalesSlipRepository.update(purchaseSalesSlip);
    }

    /**
     * 부가세 유형을 업데이트함
     * @param vatType 업데이트할 부가세 유형 객체
     * @throws IllegalArgumentException null 값이 입력된 경우
     */
    @Override
    public void updateVatType(VatType vatType) {
        if (vatType == null) {
            throw new IllegalArgumentException("업데이트할 부가세 유형은 null일 수 없습니다.");
        }
        vatTypesRepository.update(vatType);
    }

    /**
     * 엔트리를 삭제함
     * @param id 삭제할 엔트리의 ID
     * @throws IllegalArgumentException null 값이 입력된 경우
     */
    @Override
    public void deleteEntry(String id) {
        if (id == null) {
            throw new IllegalArgumentException("삭제할 엔트리 ID는 null일 수 없습니다.");
        }
        entriesRepository.delete(id);
    }

    /**
     * 매입매출전표를 삭제함
     * @param id 삭제할 매입매출전표의 ID
     * @throws IllegalArgumentException null 값이 입력된 경우
     */
    @Override
    public void deletePurchaseSalesSlip(String id) {
        if (id == null) {
            throw new IllegalArgumentException("삭제할 매입매출전표 ID는 null일 수 없습니다.");
        }
        purchaseSalesSlipRepository.delete(id);
    }

    /**
     * 부가세 유형을 삭제함
     * @param id 삭제할 부가세 유형의 ID
     * @throws IllegalArgumentException null 값이 입력된 경우
     */
    @Override
    public void deleteVatType(String id) {
        if (id == null) {
            throw new IllegalArgumentException("삭제할 부가세 유형 ID는 null일 수 없습니다.");
        }
        vatTypesRepository.delete(id);
    }

    @Override
    public Collection<Entry> findAllEntries() {
        return null;
    }

    @Override
    public Collection<PurchaseSalesSlip> findAllPurchaseSalesSlip() {
        return null;
    }

    @Override
    public Collection<VatType> findAllVatTypes() {
        return null;
    }
}