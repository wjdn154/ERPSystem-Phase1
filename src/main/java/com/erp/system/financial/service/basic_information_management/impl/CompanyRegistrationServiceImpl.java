package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.company_registration.*;
import com.erp.system.financial.model.dto.CompanyRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.company_registration.*;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;

@Component
public class CompanyRegistrationServiceImpl implements CompanyRegistrationService {
    // 리포지토리 인스턴스
    private final AddressRepository addressRepository;
    private final CompanyRepository companyRepository;
    private final ContactRepository contactRepository;
    private final CorporateKindRepository corporateKindRepository;
    private final CorporateTypeRepository corporateTypeRepository;
    private final RepresentativeRepository representativeRepository;
    private final TaxRepository taxRepository;

    /**
     * 생성자. 각 리포지토리의 인스턴스를 초기화함.
     */
    public CompanyRegistrationServiceImpl(AddressRepository addressRepository,
                                          CompanyRepository companyRepository,
                                          ContactRepository contactRepository,
                                          CorporateKindRepository corporateKindRepository,
                                          CorporateTypeRepository corporateTypeRepository,
                                          RepresentativeRepository representativeRepository,
                                          TaxRepository taxRepository) {
        this.addressRepository = addressRepository;
        this.companyRepository = companyRepository;
        this.contactRepository = contactRepository;
        this.corporateKindRepository = corporateKindRepository;
        this.corporateTypeRepository = corporateTypeRepository;
        this.representativeRepository = representativeRepository;
        this.taxRepository = taxRepository;
    }

    /**
     * 회사 등록 메소드. 주어진 DTO를 바탕으로 회사와 관련된 모든 정보를 생성하고 저장함.
     * @param companyRegistrationDto 회사 등록을 위한 정보가 담긴 DTO
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerCompany(CompanyRegistrationDto companyRegistrationDto) {
        try {
            Address address = createAddress(companyRegistrationDto);
            Contact contact = createContact(companyRegistrationDto);
            Representative representative = createRepresentative(companyRegistrationDto);
            Company company = createCompany(companyRegistrationDto, address.getId(), contact.getId(), representative.getId());

            addressRepository.save(address);
            contactRepository.save(contact);
            representativeRepository.save(representative);
            //taxRepository.save(taxOffice);
            companyRepository.save(company);
        } catch (Exception e) {
            System.err.println("회사 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    /**
     * 주소 정보를 생성하고 저장함.
     * @param dto 회사 등록을 위한 정보가 담긴 DTO
     * @return 저장된 주소 객체
     */
    private Address createAddress(CompanyRegistrationDto dto) {
        return new Address.Builder()
                .address(dto.getAddress())
                .headquartersAddress(dto.getHeadquartersAddress())
                .businessPlace(dto.getBusinessPlace())
                .headquarters(dto.getHeadquarters())
                .build();
    }

    /**
     * 연락처 정보를 생성하고 저장함.
     * @param dto 회사 등록을 위한 정보가 담긴 DTO
     * @return 저장된 연락처 객체
     */
    private Contact createContact(CompanyRegistrationDto dto) {
        return new Contact.Builder()
                .businessPhone(dto.getBusinessPhone())
                .fax(dto.getFax())
                .build();
    }

    /**
     * 대표자 정보를 생성하고 저장함.
     * @param dto 회사 등록을 위한 정보가 담긴 DTO
     * @return 저장된 대표자 객체
     */
    private Representative createRepresentative(CompanyRegistrationDto dto) {
        return new Representative.Builder()
                .name(dto.getRepresentativeName())
                .idNumber(dto.getIdNumber())
                .foreign(dto.isForeign())
                .build();
    }

    /**
     * 회사 정보를 생성하고 저장함.
     *
     * @param dto  회사 등록을 위한 정보가 담긴 DTO
     * @param addressId 생성된 주소의 ID
     * @param contactId 생성된 연락처의 ID
     * @param representativeId 생성된 대표자의 ID
     */
    private Company createCompany(CompanyRegistrationDto dto, String addressId, String contactId, String representativeId) {
        return new Company.Builder()
                .corporateTypeId(dto.getCorporateTypeId())
                .corporateKindsId(dto.getCorporateKindId())
                .representativeId(representativeId)
                .addressId(addressId)
                .contactId(contactId)
                .businessTaxOfficeId(dto.getBusinessTaxOfficeId())
                .headquartersTaxOfficeId(dto.getHeadquartersTaxOfficeId())
                .localIncomeTaxOffice(dto.getLocalIncomeTaxOffice())
                .isSme(dto.isSme())
                .businessRegistrationNumber(dto.getBusinessRegistrationNumber())
                .corporateRegistrationNumber(dto.getCorporateRegistrationNumber())
                .establishmentDate(dto.getEstablishmentDate())
                .name(dto.getName())
                .type(dto.getType())
                .active(dto.isActive())
                .fiscalYearStart(dto.getFiscalYearStart())
                .fiscalYearEnd(dto.getFiscalYearEnd())
                .fiscalCardinalNumber(dto.getFiscalCardinalNumber())
                .mainIndustryId(dto.getMainIndustryId())
                .build();
    }
}