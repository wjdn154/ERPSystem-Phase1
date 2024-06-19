package com.erp.system.production.repository.process_management;

import com.erp.system.common.generic_repository.GenericRepository;

/**
 * Process 엔티티에 대한 리포지토리 인터페이스.
 */
public interface ProcessRepository extends GenericRepository<Process> {
    @Override
    void save(Process entity);
}
