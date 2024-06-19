package com.erp.system.production.repository.master_data_management.routing.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.master_data_management.routing.RoutingStep;
import com.erp.system.production.repository.master_data_management.routing.RoutingStepRepository;

public class RoutingStepRepositoryImpl extends GenericRepositoryImpl<RoutingStep> implements RoutingStepRepository {
    private static volatile RoutingStepRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return RoutingStepRepositoryImpl 인스턴스
     */

    public static synchronized RoutingStepRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RoutingStepRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private RoutingStepRepositoryImpl() { super(RoutingStep.class); }
}
