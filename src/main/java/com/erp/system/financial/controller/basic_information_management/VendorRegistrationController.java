package com.erp.system.financial.controller.basic_information_management;

import com.erp.system.common.DependencyInjector.Component;
import com.erp.system.common.DependencyInjector.Priority;
import com.erp.system.financial.model.basic_information_management.vendor_registration.Vendor;
import com.erp.system.financial.model.basic_information_management.vendor_registration.VendorType;
import com.erp.system.financial.service.basic_information_management.VendorRegistrationService;

import java.util.Collection;
import java.util.Optional;

@Component
@Priority(3)
public class VendorRegistrationController {
    private final VendorRegistrationService vendorRegistrationService;

    public VendorRegistrationController(VendorRegistrationService vendorRegistrationService) {
        this.vendorRegistrationService = vendorRegistrationService;
    }
    /**
     * 공급업체를 저장함
     * @param vendor 저장할 공급업체
     */
    public void saveVendor(Vendor vendor) {
        vendorRegistrationService.saveVendor(vendor);
    }

    /**
     * 공급업체 유형을 저장함
     * @param vendorType 저장할 공급업체 유형
     */
    public void saveVendorType(VendorType vendorType) {
        vendorRegistrationService.saveVendorType(vendorType);
    }

    /**
     * ID로 공급업체를 조회함
     * @param id 공급업체의 ID
     * @return 조회된 공급업체를 Optional로 반환
     */
    public Optional<Vendor> findVendorById(String id) {
        return vendorRegistrationService.findVendorById(id);
    }

    /**
     * 코드로 공급업체를 조회함
     * @param code 공급업체의 코드
     * @return 조회된 공급업체를 Optional로 반환
     */
    public Optional<Vendor> findVendorByCode(String code) {
        return vendorRegistrationService.findVendorByCode(code);
    }

    /**
     * ID로 공급업체 유형을 조회함
     * @param id 공급업체 유형의 ID
     * @return 조회된 공급업체 유형을 Optional로 반환
     */
    public Optional<VendorType> findVendorTypeById(String id) {
        return vendorRegistrationService.findVendorTypeById(id);
    }

    /**
     * 코드로 공급업체 유형을 조회함
     * @param code 공급업체 유형의 코드
     * @return 조회된 공급업체 유형을 Optional로 반환
     */
    public Optional<VendorType> findVendorTypeByCode(String code) {
        return vendorRegistrationService.findVendorTypeByCode(code);
    }

    /**
     * 모든 공급업체를 조회함
     * @return 저장된 모든 공급업체의 컬렉션
     */
    public Collection<Vendor> findAllVendors() {
        return vendorRegistrationService.findAllVendors();
    }

    /**
     * 모든 공급업체 유형을 조회함
     * @return 저장된 모든 공급업체 유형의 컬렉션
     */
    public Collection<VendorType> findAllVendorTypes() {
        return vendorRegistrationService.findAllVendorTypes();
    }
}