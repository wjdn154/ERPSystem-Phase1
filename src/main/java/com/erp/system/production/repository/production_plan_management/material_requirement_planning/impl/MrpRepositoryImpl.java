package com.erp.system.production.repository.production_plan_management.material_requirement_planning.impl;

import com.erp.system.common.generic_repository.impl.GenericRepositoryImpl;
import com.erp.system.production.model.production_plan_management.material_requirement_planning.Mrp;
import com.erp.system.production.repository.production_plan_management.material_requirement_planning.MrpRepository;

public class MrpRepositoryImpl extends GenericRepositoryImpl<Mrp> implements MrpRepository {
    private static volatile MrpRepositoryImpl instance; // 싱글톤 인스턴스 저장할 변수

    /**
     * 싱글톤 인스턴스 반환.
     * @return MrpRepositoryImpl 인스턴스
     */

    public static synchronized MrpRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new MrpRepositoryImpl();
        }
        return instance;
    }

    /**
     * private 생성자를 사용하여 싱글톤 패턴을 구현 (클래스가 싱글톤 패턴을 따르도록 보장하기 위해서)
     */
    private MrpRepositoryImpl() { super(Mrp.class); }
}
