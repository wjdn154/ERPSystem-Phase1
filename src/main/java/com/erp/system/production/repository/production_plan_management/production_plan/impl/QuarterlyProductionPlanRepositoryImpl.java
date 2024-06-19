package com.erp.system.production.repository.production_plan_management.production_plan.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_plan_management.production_plan.QuarterlyProductionPlan;
import com.erp.system.production.repository.production_plan_management.production_plan.QuarterlyProductionPlanRepository;

public class QuarterlyProductionPlanRepositoryImpl extends GenericRepositoryImpl<QuarterlyProductionPlan> implements QuarterlyProductionPlanRepository {
    private static volatile QuarterlyProductionPlanRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return QuarterlyProductionPlanRepositoryImpl 인스턴스
     */

    public static synchronized QuarterlyProductionPlanRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new QuarterlyProductionPlanRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private QuarterlyProductionPlanRepositoryImpl() { super(QuarterlyProductionPlan.class); }
}
