package com.erp.system.production.repository.basic_information_management.workcenter_process;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.basic_information_management.workcenter_process.ProductionProcess;

import java.util.List;

/**
 * 생산공정 엔티티 리포지토리 인터페이스
 */

public interface ProductionProcessRepository extends GenericRepository<ProductionProcess> {
    @Override
    void save(ProductionProcess entity);

    @Override
    List<ProductionProcess> findAll();
}
