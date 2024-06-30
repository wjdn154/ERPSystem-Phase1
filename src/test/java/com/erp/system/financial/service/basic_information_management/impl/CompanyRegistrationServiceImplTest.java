package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector;
import com.erp.system.common.ERPDataInitializer;
import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.model.dto.CompanyRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.repository.basic_information_management.purchase_sales_slip.EntryRepository;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

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
        CompanyRegistrationDto dto = new CompanyRegistrationDto();
        dto.setAddress("123 Main St");
        dto.setHeadquartersAddress("456 Elm St");
        dto.setBusinessPlace("대연동");
        dto.setHeadquarters("영업동");
        dto.setSme(true);
        dto.setBusinessRegistrationNumber("100-200-300");
        dto.setCorporateRegistrationNumber("400-500-600");
        dto.setEstablishmentDate(LocalDate.of(2021, 1, 1));
        dto.setName("Sample Company");
        dto.setType("법인");
        dto.setActive(true);
        dto.setFiscalYearStart(LocalDate.of(2021, 1, 1));
        dto.setFiscalYearEnd(LocalDate.of(2021, 12, 31));
        dto.setFiscalCardinalNumber(1);
        dto.setMainIndustryId("001");
        dto.setBusinessPhone("010-1234-5678");
        dto.setFax("010-8765-4321");
        dto.setCorporateKindId("4");
        dto.setCorporateTypeId("5");
        dto.setRepresentativeName("홍길동");
        dto.setIdNumber("900101-1234567");
        dto.setForeign(false);
        dto.setLocalIncomeTaxOffice("부산시청");

        // When: 메소드 호출
        companyRegistrationService.registerCompany(dto);

        // Then: 결과 검증
        System.out.println(addressRepository.findById(String.valueOf(Address.idIndex-1)).get().toString());
        System.out.println(companyRepository.findById(String.valueOf(Company.idIndex-1)).get().toString());
        System.out.println(contactRepository.findById(String.valueOf(Contact.idIndex-1)).get().toString());
        System.out.println(representativeRepository.findById(String.valueOf(Representative.idIndex-1)).get().toString());
        System.out.println(taxRepository.findById(String.valueOf(Tax.idIndex-1)).get().toString());

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

        taxRepository.findById(String.valueOf(Tax.idIndex-1)).ifPresent(tax -> {
            assertEquals("부산시청", tax.getLocalIncomeTaxOffice());
        });
    }
}