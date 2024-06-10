package com.erp.system.financial.service.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatTypes;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.VatTypesRepository;

import java.util.Collection;

public class VatTypesService {
    private static VatTypesService instance; // 싱글톤 인스턴스를 저장할 변수
    private VatTypesRepository vatTypesRepository; // VAT 유형 리포지토리 참조

    // 생성자: VAT 유형 저장소 인스턴스화
    private VatTypesService() {
        vatTypesRepository = VatTypesRepository.getInstance();
    }

    /**
     * 싱글턴 인스턴스 반환
     * @return 현재 인스턴스
     */
    public static synchronized VatTypesService getInstance() {
        if (instance == null) {
            instance = new VatTypesService();
        }
        return instance;
    }

    /**
     * VAT 유형 저장
     * @param vatTypes 저장할 VAT 유형 객체
     */
    public void saveEntry(VatTypes vatTypes) {
        vatTypesRepository.save(vatTypes);
    }

    /**
     * ID 또는 코드로 VAT 유형 검색
     * @param idOrCode 검색할 VAT 유형의 ID 또는 코드
     * @return 검색된 VAT 유형
     */
    public VatTypes getEntryByIdOrCode(String idOrCode) {
        return vatTypesRepository.findByIdOrCode(idOrCode);
    }

    /**
     * VAT 유형 정보 업데이트
     * @param vatTypes 업데이트할 VAT 유형 객체
     */
    public void updateEntry(VatTypes vatTypes) {
        vatTypesRepository.update(vatTypes);
    }

    /**
     * VAT 유형 삭제
     * @param vatTypes 삭제할 VAT 유형 객체
     */
    public void deleteEntry(VatTypes vatTypes) {
        vatTypesRepository.delete(vatTypes);
    }

    /**
     * 모든 VAT 유형 반환
     * @return 모든 VAT 유형을 포함한 컬렉션
     */
    public Collection<VatTypes> getAllEntries() {
        return vatTypesRepository.findAll();
    }
}