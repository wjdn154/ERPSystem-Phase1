package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.basic_information_management.company_registration.BusinessItem;
import com.erp.system.financial.model.basic_information_management.company_registration.Contact;
import com.erp.system.financial.model.basic_information_management.company_registration.Representative;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.dto.VendorRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VendorRegistrationServiceImpTest {
    VendorRegistrationService vendorRegistrationService;
    VendorRepository vendorRepository;
    ContactRepository contactRepository;
    AddressRepository addressRepository;
    RepresentativeRepository representativeRepository;
    BusinessTypeRepository businessTypeRepository;
    BusinessItemRepository businessItemRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        DependencyInjector injector = DependencyInjector.getInstance();

        vendorRegistrationService = injector.getInstance(VendorRegistrationService.class);
        vendorRepository = injector.getInstance(VendorRepository.class);
        contactRepository = injector.getInstance(ContactRepository.class);
        addressRepository = injector.getInstance(AddressRepository.class);
        representativeRepository = injector.getInstance(RepresentativeRepository.class);
        businessItemRepository = injector.getInstance(BusinessItemRepository.class);
        businessTypeRepository = injector.getInstance(BusinessTypeRepository.class);

        vendorRepository.reset();
        contactRepository.reset();
        addressRepository.reset();
        representativeRepository.reset();
        businessTypeRepository.reset();
        businessItemRepository.reset();
    }

    @Test
    void registerVendorTest () {

        // Given: 테스트 데이터 설정
        VendorRegistrationDto VendorDto = new VendorRegistrationDto();

        VendorDto.setDepartmentId("1");
        VendorDto.setManagerId("4");
        VendorDto.setRepresentativeName("허건호");
        VendorDto.setPersonalIdentificationNumber("971111-1111111");
        VendorDto.setForeign(false);
        VendorDto.setBusinessPhone("010-0001-0002");
        VendorDto.setFax("01-055-4468");
        VendorDto.setBusinessAddress("부산광역시 남구");
        VendorDto.setBusinessPostalCode("11651");
        VendorDto.setBusinessPlace("대연동5동");
        VendorDto.setHeadquarterAddress("부산광역시 남구");
        VendorDto.setHeadquarterPostalCode("11622");
        VendorDto.setHeadquarterPlace("대연1동");
        VendorDto.setBusinessItemId("1");
        VendorDto.setBusinessTypeId("1");
        VendorDto.setName("건호컴퍼니");
        VendorDto.setRegistrationNumber("116-116578-1120");
        VendorDto.setWebsite("https://naver.com");
        VendorDto.setContactPerson("홍성화");
        VendorDto.setEmail("test@naver.com");
        VendorDto.setBusinessStatus(Vendor.BusinessStatus.BUSINESS);
        VendorDto.setRelationship(Vendor.Relationship.SERVICEPROVIDER);

        // When: 거래처 등록
        vendorRegistrationService.registerVendor(VendorDto);

        // Then: 거래처가 성공적으로 등록되었는지 확인
        System.out.println("전송 객체 ::: " + VendorDto.toString());

        vendorRepository.findById(String.valueOf(Vendor.idIndex - 1)).ifPresent(vendor -> {
            System.out.println("저장 객체 ::: " + vendor.toString());
            assertEquals(VendorDto.getDepartmentId(), vendor.getDepartmentId());
            assertEquals(VendorDto.getManagerId(), vendor.getManagerId());
            assertEquals(VendorDto.getName(), vendor.getName());
            assertEquals(VendorDto.getRegistrationNumber(), vendor.getRegistrationNumber());
            assertEquals(VendorDto.getWebsite(), vendor.getWebsite());
            assertEquals(VendorDto.getContactPerson(), vendor.getContactPerson());
            assertEquals(VendorDto.getEmail(), vendor.getEmail());
            assertEquals(VendorDto.getBusinessStatus(), vendor.getBusinessStatus());
            assertEquals(VendorDto.getRelationship(), vendor.getRelationship());
        });

        addressRepository.findById(String.valueOf(Address.idIndex - 1)).ifPresent(address -> {
            System.out.println("저장 객체 ::: " + address.toString());
            assertEquals(VendorDto.getBusinessAddress(), address.getBusinessAddress());
            assertEquals(VendorDto.getBusinessPostalCode(), address.getBusinessPostalCode());
            assertEquals(VendorDto.getBusinessPlace(), address.getBusinessPlace());
            assertEquals(VendorDto.getHeadquarterAddress(), address.getHeadquarterAddress());
            assertEquals(VendorDto.getHeadquarterPostalCode(), address.getHeadquarterPostalCode());
            assertEquals(VendorDto.getHeadquarterPlace(), address.getHeadquarterPlace());
        });

        contactRepository.findById(String.valueOf(Contact.idIndex - 1)).ifPresent(contact -> {
            System.out.println("저장 객체 ::: " + contact.toString());
            assertEquals(VendorDto.getBusinessPhone(),contact.getBusinessPhone());
            assertEquals(VendorDto.getFax(),contact.getFax());
        });

        representativeRepository.findById(String.valueOf(Representative.idIndex - 1)).ifPresent(representative -> {
            System.out.println("저장 객체 ::: " + representative.toString());
            assertEquals(VendorDto.getRepresentativeName(),representative.getName());
            assertEquals(VendorDto.getPersonalIdentificationNumber(),representative.getIdNumber());
            assertEquals(VendorDto.isForeign(),representative.isForeign());
        });

        businessItemRepository.findById(VendorDto.getBusinessItemId()).ifPresent(businessItem -> {
            assertNull(businessItem.getName());
        });

        businessTypeRepository.findById(VendorDto.getBusinessTypeId()).ifPresent(businessType -> {
            businessType.toString();
            assertNull(businessType.getName());
        });






    }
}
