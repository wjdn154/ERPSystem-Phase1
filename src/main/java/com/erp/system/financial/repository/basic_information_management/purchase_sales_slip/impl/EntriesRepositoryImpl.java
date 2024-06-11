package com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.impl;

import com.erp.system.common.generic_repository.GenericRepositoryImpl;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.Entries;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntriesRepository;

public class EntriesRepositoryImpl extends GenericRepositoryImpl<Entries> implements EntriesRepository {
    private static volatile EntriesRepositoryImpl instance; // 싱글톤 인스턴스를 저장할 변수
    // volatile : 다중 스레드 환경에서 올바르게 작동하도록 합

    /**
     * 싱글톤 인스턴스 반환.
     * @return EntriesRepositoryImpl의 인스턴스
     */
    public static EntriesRepository getInstance() {
        if (instance == null) { // 첫 번째 검사
            synchronized (EntriesRepositoryImpl.class) { // 락
                if (instance == null) { // 두 번째 검사
                    instance = new EntriesRepositoryImpl(); // 인스턴스가 없으면 새로 생성
                }
            }
        }
        return instance; // 인스턴스 반환
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현.
     */
    private EntriesRepositoryImpl() {
        super(Entries.class); // 부모 클래스의 생성자를 호출
    }
    
}