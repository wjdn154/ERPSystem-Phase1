package com.erp.system.production.service.basic_information_management.factory.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.production.model.basic_information_management.factory.Factory;
import com.erp.system.production.model.dto.FactoryDto;
import com.erp.system.production.service.basic_information_management.factory.FactoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryServiceImplTest {
    public enum Type {
        MANUFACTURING, ASSEMBLY, PACKAGING, HYBRID, DISTRIBUTION_CENTER, R_AND_D_CENTER
    }

    private String managerId; // 공장 관리자 ID (FK, 인사 Employee.id)
    private String managerDepartmentId; // 공장 관리자 부서 ID (FK, 인사 Department.id)
    private Factory.Type type; // 공장 구분( 제조 공장, 조립 공장, 포장 공장, 분배 센터, 연구 개발 센터 )
    private String name; // 공장 이름 (not null)
    private String location; // 공장 위치 (not null)
    private String description; // 공장 설명
    private String contactNumber; // 공장 연락처

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스 사용해 저장소 초기화
        DependencyInjector di = DependencyInjector.getInstance();

        factoryService = di.getInstance(FactoryService.class);
    }

    @Test
    public void testRegisterFactory() {
        // Given: 테스트 데이터 설정
        FactoryDto factoryDto = new FactoryDto();
        factoryDto.setName("애플공장");
        factoryDto.setDescription("애플 하청 부품 제조");

        // When: 메소드 호출
        factoryService.registerFactory(factoryDto);

        // Then: 결과 검증
        factoryRepository.findById(String.valueOf(Factory.idIndex-1)).ifPresent(name -> {
           assertEquals("", factoryDto.getName());
           assertEquals("", factoryDto.getName());
           assertEquals("", factoryDto.getName());
           assertEquals("", factoryDto.getName());
           assertEquals("", factoryDto.getName());
        });
    }
}
