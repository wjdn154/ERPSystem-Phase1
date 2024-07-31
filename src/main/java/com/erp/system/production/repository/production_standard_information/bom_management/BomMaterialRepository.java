package com.erp.system.production.repository.production_standard_information.bom_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.bom_management.BomMaterial;

import java.util.List;

/**
 * 자재명세서와 자재 연결 리포지토리 인터페이스
 */
public interface BomMaterialRepository extends GenericRepository<BomMaterial> {
    @Override
    void save(BomMaterial entity);

    @Override
    List<BomMaterial> findAll();
}
