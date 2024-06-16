package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.annotation.Priority;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entry;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;

@Component
@Priority(1)
public class EntryRepositoryImpl extends GenericRepositoryImpl<Entry> implements EntryRepository {
    private static volatile EntryRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return EntriesRepositoryImpl 인스턴스
     */
    public static synchronized EntryRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new EntryRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private EntryRepositoryImpl() {
        super(Entry.class);
    }
}