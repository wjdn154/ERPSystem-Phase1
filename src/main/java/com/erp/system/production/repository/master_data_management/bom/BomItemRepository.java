package com.erp.system.production.repository.master_data_management.bom;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.master_data_management.bom.BomItem;

/**
 * BomItem 엔티티에 대한 리포지토리 인터페이스.
 */
public interface BomItemRepository extends GenericRepository<BomItem> {
    @Override
    void save(BomItem entity);
}
