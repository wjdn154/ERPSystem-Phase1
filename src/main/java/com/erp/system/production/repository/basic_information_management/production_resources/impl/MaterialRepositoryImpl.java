package com.erp.system.production.repository.basic_information_management.production_resources.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.basic_information_management.production_resources.Material;
import com.erp.system.production.repository.basic_information_management.production_resources.MaterialRepository;

@Component
public class MaterialRepositoryImpl extends GenericRepositoryImpl<Material> implements MaterialRepository {
    private MaterialRepositoryImpl() { super(Material.class);}
}
