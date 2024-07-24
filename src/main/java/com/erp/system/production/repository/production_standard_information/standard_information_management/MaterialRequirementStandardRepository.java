package com.erp.system.production.repository.production_standard_information.standard_information_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.standard_information_management.MaterialRequirementStandard;

import java.util.List;

public interface MaterialRequirementStandardRepository extends GenericRepository<MaterialRequirementStandard> {
    @Override
    void save(MaterialRequirementStandard entity);

    @Override
    List<MaterialRequirementStandard> findAll();
}
