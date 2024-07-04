package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.model.dto.CompanyRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CompanyRegistrationServiceImplTest {
    private CompanyRegistrationService companyRegistrationService;
    private CompanyRepository companyRepository;
    private AddressRepository addressRepository;
    private ContactRepository contactRepository;
    private CorporateKindRepository corporateKindRepository;
    private CorporateTypeRepository corporateTypeRepository;
    private RepresentativeRepository representativeRepository;
    private TaxRepository taxRepository;

    // 테스트 실행 전 초기 설정
    @BeforeEach
    void setUp() {
        // 싱글톤 인스턴스를 사용하여 저장소 초기화
        DependencyInjector di = DependencyInjector.getInstance();

        companyRegistrationService = di.getInstance(CompanyRegistrationService.class);
        addressRepository = di.getInstance(AddressRepository.class);
        companyRepository = di.getInstance(CompanyRepository.class);
        contactRepository = di.getInstance(ContactRepository.class);
        corporateKindRepository = di.getInstance(CorporateKindRepository.class);
        corporateTypeRepository = di.getInstance(CorporateTypeRepository.class);
        representativeRepository = di.getInstance(RepresentativeRepository.class);
        taxRepository = di.getInstance(TaxRepository.class);

        addressRepository.reset();
        companyRepository.reset();
        contactRepository.reset();
        corporateKindRepository.reset();
        corporateTypeRepository.reset();
        representativeRepository.reset();
        taxRepository.reset();
    }

    @Test
    public void testRegisterCompany() {
        // Given: 테스트 데이터 설정
        CompanyRegistrationDto companyRegistrationDto = new CompanyRegistrationDto();
        companyRegistrationDto.setAddress("123 Main St");
        companyRegistrationDto.setHeadquartersAddress("456 Elm St");
        companyRegistrationDto.setBusinessPlace("대연동");
        companyRegistrationDto.setHeadquarters("영업동");
        companyRegistrationDto.setSme(true);
        companyRegistrationDto.setBusinessRegistrationNumber("100-200-300");
        companyRegistrationDto.setCorporateRegistrationNumber("400-500-600");
        companyRegistrationDto.setEstablishmentDate(LocalDate.of(2021, 1, 1));
        companyRegistrationDto.setName("Sample Company");
        companyRegistrationDto.setType("법인");
        companyRegistrationDto.setActive(true);
        companyRegistrationDto.setFiscalYearStart(LocalDate.of(2021, 1, 1));
        companyRegistrationDto.setFiscalYearEnd(LocalDate.of(2021, 12, 31));
        companyRegistrationDto.setFiscalCardinalNumber(1);
        companyRegistrationDto.setMainIndustryId("001");
        companyRegistrationDto.setBusinessPhone("010-1234-5678");
        companyRegistrationDto.setFax("010-8765-4321");
        companyRegistrationDto.setCorporateKindId("4");
        companyRegistrationDto.setCorporateTypeId("5");
        companyRegistrationDto.setRepresentativeName("홍길동");
        companyRegistrationDto.setIdNumber("900101-1234567");
        companyRegistrationDto.setForeign(false);
        companyRegistrationDto.setBusinessTaxOfficeId("1");   // << 새로추가된거
        companyRegistrationDto.setHeadquartersTaxOfficeId("2"); // << 새로 추가된거
        companyRegistrationDto.setLocalIncomeTaxOffice("부산시청"); // << 방법이바뀐거


        // When: 메소드 호출
        companyRegistrationService.registerCompany(companyRegistrationDto);

        // Then: 결과 검증
        // System.out.println(addressRepository.findById(String.valueOf(Address.idIndex-1)).get().toString());
        // System.out.println(companyRepository.findById(String.valueOf(Company.idIndex-1)).get().toString());
        // System.out.println(contactRepository.findById(String.valueOf(Contact.idIndex-1)).get().toString());
        // System.out.println(representativeRepository.findById(String.valueOf(Representative.idIndex-1)).get().toString());
        // System.out.println(taxRepository.findById(String.valueOf(Tax.idIndex-1)).get().toString());

        addressRepository.findById(String.valueOf(Address.idIndex-1)).ifPresent(address -> {
            assertEquals("123 Main St", address.getAddress());
            assertEquals("456 Elm St", address.getHeadquartersAddress());
            assertEquals("대연동", address.getBusinessPlace());
            assertEquals("영업동", address.getHeadquarters());
        });

        companyRepository.findById(String.valueOf(Company.idIndex-1)).ifPresent(company -> {
            assertEquals("Sample Company", company.getName());
            assertEquals("법인", company.getType());
            assertTrue(company.isActive());
            assertEquals(LocalDate.of(2021, 1, 1), company.getEstablishmentDate());
            assertEquals(LocalDate.of(2021, 1, 1), company.getFiscalYearStart());
            assertEquals(LocalDate.of(2021, 12, 31), company.getFiscalYearEnd());
            assertEquals(1, company.getFiscalCardinalNumber());
            assertEquals("001", company.getMainIndustryId());
            assertEquals("100-200-300", company.getBusinessRegistrationNumber());
            assertEquals("400-500-600", company.getCorporateRegistrationNumber());
            assertEquals("부산시청",company.getLocalIncomeTaxOffice());
            assertTrue(company.isSme());
        });

        contactRepository.findById(String.valueOf(Contact.idIndex-1)).ifPresent(contact -> {
            assertEquals("010-1234-5678", contact.getBusinessPhone());
            assertEquals("010-8765-4321", contact.getFax());
        });

        representativeRepository.findById(String.valueOf(Representative.idIndex-1)).ifPresent(representative -> {
            assertEquals("홍길동", representative.getName());
            assertEquals("900101-1234567", representative.getIdNumber());
            assertFalse(representative.isForeign());
        });


        taxRepository.findById("1").ifPresent(tax -> {
            assertNull(tax.getName());
        });

        taxRepository.findById("2").ifPresent(tax -> {
            assertNull(tax.getName());
        });

    }
}