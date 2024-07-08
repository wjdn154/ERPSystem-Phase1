package com.erp.system.production.service.work_order_management;

import com.erp.system.production.model.dto.RequestBasedPlanDto;

import java.util.List;

public interface RequestBasedPlanService {
    RequestBasedPlanDto getPlanById(String planId);
    List<RequestBasedPlanDto> getAllPlans();
    RequestBasedPlanDto createPlan(RequestBasedPlanDto requestBasedPlanDto);
    RequestBasedPlanDto updatePlan(String planId, RequestBasedPlanDto requestBasedPlanDto);
    void deletePlan(String planId);
}

