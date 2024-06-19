package com.erp.system.production.repository.process_management.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.process_management.ProductionPerformance;
import com.erp.system.production.repository.process_management.ProductionPerformanceRepository;

public class ProductionPerformanceRepositoryImpl extends GenericRepositoryImpl<ProductionPerformance> implements ProductionPerformanceRepository {
    private static volatile ProductionPerformanceRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return ProductionPerformanceRepositoryImpl 인스턴스
     */

    public static synchronized ProductionPerformanceRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ProductionPerformanceRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private ProductionPerformanceRepositoryImpl() { super(ProductionPerformance.class); }
}
