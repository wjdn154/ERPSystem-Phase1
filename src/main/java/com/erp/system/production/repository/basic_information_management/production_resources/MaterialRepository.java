package com.erp.system.production.repository.basic_information_management.production_resources;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.basic_information_management.production_resources.Material;

import java.util.List;

/**
 * 자재 기본 정보 엔티티 리포지토리 IF
 */

public interface MaterialRepository extends GenericRepository<Material> {
    @Override
    void save(Material entity);

    @Override
    List<Material>findAll();
}
