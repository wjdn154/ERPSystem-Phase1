package com.erp.system.production.service.work_order_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.production.model.dto.RequestBasedPlanDto;
import com.erp.system.production.model.work_order_management.RequestBasedPlan;
import com.erp.system.production.repository.work_order_management.RequestBasedPlanRepository;
import com.erp.system.production.service.work_order_management.RequestBasedPlanService;

import java.util.List;
import java.util.stream.Collectors;

// TODO: resolve error and complete logic after generating excel table examples of models

@Component
public class RequestBasedPlanServiceImpl implements RequestBasedPlanService {
    private final RequestBasedPlanRepository requestBasedPlanRepository;

    public RequestBasedPlanServiceImpl(RequestBasedPlanRepository requestBasedPlanRepository) {
        this.requestBasedPlanRepository = requestBasedPlanRepository;
    }

    // Custom Exception Defined Within the Class
    private class PlanNotFoundException extends RuntimeException {
        public PlanNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public RequestBasedPlanDto getPlanById(String planId) {
        RequestBasedPlan plan = requestBasedPlanRepository.findById(planId)
                .orElseThrow(() -> new PlanNotFoundException("Plan not found"));
        return convertToDto(plan);
    }

    @Override
    public List<RequestBasedPlanDto> getAllPlans() {
        List<RequestBasedPlan> plans = requestBasedPlanRepository.findAll();
        return plans.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public RequestBasedPlanDto createPlan(RequestBasedPlanDto requestBasedPlanDto) {
        RequestBasedPlan plan = convertToEntity(requestBasedPlanDto);
        RequestBasedPlan savedPlan = requestBasedPlanRepository.save(plan);
        return convertToDto(savedPlan);
    }

    @Override
    public RequestBasedPlanDto updatePlan(String planId, RequestBasedPlanDto requestBasedPlanDto) {
        RequestBasedPlan existingPlan = requestBasedPlanRepository.findById(planId)
                .orElseThrow(() -> new PlanNotFoundException("Plan not found"));
        updateEntity(existingPlan, requestBasedPlanDto);
        RequestBasedPlan updatedPlan = requestBasedPlanRepository.save(existingPlan);
        return convertToDto(updatedPlan);
    }

    @Override
    public void deletePlan(String planId) {
        RequestBasedPlan plan = requestBasedPlanRepository.findById(planId)
                .orElseThrow(() -> new PlanNotFoundException("Plan not found"));
        requestBasedPlanRepository.delete(plan);
    }

    private RequestBasedPlanDto convertToDto(RequestBasedPlan plan) {
        RequestBasedPlanDto dto = new RequestBasedPlanDto();
        dto.setId(plan.getId());
        dto.setProductionRequestId(plan.getProductionRequestId());
        dto.setType(plan.getType());
        dto.setStartDate(plan.getStartDate());
        dto.setEndDate(plan.getEndDate());
        dto.setPlanDescription(plan.getPlanDescription());
        dto.setPlannerDepartment(plan.getPlannerDepartment());
        dto.setPlannerName(plan.getPlannerName());
        dto.setStatus(plan.getStatus());
        dto.setGoalQuantity(plan.getGoalQuantity());
        dto.setEstimatedCost(plan.getEstimatedCost());
        dto.setActualCost(plan.getActualCost());
        return dto;
    }

    /*
    private RequestBasedPlan convertToEntity(RequestBasedPlanDto dto) {
        RequestBasedPlan plan = new RequestBasedPlan();
        plan.setId(dto.getId());
        plan.setProductionRequestId(dto.getProductionRequestId());
        plan.setType(dto.getType());
        plan.setStartDate(dto.getStartDate());
        plan.setEndDate(dto.getEndDate());
        plan.setPlanDescription(dto.getPlanDescription());
        plan.setPlannerDepartment(dto.getPlannerDepartment());
        plan.setPlannerName(dto.getPlannerName());
        plan.setStatus(dto.getStatus());
        plan.setGoalQuantity(dto.getGoalQuantity());
        plan.setEstimatedCost(dto.getEstimatedCost());
        plan.setActualCost(dto.getActualCost());
        return plan;
    }

    private void updateEntity(RequestBasedPlan existingPlan, RequestBasedPlanDto dto) {
        existingPlan.setProductionRequestId(dto.getProductionRequestId());
        existingPlan.setType(dto.getType());
        existingPlan.setStartDate(dto.getStartDate());
        existingPlan.setEndDate(dto.getEndDate());
        existingPlan.setPlanDescription(dto.getPlanDescription());
        existingPlan.setPlannerDepartment(dto.getPlannerDepartment());
        existingPlan.setPlannerName(dto.getPlannerName());
        existingPlan.setStatus(dto.getStatus());
        existingPlan.setGoalQuantity(dto.getGoalQuantity());
        existingPlan.setEstimatedCost(dto.getEstimatedCost());
        existingPlan.setActualCost(dto.getActualCost());
    }

     */
}
