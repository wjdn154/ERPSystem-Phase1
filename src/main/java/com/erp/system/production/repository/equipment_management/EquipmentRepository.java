package com.erp.system.production.repository.equipment_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.equipment_management.Equipment;

/**
 *  Equipment 엔티티에 대한 리포지토리 인터페이스.
 */
public interface EquipmentRepository extends GenericRepository<Equipment> {
    @Override
    void save(Equipment entity);
}
