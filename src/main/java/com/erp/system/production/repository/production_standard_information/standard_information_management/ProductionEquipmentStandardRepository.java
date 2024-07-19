package com.erp.system.production.repository.production_standard_information.standard_information_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.standard_information_management.ProductionEquipmentStandard;

import java.util.List;

public interface ProductionEquipmentStandardRepository extends GenericRepository<ProductionEquipmentStandard> {
    @Override
    void save(ProductionEquipmentStandard entity);

    @Override
    List<ProductionEquipmentStandard> findAll();
}
