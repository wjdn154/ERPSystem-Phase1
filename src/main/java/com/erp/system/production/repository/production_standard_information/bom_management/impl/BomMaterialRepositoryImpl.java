package com.erp.system.production.repository.production_standard_information.bom_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.bom_management.BomMaterial;
import com.erp.system.production.repository.production_standard_information.bom_management.BomMaterialRepository;

@Component
public class BomMaterialRepositoryImpl extends GenericRepositoryImpl<BomMaterial> implements BomMaterialRepository {
    private BomMaterialRepositoryImpl() { super(BomMaterial.class);}
}
