package com.erp.system.production.repository.material_inventory.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.material_inventory.Unit;
import com.erp.system.production.repository.material_inventory.UnitRepository;

public class UnitRepositoryImpl extends GenericRepositoryImpl<Unit> implements UnitRepository {
    private static volatile UnitRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return UnitRepositoryImpl 인스턴스
     */

    public static synchronized UnitRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UnitRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private UnitRepositoryImpl() { super(Unit.class); }
}
