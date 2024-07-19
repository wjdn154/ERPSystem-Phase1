package com.erp.system.production.service.work_order_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.production.model.dto.RequestBasedPlanDto;
import com.erp.system.production.model.work_order_management.ProductionRequest;
import com.erp.system.production.model.work_order_management.RequestBasedPlan;
import com.erp.system.production.repository.work_order_management.ProductionRequestRepository;
import com.erp.system.production.repository.work_order_management.RequestBasedPlanRepository;
import com.erp.system.production.service.work_order_management.RequestBasedPlanService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RequestBasedPlanServiceImpl implements RequestBasedPlanService {
    // Repository Instance
    private final ProductionRequestRepository productionRequestRepository;
    private final RequestBasedPlanRepository requestBasedPlanRepository;

    /**
     * 생성자. 각 Repo의 인스턴스 초기화
     * @param productionRequestRepository
     */
    // 생성자 주입 방식으로 Repository를 주입
    public RequestBasedPlanServiceImpl(ProductionRequestRepository productionRequestRepository,
                                       RequestBasedPlanRepository requestBasedPlanRepository) {
        this.productionRequestRepository = productionRequestRepository;
        this.requestBasedPlanRepository = requestBasedPlanRepository;
    }

    /**
     * 생산 계획 등록 메소드. 주어진 DTO 바탕으로 생산계획 관련 모든 정보 생성 및 저장.
     * @param requestBasedPlanDto 생산계획 등록 위한 정보가 담긴 DTO
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerRequestBasedPlan(RequestBasedPlanDto requestBasedPlanDto) {
        try {
            RequestBasedPlan requestBasedPlan = createRequestBasedPlan(requestBasedPlanDto);
            requestBasedPlanRepository.save(requestBasedPlan);

        } catch (Exception e) {
            System.err.println("생산계획 생성 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("생성 실패", e);
        }
    }

    /**
     *
     * @param dto 계획 생성 위한 정보가 담긴 DTO
     */
    // TODO 인사 FK => params
    private RequestBasedPlan createRequestBasedPlan(RequestBasedPlanDto dto) {
        return new RequestBasedPlan.Builder()
                .productionRequestId(dto.getProductionRequestId())
                .plannerDepartment(dto.getPlannerDepartment())
                .plannerName(dto.getPlannerName())
                .type(dto.getType())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .planDescription(dto.getPlanDescription())
                .status(dto.getStatus())
                .goalQuantity(dto.getGoalQuantity())
                .estimatedCost(dto.getEstimatedCost())
                .actualCost(dto.getActualCost())
                .build();
    }


}
