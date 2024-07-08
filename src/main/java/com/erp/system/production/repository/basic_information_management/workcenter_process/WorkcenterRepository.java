package com.erp.system.production.repository.basic_information_management.workcenter_process;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.basic_information_management.workcenter_process.Workcenter;

import java.util.List;

/**
 * 작업장 엔티티에 리포지터리 인터페이스
 */

public interface WorkcenterRepository extends GenericRepository<Workcenter> {
    @Override
    void save(Workcenter entity);

    @Override
    List<Workcenter> findAll();
}
