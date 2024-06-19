package com.erp.system.production.repository.equipment_management;

import com.erp.system.common.generic_repository.GenericRepository;
import com.erp.system.production.model.equipment_management.MaintenanceHistory;

/**
 * MaintenanceHistory 엔티티에 대한 리포지토리 인터페이스.
 */
public interface MaintenanceHistoryRepository extends GenericRepository<MaintenanceHistory> {
    @Override
    void save(MaintenanceHistory entity);
}
