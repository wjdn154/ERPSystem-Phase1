package com.erp.system.production.repository.material_inventory.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.material_inventory.MaterialInventory;
import com.erp.system.production.repository.material_inventory.MaterialInventoryRepository;

public class MaterialInventoryRepositoryImpl extends GenericRepositoryImpl<MaterialInventory> implements MaterialInventoryRepository {
    private static volatile MaterialInventoryRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return MaterialInventoryRepositoryImpl 인스턴스
     */

    public static synchronized MaterialInventoryRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new MaterialInventoryRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private MaterialInventoryRepositoryImpl() { super(MaterialInventory.class); }
}
