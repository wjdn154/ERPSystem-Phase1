package com.erp.system.production.repository.production_standard_information.bom_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.bom_management.Bom;
import com.erp.system.production.repository.production_standard_information.bom_management.BomRepository;

@Component
public class BomRepositoryImpl extends GenericRepositoryImpl<Bom> implements BomRepository {
    private BomRepositoryImpl() { super(Bom.class);}
}
