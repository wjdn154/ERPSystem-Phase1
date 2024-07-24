package com.erp.system.production.service.basic_information_management.factory.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.production.model.basic_information_management.factory.Factory;
import com.erp.system.production.model.dto.FactoryDto;
import com.erp.system.production.repository.basic_information_management.factory.FactoryRepository;
import com.erp.system.production.service.basic_information_management.factory.FactoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryServiceImplTest {
    private FactoryService factoryService;
    private FactoryRepository factoryRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스 사용해 저장소 초기화
        DependencyInjector di = DependencyInjector.getInstance();

        factoryService = di.getInstance(FactoryService.class);
        factoryRepository = di.getInstance(FactoryRepository.class);

        factoryRepository.reset();
    }

    @Test
    public void testRegisterFactory() {
        // Given: 테스트 데이터 설정
        FactoryDto factoryDto = new FactoryDto();
        factoryDto.setManagerId("123");
        factoryDto.setManagerDepartmentId("789");
        factoryDto.setType(Factory.Type.MANUFACTURING);
        factoryDto.setName("애플공장");
        factoryDto.setLocation("부산광역시 강서구 미음산단");
        factoryDto.setDescription("애플 하청 부품 제조");
        factoryDto.setContactNumber("010-1234-5678");

        // When: 메소드 호출
        factoryService.registerFactory(factoryDto);

        // Then: 결과 검증
        factoryRepository.findById(String.valueOf(Factory.idIndex - 1)).ifPresent(factory -> {
            assertEquals("애플공장", factory.getName());
            assertEquals("애플 하청 부품 제조", factory.getDescription());
            assertEquals("123", factory.getManagerId());
            assertEquals("789", factory.getManagerDepartmentId());
            assertEquals(Factory.Type.MANUFACTURING, factory.getType());
            assertEquals("부산광역시 강서구 미음산단", factory.getLocation());
            assertEquals("010-1234-5678", factory.getContactNumber());
        });
    }
}
