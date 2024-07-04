package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.annotation.Component;
import com.erp.system.financial.model.basic_information_management.purchase_sales_slip.PurchaseSalesSlip;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.dto.PurchaseSalesSlipRegistrationDto;
import com.erp.system.financial.model.dto.VendorRegistrationDto;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;

@Component
public class VendorRegistrationServiceImpl implements VendorRegistrationService {
    private final VendorRepository vendorRepository;

    public VendorRegistrationServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    /**
     * 거래처 등록 메소드
     * @param dto 거래처 등록을 위한 전달 객체
     * @throws RuntimeException 등록 중 발생한 예외를 처리함
     */
    @Override
    public void registerVendor(VendorRegistrationDto dto) {
        try {
            Vendor vendor = createVendor(dto);
            vendorRepository.save(vendor);
        } catch (Exception e) {
            System.err.println("거래처 등록 중 에러 발생: " + e.getMessage());
            throw new RuntimeException("등록 실패", e);
        }
    }


    /**
     * 거래처 객체 생성.
     * @param dto 거래처 등록을 위한 정보가 담긴 DTO
     * @return 저장된 매출매입전표 객체
     */
    public Vendor createVendor(VendorRegistrationDto dto) {
        return new Vendor.Builder()
                .departmentId(dto.getDepartmentId())
                .managerId(dto.getManagerId())
                .name(dto.getName())
                .registrationNumber(dto.getRegistrationNumber())
                .personalIdentificationNumber(dto.getPersonalIdentificationNumber())
                .businessType(dto.getBusinessType())
                .businessItem(dto.getBusinessItem())
                .address(dto.getAddress())
                .representativeName(dto.getRepresentativeName())
                .concat(dto.getConcat())
                .fax(dto.getFax())
                .postalCode(dto.getPostalCode())
                .website(dto.getWebsite())
                .contactPerson(dto.getContactPerson())
                .email(dto.getEmail())
                .businessStatus(dto.getBusinessStatus())
                .relationship(dto.getRelationship())
                .build();
    }

}
