package com.erp.system.financial.controller.basic_information_management.purchase_sales_slip;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class EntriesController {
    private static EntriesController instance; // 싱글톤 인스턴스를 저장할 변수
    private EntriesService entriesService; // EntriesService 인스턴스

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private EntriesController() {
        entriesService = EntriesService.getInstance(); // EntriesService 인스턴스를 가져옴
    }

    /**
     * 싱글톤 인스턴스를 반환함.
     * @return 현재 인스턴스
     */
    public static synchronized EntriesController getInstance() {
        if (instance == null) {
            instance = new EntriesController(); // 인스턴스가 없으면 새로 생성
        }
        return instance; // 인스턴스 반환
    }

    /**
     * 엔트리를 저장함.
     * @param entry 저장할 엔트리
     */
    public void saveEntry(Entries entry) {
        entriesService.saveEntry(entry); // EntriesService를 통해 엔트리 저장
    }

    /**
     * ID 또는 코드로 엔트리를 조회함.
     * @param id 엔트리의 ID
     * @param code 엔트리의 코드
     * @return 조회된 엔트리를 Optional로 반환
     */
    public Optional<Entries> getEntryByIdOrCode(String id, String code) {
        return entriesService.findByIdOrCode(id, code); // EntriesService를 통해 엔트리 조회
    }

    /**
     * 모든 엔트리를 조회함.
     * @return 저장된 모든 엔트리의 컬렉션
     */
    public Collection<Entries> allEntries() {
        return entriesService.findAllEntries(); // EntriesService를 통해 모든 엔트리 조회
    }
}