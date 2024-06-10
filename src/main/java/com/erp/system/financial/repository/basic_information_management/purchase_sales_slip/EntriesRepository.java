package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Entries 엔티티에 대한 리포지토리 인터페이스.
 */
public interface EntriesRepository extends GenericRepository<Entries, String, String> {
    @Override
    void save(Entries entity);
}