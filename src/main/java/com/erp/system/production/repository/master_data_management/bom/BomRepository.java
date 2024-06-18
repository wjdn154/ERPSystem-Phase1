package com.erp.system.production.repository.master_data_management.bom;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.master_data_management.bom.Bom;

/**
 * Bom 엔티티에 대한 리포지토리 인터페이스.
 */
public interface BomRepository extends GenericRepository<Bom> {
    @Override
    void save(Bom entity);
}
