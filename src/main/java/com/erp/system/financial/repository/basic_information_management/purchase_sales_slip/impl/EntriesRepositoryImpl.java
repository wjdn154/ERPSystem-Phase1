package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;

public class EntriesRepositoryImpl extends GenericRepositoryImpl<Entry> implements EntriesRepository {
    private static volatile EntriesRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return EntriesRepositoryImpl 인스턴스
     */
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
        super(Entry.class);
    }
}