package com.erp.system.production.repository.production_standard_information.standard_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_standard_information.standard_information_management.MaterialRequirementStandard;
import com.erp.system.production.repository.production_standard_information.standard_information_management.MaterialRequirementStandardRepository;

@Component
public class MaterialRequirementStandardRepositoryImpl extends GenericRepositoryImpl<MaterialRequirementStandard> implements MaterialRequirementStandardRepository {
    private MaterialRequirementStandardRepositoryImpl() { super(MaterialRequirementStandard.class);}
}
