package com.erp.system.production.repository.production_standard_information.routing_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.routing_management.Equipment;

import java.util.List;

/**
 * 설비 정보 엔티티 리포지토리 IF
 */
public interface EquipmentRepository extends GenericRepository<Equipment> {
    @Override
    void save(Equipment entity);

    @Override
    List<Equipment> findAll();
}

