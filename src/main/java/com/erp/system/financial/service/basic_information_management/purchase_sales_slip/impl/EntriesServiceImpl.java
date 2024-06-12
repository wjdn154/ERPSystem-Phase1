package com.erp.system.financial.service.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl.EntriesRepositoryImpl;
import com.erp.system.financial.service.basic_information_management.purchase_sales_slip.EntriesService;

import java.util.Collection;
import java.util.Optional;

public class EntriesServiceImpl implements EntriesService {

    private final EntriesRepository entriesRepository;

    public EntriesServiceImpl(EntriesRepository entriesRepository) {
        this.entriesRepository = entriesRepository;
    }

    /**
     * 엔트리 저장
     * @param entry 저장할 엔트리
     */
    public void saveEntry(Entries entry) {
        entriesRepository.save(entry);
    }

    /**
     * ID 또는 코드로 엔트리 검색
     * @param id 엔트리의 ID
     * @param code 엔트리의 코드
     * @return 검색된 엔트리, 없으면 Optional.empty()
     */
    public Optional<Entries> findByIdOrCode(String id, String code) {
        return entriesRepository.findByIdOrCode(id, code);
    }

    /**
     * 엔트리 업데이트
     * @param entry 업데이트할 엔트리
     */
    public void updateEntry(Entries entry) {
        entriesRepository.update(entry);
    }

    /**
     * 엔트리 삭제
     * @param id 삭제할 엔트리의 ID
     */
    public void deleteEntry(String id) {
        entriesRepository.delete(id);
    }

    /**
     * 모든 엔트리 검색
     * @return 저장된 모든 엔트리의 컬렉션
     */
    public Collection<Entries> findAllEntries() {
        return entriesRepository.findAll();
    }
}