package com.erp.system.production.repository.master_data_management.routing.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.master_data_management.routing.Routing;
import com.erp.system.production.repository.master_data_management.routing.RoutingRepository;

public class RoutingRepositoryImpl extends GenericRepositoryImpl<Routing> implements RoutingRepository {
    private static volatile RoutingRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return RoutingRepositoryImpl 인스턴스
     */

    public static synchronized RoutingRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new RoutingRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private RoutingRepositoryImpl() { super(Routing.class); }
}
