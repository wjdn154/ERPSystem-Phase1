package com.erp.system.production.repository.master_data_management.bom.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.master_data_management.bom.Bom;
import com.erp.system.production.repository.master_data_management.bom.BomRepository;

public class BomRepositoryImpl extends GenericRepositoryImpl<Bom> implements BomRepository {
    private static volatile BomRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return BomRepositoryImpl 인스턴스
     */

    public static synchronized BomRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BomRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private BomRepositoryImpl() { super(Bom.class); }
}
