package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;

import java.util.HashMap;
import java.util.Map;

public class EntriesRepositoryImpl extends GenericRepositoryImpl<Entries> implements EntriesRepository {
    private Map<Integer, Entries> entriesDatabase = new HashMap<>();
    private static volatile EntriesRepositoryImpl instance;

    public static synchronized EntriesRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new EntriesRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private EntriesRepositoryImpl() {
        super(Entries.class);
    }

    
}