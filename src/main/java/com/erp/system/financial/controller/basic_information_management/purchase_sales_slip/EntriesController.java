package com.erp.system.financial.controller.basic_information_management.purchase_sales_slip;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.impl.EntriesServiceImpl;

import java.util.Collection;
import java.util.Optional;

public class EntriesController {

    private final EntriesServiceImpl entriesService;

    public EntriesController(EntriesServiceImpl entriesService) {
        this.entriesService = entriesService;
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