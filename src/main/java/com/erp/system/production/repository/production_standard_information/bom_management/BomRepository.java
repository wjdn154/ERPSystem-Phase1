package com.erp.system.production.repository.production_standard_information.bom_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.production_standard_information.bom_management.Bom;

import java.util.List;

/**
 * 자재명세서 엔티티 리포지토리 IF
 */

public interface BomRepository extends GenericRepository<Bom> {
    @Override
    void save(Bom entity);

    @Override
    List<Bom> findAll();
}
