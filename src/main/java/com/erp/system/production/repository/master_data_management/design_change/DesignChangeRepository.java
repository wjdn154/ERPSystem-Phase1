package com.erp.system.production.repository.master_data_management.design_change;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.master_data_management.design_change.DesignChange;

/**
 * DesignChange 엔티티에 대한 리포지토리 인터페이스.
 */
public interface DesignChangeRepository extends GenericRepository<DesignChange> {
    @Override
    void save(DesignChange entity);
}
