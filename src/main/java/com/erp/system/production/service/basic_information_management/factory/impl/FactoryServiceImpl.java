package com.erp.system.production.service.basic_information_management.factory.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.production.model.basic_information_management.factory.Factory;
import com.erp.system.production.model.dto.FactoryDto;
import com.erp.system.production.repository.basic_information_management.factory.FactoryRepository;
import com.erp.system.production.service.basic_information_management.factory.FactoryService;

@Component
public class FactoryServiceImpl implements FactoryService {
    // Repository Instances
    private final FactoryRepository factoryRepository; // 생산관리 내 공장
    // TODO : EmployeeId 인사관리 내 직원
    // TODO : DepartmentId 인사관리 내 부서

    /**
     * 생성자 : 각 리포지토리의 인스턴스를 초기화
     */
    public FactoryServiceImpl(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;

    }

    /**
     * 공장 등록 메소드
     * @param factoryDto
     */
    @Override
    public void registerFactory(FactoryDto factoryDto) {
        try {
            Factory factory = createFactory(factoryDto);

            factoryRepository.save(factory);


        } catch (Exception e) {
            System.err.println("공장 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    private Factory createFactory(FactoryDto dto) {
        return new Factory.Builder()
                .managerId(dto.getManagerId())
                .managerDepartmentId(dto.getManagerDepartmentId())
                .type(dto.getType())
                .name(dto.getName())
                .location(dto.getLocation())
                .description(dto.getDescription())
                .contactNumber(dto.getContactNumber())
                .build();
    }

}
