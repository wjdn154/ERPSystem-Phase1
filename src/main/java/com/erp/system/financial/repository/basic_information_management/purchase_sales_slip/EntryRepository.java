package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;

import java.util.List;

/**
 * 분개 엔티티에 대한 리포지토리 인터페이스.
 */
public interface EntryRepository extends GenericRepository<Entry> {
    @Override
    void save(Entry entity);

    @Override
    List<Entry> findAll();
}