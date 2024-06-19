package com.erp.system.production.repository.master_data_management.design_change.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.master_data_management.design_change.DesignChange;
import com.erp.system.production.repository.master_data_management.design_change.DesignChangeRepository;

public class DesignChangeRepositoryImpl extends GenericRepositoryImpl<DesignChange> implements DesignChangeRepository {
    private static volatile DesignChangeRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return DesignChangeRepositoryImpl 인스턴스
     */

    public static synchronized DesignChangeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DesignChangeRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private DesignChangeRepositoryImpl() { super(DesignChange.class); }
}
