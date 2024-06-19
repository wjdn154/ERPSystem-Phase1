package com.erp.system.production.repository.equipment_management.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.equipment_management.MaintenanceHistory;
import com.erp.system.production.repository.equipment_management.MaintenanceHistoryRepository;

public class MaintenanceHistoryRepositoryImpl extends GenericRepositoryImpl<MaintenanceHistory> implements MaintenanceHistoryRepository {
    private static volatile MaintenanceHistoryRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return MaintenanceHistoryRepositoryImpl 인스턴스
     */

    public static synchronized MaintenanceHistoryRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new MaintenanceHistoryRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private MaintenanceHistoryRepositoryImpl() { super(MaintenanceHistory.class); }
}
