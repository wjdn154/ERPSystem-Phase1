package com.erp.system.production.repository.process_management.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.repository.process_management.ProcessRepository;

public class ProcessRepositoryImpl extends GenericRepositoryImpl<Process> implements ProcessRepository {
    private static volatile ProcessRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return ProcessRepositoryImpl 인스턴스
     */

    public static synchronized ProcessRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProcessRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private ProcessRepositoryImpl() { super(Process.class); }
}
