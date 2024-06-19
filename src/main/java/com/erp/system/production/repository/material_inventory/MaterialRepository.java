package com.erp.system.production.repository.material_inventory;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.material_inventory.Material;

/**
 * Material 엔티티에 대한 리포지토리 인터페이스.
 */
public interface MaterialRepository extends GenericRepository<Material> {
    @Override
    void save(Material entity);
}
