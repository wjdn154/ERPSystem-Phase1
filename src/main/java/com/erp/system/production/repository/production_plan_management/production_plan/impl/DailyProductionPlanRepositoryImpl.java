package com.erp.system.production.repository.production_plan_management.production_plan.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_plan_management.production_plan.DailyProductionPlan;
import com.erp.system.production.repository.production_plan_management.production_plan.DailyProductionPlanRepository;

public class DailyProductionPlanRepositoryImpl extends GenericRepositoryImpl<DailyProductionPlan> implements DailyProductionPlanRepository {
    private static volatile DailyProductionPlanRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return DailyProductionPlanRepositoryImpl 인스턴스
     */

    public static synchronized DailyProductionPlanRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DailyProductionPlanRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private DailyProductionPlanRepositoryImpl() { super(DailyProductionPlan.class); }
}
