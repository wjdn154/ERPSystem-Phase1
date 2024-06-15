package com.erp.system.financial.service.basic_information_management.impl;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorRepository;
import com.erp.system.financial.repository.basic_information_management.vendor_registration.VendorTypeRepository;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(2)
public class VendorRegistrationServiceImpl implements VendorRegistrationService {
    private final VendorRepository vendorRepository;
    private final VendorTypeRepository vendorTypeRepository;

    public VendorRegistrationServiceImpl(VendorRepository vendorRepository,
                                         VendorTypeRepository vendorTypeRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorTypeRepository = vendorTypeRepository;
    }

    /**
     * 공급업체를 저장함
     * @param vendor 저장할 공급업체
     * @throws IllegalArgumentException 저장할 공급업체가 null일 경우
     */
    @Override
    public void saveVendor(Vendor vendor) {
        if (vendor == null) {
            throw new IllegalArgumentException("저장할 공급업체는 null일 수 없습니다.");
        }
        vendorRepository.save(vendor);
    }

    /**
     * 공급업체 유형을 저장함
     * @param vendorType 저장할 공급업체 유형
     * @throws IllegalArgumentException 저장할 공급업체 유형이 null일 경우
     */
    @Override
    public void saveVendorType(VendorType vendorType) {
        if (vendorType == null) {
            throw new IllegalArgumentException("저장할 공급업체 유형은 null일 수 없습니다.");
        }
        vendorTypeRepository.save(vendorType);
    }

    /**
     * ID로 공급업체를 조회함
     * @param id 공급업체의 ID
     * @return 조회된 공급업체를 Optional로 반환
     */
    @Override
    public Optional<Vendor> findVendorById(String id) {
        return vendorRepository.findById(id);
    }

    /**
     * 코드로 공급업체를 조회함
     * @param code 공급업체의 코드
     * @return 조회된 공급업체를 Optional로 반환
     */
    @Override
    public Optional<Vendor> findVendorByCode(String code) {
        return vendorRepository.findByCode(code);
    }

    /**
     * ID로 공급업체 유형을 조회함
     * @param id 공급업체 유형의 ID
     * @return 조회된 공급업체 유형을 Optional로 반환
     */
    @Override
    public Optional<VendorType> findVendorTypeById(String id) {
        return vendorTypeRepository.findById(id);
    }

    /**
     * 코드로 공급업체 유형을 조회함
     * @param code 공급업체 유형의 코드
     * @return 조회된 공급업체 유형을 Optional로 반환
     */
    @Override
    public Optional<VendorType> findVendorTypeByCode(String code) {
        return vendorTypeRepository.findByCode(code);
    }

    /**
     * 모든 공급업체를 조회함
     * @return 저장된 모든 공급업체의 컬렉션
     */
    @Override
    public Collection<Vendor> findAllVendors() {
        return vendorRepository.findAll();
    }

    /**
     * 모든 공급업체 유형을 조회함
     * @return 저장된 모든 공급업체 유형의 컬렉션
     */
    @Override
    public Collection<VendorType> findAllVendorTypes() {
        return vendorTypeRepository.findAll();
    }
}