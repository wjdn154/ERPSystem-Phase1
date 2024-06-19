package com.erp.system.production.repository.material_inventory.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.material_inventory.Material;
import com.erp.system.production.repository.material_inventory.MaterialRepository;

public class MaterialRepositoryImpl extends GenericRepositoryImpl<Material> implements MaterialRepository {
    private static volatile MaterialRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return MaterialRepositoryImpl 인스턴스
     */

    public static synchronized MaterialRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new MaterialRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private MaterialRepositoryImpl() { super(Material.class); }
}
