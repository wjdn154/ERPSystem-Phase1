package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.company_registration.Address;
import com.erp.system.financial.model.basic_information_management.company_registration.Contact;
import com.erp.system.financial.model.basic_information_management.company_registration.Representative;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.dto.VendorRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.company_registration.AddressRepository;
import com.erp.system.financial.repository.basic_information_management.company_registration.ContactRepository;
import com.erp.system.financial.repository.basic_information_management.company_registration.RepresentativeRepository;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;
import com.erp.system.financial.service.basic_information_management.CompanyRegistrationService;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;

@Component
public class VendorRegistrationServiceImpl implements VendorRegistrationService {
    private final VendorRepository vendorRepository;
    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;
    private final RepresentativeRepository representativeRepository;
    private final CompanyRegistrationService companyRegistrationService;

    public VendorRegistrationServiceImpl(VendorRepository vendorRepository, AddressRepository addressRepository,
                                         ContactRepository contactRepository, RepresentativeRepository representativeRepository,
                                         CompanyRegistrationService companyRegistrationService) {
        this.vendorRepository = vendorRepository;
        this.addressRepository = addressRepository;
        this.contactRepository = contactRepository;
        this.representativeRepository = representativeRepository;
        this.companyRegistrationService = companyRegistrationService;
    }


    /**
     * 거래처 등록 메소드
     * @param dto 거래처 등록을 위한 전달 객체
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerVendor(VendorRegistrationDto dto) {
        try {
            Representative representative = createVendorRepresentative(dto);
            Contact contact = createVendorContact(dto);
            Address address = createVendorAddress(dto);
            Vendor vendor = createVendor(dto,representative.getId(),contact.getId(),address.getId());

            representativeRepository.save(representative);
            contactRepository.save(contact);
            addressRepository.save(address);
            vendorRepository.save(vendor);
        } catch (Exception e) {
            System.err.println("거래처 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }

    /**
     * 거래저의 대표자 정보 생성
     * @param dto 거래처 등록을 위한 정보 DTO
     * @return 거래저 정보에 저장될 거래처 대표자 정보 객체
     */
    public Representative createVendorRepresentative(VendorRegistrationDto dto) {
        return new Representative.Builder()
                .name(dto.getRepresentativeName())
                .idNumber(dto.getPersonalIdentificationNumber())
                .foreign(dto.isForeign())
                .build();
    }

    public Contact createVendorContact(VendorRegistrationDto dto) {
        return new Contact.Builder()
                .businessPhone(dto.getBusinessPhone())
                .fax(dto.getFax())
                .build();
    }

    public Address createVendorAddress(VendorRegistrationDto dto) {
        return new Address.Builder()
                .businessAddress(dto.getBusinessAddress())
                .businessPostalCode(dto.getBusinessPostalCode())
                .businessPlace(dto.getBusinessPlace())
                .headquarterAddress(dto.getHeadquarterAddress())
                .headquarterPostalCode(dto.getHeadquarterPostalCode())
                .headquarterPlace(dto.getHeadquarterPlace())
                .build();
    }

    /**
     * 거래처 객체 생성.
     * @param dto 거래처 등록을 위한 정보가 담긴 DTO
     * @return 저장된 매출매입전표 객체
     */
    public Vendor createVendor(VendorRegistrationDto dto, String saveRepresentativeId, String saveContactId,
                               String saveAddressId) {
        return new Vendor.Builder()
                .departmentId(dto.getDepartmentId())
                .managerId(dto.getManagerId())
                .representativeId(saveRepresentativeId)
                .contactId(saveContactId)
                .addressId(saveAddressId)
                .businessItemId(dto.getBusinessItemId())
                .businessTypeId(dto.getBusinessTypeId())
                .name(dto.getName())
                .registrationNumber(dto.getRegistrationNumber())
                .website(dto.getWebsite())
                .contactPerson(dto.getContactPerson())
                .email(dto.getEmail())
                .businessStatus(dto.getBusinessStatus())
                .relationship(dto.getRelationship())
                .build();
    }



}
