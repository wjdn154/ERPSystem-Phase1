package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.dto.VendorRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorRegistrationServiceImpTest {
    VendorRegistrationService vendorRegistrationService;
    VendorRepository vendorRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        DependencyInjector injector = DependencyInjector.getInstance();

        vendorRegistrationService = injector.getInstance(VendorRegistrationService.class);
        vendorRepository = injector.getInstance(VendorRepository.class);

        vendorRepository.reset();
    }

    @Test
    void registerVendorTest () {

        // Given: 테스트 데이터 설정
        VendorRegistrationDto VendorDto = new VendorRegistrationDto();

        VendorDto.setDepartmentId("1");
        VendorDto.setManagerId("4");
        VendorDto.setName("건호컴퍼니");
        VendorDto.setRegistrationNumber("1115-11561-200");
        VendorDto.setPersonalIdentificationNumber("971111-1111111");
        VendorDto.setBusinessType("정보기술");
        VendorDto.setBusinessItem("클라우드 서비스 운영");
        VendorDto.setAddress("강남");
        VendorDto.setRepresentativeName("허건호");
        VendorDto.setConcat("010-1234-5678");
        VendorDto.setFax("01-000-000");
        VendorDto.setPostalCode("44782");
        VendorDto.setWebsite("https://www.naver.com/");
        VendorDto.setContactPerson("홍성화");
        VendorDto.setEmail("Megazone@naver.com");
        VendorDto.setBusinessStatus(Vendor.BusinessStatus.BUSINESS);
        VendorDto.setRelationship(Vendor.Relationship.SERVICEPROVIDER);

        // When: 거래처 등록
        vendorRegistrationService.registerVendor(VendorDto);

        // Then: 거래처가 성공적으로 등록되었는지 확인
        vendorRepository.findById(String.valueOf(Vendor.idIndex - 1)).ifPresent(vendor -> {
            System.out.println("전송 객체 ::: " + VendorDto.toString());
            System.out.println("저장 객체 ::: " + vendor.toString());
            assertEquals(VendorDto.getDepartmentId(),vendor.getDepartmentId());
            assertEquals(VendorDto.getManagerId(),vendor.getManagerId());
            assertEquals(VendorDto.getName(),vendor.getName());
            assertEquals(VendorDto.getRegistrationNumber(),vendor.getRegistrationNumber());
            assertEquals(VendorDto.getPersonalIdentificationNumber(),vendor.getPersonalIdentificationNumber());
            assertEquals(VendorDto.getBusinessType(),vendor.getBusinessType());
            assertEquals(VendorDto.getBusinessItem(),vendor.getBusinessItem());
            assertEquals(VendorDto.getAddress(),vendor.getAddress());
            assertEquals(VendorDto.getRepresentativeName(),vendor.getRepresentativeName());
            assertEquals(VendorDto.getConcat(),vendor.getConcat());
            assertEquals(VendorDto.getFax(),vendor.getFax());
            assertEquals(VendorDto.getPostalCode(),vendor.getPostalCode());
        });

    }
}
