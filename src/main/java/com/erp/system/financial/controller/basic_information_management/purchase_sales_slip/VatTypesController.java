package com.erp.system.financial.controller.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.VatTypes;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.VatTypesService;

import java.util.Collection;

public class VatTypesController {
    private static VatTypesController instance; // 싱글톤 인스턴스를 저장할 변수
    private VatTypesService vatTypesService; // EntriesService 인스턴스

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private VatTypesController() {
        vatTypesService = VatTypesService.getInstance();
    }

    /**
     * 싱글턴 인스턴스 반환
     * @return 현재 인스턴스
     */
    public static synchronized VatTypesController getInstance() {
        if (instance == null) {
            instance = new VatTypesController();
        }
        return instance;
    }

    /**
     * VAT 유형 저장
     * @param vatTypes 저장할 VAT 유형 객체
     */
    public void saveEntry(VatTypes vatTypes) {
        vatTypesService.saveEntry(vatTypes);
    }

    /**
     * ID 또는 코드로 VAT 유형 검색
     * @param idOrCode 검색할 VAT 유형의 ID 또는 코드
     * @return 검색된 VAT 유형
     */
    public VatTypes getEntryByIdOrCode(String idOrCode) {
        return vatTypesService.getEntryByIdOrCode(idOrCode);
    }

    /**
     * 모든 VAT 유형 반환
     * @return 모든 VAT 유형을 포함한 컬렉션
     */
    public Collection<VatTypes> allEntries() {
        return vatTypesService.getAllEntries();
    }
}