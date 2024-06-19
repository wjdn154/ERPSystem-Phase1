package com.erp.system.production.repository.production_plan_management.production_plan.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_plan_management.production_plan.MonthlyProductionPlan;
import com.erp.system.production.repository.production_plan_management.production_plan.MonthlyProductionPlanRepository;

public class MonthlyProductionPlanRepositoryImpl extends GenericRepositoryImpl<MonthlyProductionPlan> implements MonthlyProductionPlanRepository {
    private static volatile MonthlyProductionPlanRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return MonthlyProductionPlanRepositoryImpl 인스턴스
     */

    public static synchronized MonthlyProductionPlanRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new MonthlyProductionPlanRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private MonthlyProductionPlanRepositoryImpl() { super(MonthlyProductionPlan.class); }
}
