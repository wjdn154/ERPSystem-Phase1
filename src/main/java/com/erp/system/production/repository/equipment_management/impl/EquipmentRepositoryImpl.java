package com.erp.system.production.repository.equipment_management.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.equipment_management.Equipment;
import com.erp.system.production.repository.equipment_management.EquipmentRepository;

public class EquipmentRepositoryImpl extends GenericRepositoryImpl<Equipment> implements EquipmentRepository {
    private static volatile EquipmentRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return EquipmentRepositoryImpl 인스턴스
     */

    public static synchronized EquipmentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new EquipmentRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private EquipmentRepositoryImpl() { super(Equipment.class); }
}
