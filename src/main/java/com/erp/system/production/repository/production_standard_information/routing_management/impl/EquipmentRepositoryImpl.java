package com.erp.system.production.repository.production_standard_information.routing_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.routing_management.Equipment;
import com.erp.system.production.repository.production_standard_information.routing_management.EquipmentRepository;

@Component
public class EquipmentRepositoryImpl extends GenericRepositoryImpl<Equipment> implements EquipmentRepository {
    private EquipmentRepositoryImpl() { super(Equipment.class);}
}
